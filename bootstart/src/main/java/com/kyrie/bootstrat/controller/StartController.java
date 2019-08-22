package com.kyrie.bootstrat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName StartController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 10:08
 * @Version 1.0
 **/
@RestController
public class StartController {

    @GetMapping("/test")
    public String test(){
        return "看到我，说明你已经启动成功了！！！恭喜你";
    }
}
