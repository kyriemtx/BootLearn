package com.kyrie.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/23 17:26
 * @Version 1.0
 **/
@RestController
public class LoginController {


    @PostMapping("/login")
    public String login(){
        return "hello,spring security";
    }
}
