package com.kyrie.bootshiro.controller;

import com.kyrie.bootshiro.BootShiroApplication;
import com.kyrie.bootshiro.entity.SysUser;
import com.kyrie.bootshiro.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @ClassName LoginController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 22:12
 * @Version 1.0
 **/
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String  login(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("root",request.getContextPath());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            return "index";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            request.setAttribute("msg","用户名不存在");
        }catch (IncorrectCredentialsException e){
            request.setAttribute("msg","密码错误");
        }
        return  "login";
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/login";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }
}
