package com.kyrie.bootshiro.controller;

import com.kyrie.bootshiro.entity.SysUser;
import com.kyrie.bootshiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/23 10:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private SysUserService  sysUserService;

    @PostMapping("/add")
    public String insertUser(SysUser sysUser){

        int result = sysUserService.insert(sysUser);
        if(result > 0){
            return  "添加成功";

        }else {
            return  "操作失败";
        }
    }
}
