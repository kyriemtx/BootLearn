package com.kyrie.markdown.config;
import java.util.Arrays;
import	java.util.HashMap;
import	java.util.Map;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * @ClassName DruidConfig
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/25 17:08
 **/
@Configuration
public class DruidConfig {
    private Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidConfig DruidConfig(){
        return new DruidConfig();
    }

    @Bean
    public ServletRegistrationBean druidServlet(){
        logger.info("初始化数据源配置");
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, String> params = new HashMap<>();
        params.put("loginUserName","kyrie");
        params.put("loginPassword","kyrie");
        params.put("allow", "");
        // params.put("deny", "ip");  黑名单  同事存在 deny优先于allow
        bean.setInitParameters(params);
        return bean;
    }


    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<> ();
        initParams.put("exclusions","*.js,*.css,.druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }


}
