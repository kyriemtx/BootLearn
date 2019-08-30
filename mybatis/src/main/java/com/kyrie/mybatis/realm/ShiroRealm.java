package com.kyrie.mybatis.realm;

import com.kyrie.mybatis.entity.Permission;
import com.kyrie.mybatis.entity.Role;
import com.kyrie.mybatis.entity.User;
import com.kyrie.mybatis.service.RoleService;
import com.kyrie.mybatis.service.UserService;
import com.kyrie.mybatis.util.ShiroUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PersistenceDelegate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName ShiroRealm
 * @Description
 * @Author Kyrie
 * @Date 2019/8/30 13:48
 * @Version 1.0
 **/
public class ShiroRealm  extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    private static final String SALT = "kyrie";

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    /**
     * 权限认证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("权限验证开始-----------------------------");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = ShiroUtil.getUser();
        List<Role> roles = userService.findRoleList(user.getUserId());
        List<Permission> permissions = userService.findPermissionList(user.getUserId());

        return info;
    }

    /**
     * 登陆认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        System.err.println("用户："+username+"开始认证---------------------");
        User user = userService.findByUsername(username);
        if(user == null){
            throw  new UnknownAccountException("用户不存在！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("密码有误请重新输入！");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(SALT),getName());
        return simpleAuthenticationInfo;
    }
}
