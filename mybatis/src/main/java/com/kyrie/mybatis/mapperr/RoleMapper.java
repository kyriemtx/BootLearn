package com.kyrie.mybatis.mapperr;

import com.kyrie.mybatis.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

   List<Role> selectRolesByUserId(String userId);


   Set<String> permissions();

}