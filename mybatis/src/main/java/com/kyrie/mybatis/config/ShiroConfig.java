package com.kyrie.mybatis.config;

import com.kyrie.mybatis.realm.ShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.LinkedHashMap;

/**
 * @ClassName ShiroConfig
 * @Description
 * @Author Kyrie
 * @Date 2019/8/30 13:35
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterChainDefinition(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置登陆路径
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置登陆成功的路径
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //设置无权限的路径
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        LinkedHashMap<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //设置静态页面不拦截
        filterChainDefinitionMap.put("/static/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/assembly/**","anon");
        filterChainDefinitionMap.put("/layui/**","anon");
        filterChainDefinitionMap.put("/font/**","anon");
        filterChainDefinitionMap.put("/css/**","anon");
        //设置druid数据源页面不拦截
        filterChainDefinitionMap.put("/druid/**","anon");
        //设置登陆页面不拦截
        filterChainDefinitionMap.put("/login","anon");
        //设置退出页面不拦截
        filterChainDefinitionMap.put("/logout","anon");
        filterChainDefinitionMap.put("/lib/**","anon");
        filterChainDefinitionMap.put("/user/**","anon");
        //验证码不拦截
        filterChainDefinitionMap.put("/defaultKaptcha","anon");
        filterChainDefinitionMap.put("/","anon");
        //除以上请求，其余的都需要登陆认证，不登陆则重定向到登陆页面
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return  shiroFilterFactoryBean;

    }


    @Bean
    public SecurityManager securityManager(){
        //设置securityManager，并注入自定义的shiroRealm
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroRealm shiroRealm(){
        //设置自定义shiroRealm
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }


}
