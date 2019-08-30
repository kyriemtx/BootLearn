package com.kyrie.mybatis.util;

import com.kyrie.mybatis.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.jws.soap.SOAPBinding;

/**
 * @ClassName ShiroUtil
 * @Description
 * @Author Kyrie
 * @Date 2019/8/30 15:42
 * @Version 1.0
 **/
public class ShiroUtil {

    public static Subject getSubject(){
       return SecurityUtils.getSubject();
    }

    public static Session getSession()
    {
        return SecurityUtils.getSubject().getSession();
    }

    public static String getIp()
    {
        return getSubject().getSession().getHost();
    }

    public static User getUser()
    {
        User user = null;
        Object obj = getSubject().getPrincipal();
        if (StringUtil.isNotNull(obj))
        {
            user = new User();
        }
        return user;
    }

}
