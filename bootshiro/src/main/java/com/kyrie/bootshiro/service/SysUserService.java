package com.kyrie.bootshiro.service;

import com.kyrie.bootshiro.entity.SysUser;
import com.kyrie.bootshiro.mapperr.SysUserMapper;
import com.kyrie.bootshiro.util.MD5Utils;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName SysUserService
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 22:07
 * @Version 1.0
 **/
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    private static final String SALT = "kyrie";

    /**
     * 查询用户
     * @param userName
     * @return
     */
    public SysUser findByUserName(String userName){
        return sysUserMapper.findByUserName(userName);

    }

    /**
     * 新增
     * @param user
     * @return
     */
    public int insert(SysUser user){
        //盐值
        String salt = ByteSource.Util.bytes(SALT).toString();
        //加密后的密码
        String newPassword = MD5Utils.encrypt(user.getUserName(),user.getPassword());
        user.setSalt(salt);
        user.setPassword(newPassword);
        return  sysUserMapper.insert(user);

    }
}
