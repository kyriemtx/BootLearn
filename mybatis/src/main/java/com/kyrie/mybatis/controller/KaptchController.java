package com.kyrie.mybatis.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName KaptchController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/29 17:26
 * @Version 1.0
 **/
@Controller
public class KaptchController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;



    @RequestMapping("/imgvrifyControllerDefaultKaptcha")
    public ModelAndView imgvrifyControllerDefaultKaptcha(HttpServletRequest request,HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        String rightCode = (String) request.getSession().getAttribute("right");
        String tryCode = request.getParameter("tryCode");
        System.out.println("开始验证验证码:-------------------");
        System.err.println("用户验证码"+tryCode+";正确的验证码："+rightCode);
        if(!rightCode.equalsIgnoreCase(tryCode)){
            modelAndView.addObject("info","验证码有误");
            modelAndView.setViewName("login");
        }else {
            modelAndView.addObject("info","验证通过");
            modelAndView.setViewName("index");
        }
        return  modelAndView;
    }
    @RequestMapping("/toIndex")
    public String toIndex(){
        return  "index";
    }

}
