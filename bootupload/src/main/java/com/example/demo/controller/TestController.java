package com.example.demo.controller;

import com.example.demo.request.UserRequestDTO;
import com.example.demo.response.UserResponseBO;
import com.example.demo.response.UserResponseDTO;
import com.example.demo.service.UserService;
import com.example.demo.util.BaseConverter;
import com.example.demo.util.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/29 14:16
 * @Version 1.0
 **/
@RestController
public class TestController {

    @Autowired
    private UserService userService;
    @GetMapping("/test")
    public UserResponseDTO test(){
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setProdId("11111");
        userRequestDTO.setStr1("新增字段");
        userRequestDTO.setSysId("前三");
        userRequestDTO.setTrancId("1000000000000");
        userRequestDTO.setTermOrdId("201908291504345");
        //dto转bo执行业务逻辑
        BaseConverter baseConverter  = new BaseConverter();
        UserResponseBO userResponseBO = userService.getUser(baseConverter.userRequestDtoToBO(userRequestDTO));
        //业务逻辑返回的对象转成dto返回

        IPUtils ipUtils = new IPUtils();

        return baseConverter.userResponseBoToDTO(userResponseBO);
    }

}
