package com.kyrie.url.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MainController
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/9/30 9:52
 * @Version 1.0
 **/
@RestController
@RequestMapping("main")
public class MainController {

    @GetMapping("/hello")
    public String hello(String name){
        return "欢迎你！！" + name;
    }

}
