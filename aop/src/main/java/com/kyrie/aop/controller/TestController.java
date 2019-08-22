package com.kyrie.aop.controller;

import com.kyrie.aop.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 15:40
 * @Version 1.0
 **/
@RestController
public class TestController {



    @Log
    @GetMapping("/one")
    public String  methodOne(String name) {

        String nae = "sssssss";
        return  "测试";

    }

    @Log("执行方法二")
    @GetMapping("/two")
    public void methodTwo() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Log("执行方法三")
    @GetMapping("/three")
    public void methodThree(String name, String age) {

    }
}
