package com.kyrie.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName BrowserSecurityConfig
 * @Description
 * @Author Kyrie
 * @Date 2019/8/23 17:35
 * @Version 1.0
 **/
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() // 表单方式
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/login.html").permitAll()
                .anyRequest()  // 所有请求
                .authenticated()   // 都需要认证
                .and().csrf().disable();
    }

    /**
     * 密码加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}