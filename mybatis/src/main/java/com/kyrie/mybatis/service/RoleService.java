package com.kyrie.mybatis.service;

import com.kyrie.mybatis.entity.Role;
import com.kyrie.mybatis.mapperr.RoleMapper;
import com.kyrie.mybatis.mapperr.UserMapper;
import com.kyrie.mybatis.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName RoleService
 * @Description
 * @Author Kyrie
 * @Date 2019/8/30 16:25
 * @Version 1.0
 **/
@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;
/*
    public Set<String> selectRolesByUserId(String userId){
        List<Role> perms = roleMapper.selectRolesByUserId(userId);
        Set<String> permeSet = new HashSet<>();
        for(Role perm: perms){
            if(StringUtil.isNotNull(perm)){
                permeSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return  permeSet;
    }*/



    public List<Role> selectRolesByUserId(String userId){
        return  roleMapper.selectRolesByUserId(userId);
    }


}
