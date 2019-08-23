package com.kyrie.bootshiro.mapperr;

import com.kyrie.bootshiro.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUser user);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser findByUserName(String userName);
}