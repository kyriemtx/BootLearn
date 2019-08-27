package com.kyrie.layui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/27 14:57
 * @Version 1.0
 **/
@Controller
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
