package com.kyrie.bootshiro.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DruidConfig
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 21:24
 * @Version 1.0
 **/
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource durid(){
        return  new DruidDataSource();
    }
    /**
     * 配置监控服务器
     * @return
     */
    @Bean
    public ServletRegistrationBean statViemServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initMap = new HashMap<>();
        //druid后台管理用户
        initMap.put("loginName","admin");
        initMap.put("loginPassword","admin");
        //是否能够重置数据
        initMap.put("resetEnable","false");
        //设置ip白名单
        initMap.put("allow", "");
        //设置ip黑名单。deny优先级高于allow
        initMap.put("deny", "192.168.236.225");

        servletRegistrationBean.setInitParameters(initMap);
        return  servletRegistrationBean;

    }

    /**
     * 配置web监控过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String,String> initMap = new HashMap<>();
        //忽略过滤规则
        initMap.put("exclusions","*.js,*.css,*.icon,*png,*.jpg,/druid/*");
        filterRegistrationBean.setInitParameters(initMap);
        return filterRegistrationBean;
    }
}
