package com.kyrie.aop.aspect;

import com.kyrie.aop.annotation.Log;
import com.kyrie.aop.entity.SysLog;
import com.kyrie.aop.service.SysLogService;
import com.kyrie.aop.util.HttpContextUtils;
import com.kyrie.aop.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @ClassName LogAspect
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 14:56
 * @Version 1.0
 **/
@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogService sysLogService;

    //定义切点@Pointcut
    //    //在注解的位置切入代码

    @Pointcut("@annotation(com.kyrie.aop.annotation.Log)")
    public void logPoinCut(){

    }

    @Around("logPoinCut()")
    public void around(ProceedingJoinPoint point){
        long beginTime = System.currentTimeMillis();
        try {
            //执行方法
            point.proceed();
        }catch (Throwable e){
            e.printStackTrace();

        }
        //执行时长
        long time = System.currentTimeMillis()-beginTime;
        //保存日志
        saveLog(point,time);

    }

    public void saveLog(ProceedingJoinPoint joinpoint,long time){
        MethodSignature signature = (MethodSignature) joinpoint.getSignature();
         java.lang.reflect.Method method = signature.getMethod();
         SysLog sysLog = new SysLog();
        Log logAnnotation = method.getAnnotation(Log.class);
        if(logAnnotation != null){
            //注解上的描述
            sysLog.setOperation(logAnnotation.value());
        }
        //请求的方法
        String className = joinpoint.getTarget().getClass().getName();
        //请求的方法名
        String methodName = signature.getName();
        sysLog.setMethod(className+"."+methodName+"()");
        //请求的方法参数值
        Object[] args = joinpoint.getArgs();
        //请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if(args != null && paramNames != null){
            String params = "";
            for(int i = 0; i < args.length;i++){
                params +="" + paramNames[i]+":"+args[i];
            }
            sysLog.setParams(params);

        }
        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequset();
        //获取ip
        sysLog.setIp(IPUtils.getIpAddr(request));

        //模拟一个用户名
        sysLog.setUsername("kyrie");
        sysLog.setTime(new Date());
        Date date = new Date();
        sysLog.setCreatetime(date);
        sysLog.setId(System.currentTimeMillis());
        //保存日志
        sysLogService.saveSysLog(sysLog);

    }
}
