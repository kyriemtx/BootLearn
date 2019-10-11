package com.kyrie.tomysql.service;

import com.kyrie.tomysql.dao.UserMapper;
import com.kyrie.tomysql.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserSerice
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/11 9:39
 **/
@Service
@Slf4j
public class UserSerice {

    @Autowired
    private UserMapper userMapper;

    public String insertUser(User user) {
        int result = userMapper.insert(user);
        if (result > 0) {
            return "写入用户实体成功--------------------------------";
        } else {
            return "写入用户实体失败--------------------------------------";
        }
    }

}
