package com.kyrie.mybatis.controller;

import com.kyrie.mybatis.entity.Permission;
import com.kyrie.mybatis.entity.Role;
import com.kyrie.mybatis.entity.User;
import com.kyrie.mybatis.service.UserService;
import lombok.experimental.PackagePrivate;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName UserController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/30 11:31
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public String insertUser(User user){
        User user1 = userService.findByUsername(user.getUsername());
        if(user1 == null){
            int result =  userService.inserUser(user);
            if(result>0){
                return  "操作成功";
            }else {
                return "操作失败";
            }
        }else {
            return "该用户已存在，请直接登陆！！";
        }
    }

    /**
     * 根据id查询
     * @param userId
     * @return
     */
    @GetMapping("/byId")
    @ResponseBody
    public User findByUserId(String userId){
        User user = userService.selectByPrimaryKey(userId);
        if(user == null){
            return null;
        }else {
            return user;
        }
    }

    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    @GetMapping("/roles")
    @ResponseBody
    public List<Role> findRoleList(String userId){
        User user = userService.selectByPrimaryKey(userId);
        if(user != null){
            List<Role> roles = userService.findRoleList(userId);
            int size = roles.size();
            return roles;
        }else {
            return  null;
        }

    }

    @GetMapping("/per")
    @ResponseBody
    public List<Permission> findPermissionList(String userId){
        User user = userService.selectByPrimaryKey(userId);
        if(user != null){
            List<Permission> permissions = userService.findPermissionList(userId);
            int size = permissions.size();
            return permissions;
        }else {
            return  null;
        }
    }

}
