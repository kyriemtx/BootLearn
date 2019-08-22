package com.kyrie.config.controller;

import com.kyrie.config.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 10:25
 * @Version 1.0
 **/
@RestController
public class ConfigController {

    @Autowired
    private TestConfig testConfig;

    @GetMapping("/dev")
    public String test(){
        return  "开发环境："+"获取到用户名：" + testConfig.getName() + "，他的年龄是：" + testConfig.getAge();

    }

    @GetMapping("/pro")
    public String pro(){
        return  "生产环境："+"获取到用户名：" + testConfig.getName() + "，他的年龄是：" + testConfig.getAge();
    }

}
