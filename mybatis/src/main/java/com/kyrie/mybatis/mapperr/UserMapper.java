package com.kyrie.mybatis.mapperr;

import com.kyrie.mybatis.entity.Permission;
import com.kyrie.mybatis.entity.Role;
import com.kyrie.mybatis.entity.User;
import com.kyrie.mybatis.entity.UserKey;
import jdk.internal.dynalink.linker.LinkerServices;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(UserKey key);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByUsername(String username);

    List<Role> findRoleList(String userId);

    List<Permission> findPermissionList(String userId);
}