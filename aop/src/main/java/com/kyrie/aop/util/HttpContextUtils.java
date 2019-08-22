package com.kyrie.aop.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HttpContextUtils
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 15:19
 * @Version 1.0
 **/
public class HttpContextUtils {
    public static HttpServletRequest getHttpServletRequset(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    }
}
