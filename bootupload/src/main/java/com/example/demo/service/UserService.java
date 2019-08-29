package com.example.demo.service;

import com.example.demo.request.UserRequestBO;
import com.example.demo.response.UserResponseBO;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description
 * @Author Kyrie
 * @Date 2019/8/29 14:22
 * @Version 1.0
 **/
@Service
public class UserService {

    public UserResponseBO getUser(UserRequestBO userRequestBO){
        UserResponseBO userResponseBO = new UserResponseBO();
        userResponseBO.setRestCode("00000");
        userResponseBO.setRestDesc("请求成功");
        userResponseBO.setSysId(userRequestBO.getSysId());
        userResponseBO.setTrancId(userRequestBO.getTrancId());
        return userResponseBO;

    }
}
