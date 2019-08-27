package com.kyrie.mybatis;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @ClassName MybatisApplication
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 11:03
 * @Version 1.0
 **/
@SpringBootApplication
@EnableCaching
public class MybatisApplication {
    public static void main(String[] args){
        SpringApplication.run(MybatisApplication.class,args);
    }
}
