package com.kyrie.mybatis.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.kyrie.mybatis.service.UserService;
import com.kyrie.mybatis.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @ClassName LoginController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/29 16:51
 * @Version 1.0
 **/
@Controller
public class LoginController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String vercode = request.getParameter("vercode");
        String rightCode = (String)request.getSession().getAttribute("right");
        if(vercode.equalsIgnoreCase(rightCode)){
            String newPassword = MD5Utils.encrypt(username,password);
            UsernamePasswordToken token = new UsernamePasswordToken(username,newPassword);
            org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
            try{
                subject.login(token);
                return "index";
            }catch (UnknownAccountException e){
                e.printStackTrace();
                request.setAttribute("msg","用户名不存在");
            }catch (IncorrectCredentialsException e){
                request.setAttribute("msg","密码错误");
            }
        }else {
            return "验证码有误，请重新输入！";
        }
      return "index";
    }

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest request, HttpServletResponse response)throws Exception{
        try {
            //生成验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            System.err.println("生成的验证码是："+createText);
            request.getSession().setAttribute("right",createText);
            //使用生成的验证码字符串返回一个BufferImage对象并转为byte写入byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            //定义response输出类型为image、jpeg类型，使用response输出流输出图片的byte数组
            response.setHeader("Cache-Control","no-store");
            response.setHeader("Pragma","no-cache");
            response.setDateHeader("Expires",0);
            response.setContentType("image/jpeg");
            ServletOutputStream responseOutputStream = response.getOutputStream();
            ImageIO.write(challenge,"jpg",responseOutputStream);
            responseOutputStream.flush();
            responseOutputStream.close();
        }catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
