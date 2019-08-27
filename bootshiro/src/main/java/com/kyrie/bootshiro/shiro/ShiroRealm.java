package com.kyrie.bootshiro.shiro;

import com.kyrie.bootshiro.entity.SysUser;
import com.kyrie.bootshiro.mapperr.SysUserMapper;
import com.kyrie.bootshiro.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName ShiroRealm
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 21:56
 * @Version 1.0
 **/
public class ShiroRealm extends AuthorizingRealm {

    private static final String SALT = "kyrie";

    @Autowired
    private SysUserService sysUserService;

    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        return null;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.println("用户" + userName + "------开始认证-----");
        SysUser user = sysUserService.findByUserName(userName);

        if (user == null){
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo  = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(SALT),getName());
        return simpleAuthenticationInfo;
    }
}
