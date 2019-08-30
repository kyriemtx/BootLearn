package com.kyrie.mybatis.service;

import com.kyrie.mybatis.entity.Permission;
import com.kyrie.mybatis.entity.Role;
import com.kyrie.mybatis.entity.User;
import com.kyrie.mybatis.entity.UserKey;
import com.kyrie.mybatis.mapperr.UserMapper;
import com.kyrie.mybatis.util.MD5Utils;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName UserService
 * @Description
 * @Author Kyrie
 * @Date 2019/8/30 10:58
 * @Version 1.0
 **/
@Service
public class UserService {

    private static final String SALT = "uncle drew";

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     * @param user
     * @return
     */
    public int inserUser(User user){
        //利用用户名加盐
        String salt = ByteSource.Util.bytes(SALT).toString();
        //加密后的密码
        String newPassword = MD5Utils.encrypt(user.getUsername(),user.getPassword());
        user.setSalt(salt);
        user.setPassword(newPassword);
        return  userMapper.insert(user);
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public User findByUsername(String username){
        return userMapper.findByUsername(username);
    }

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    public User selectByPrimaryKey(String userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<Role> findRoleList(String userId){
        return  userMapper.findRoleList(userId);
    }


    public List<Permission> findPermissionList(String userId){
        return  userMapper.findPermissionList(userId);

    }


}
