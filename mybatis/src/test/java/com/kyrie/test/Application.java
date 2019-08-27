package com.kyrie.test;

import com.kyrie.mybatis.MybatisApplication;
import com.kyrie.mybatis.entity.Student;
import com.kyrie.mybatis.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName Application
 * @Description
 * @Author Kyrie
 * @Date 2019/8/27 16:01
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
@MapperScan("com.kyrie.mybatis.mapper.*")
public class Application {
    @Autowired
    private StudentService studentService;
    @Test
    public void test() throws Exception{
        Student student = this.studentService.selectStudentByName("kyrie");
        System.err.println("学号："+student.getId()+"姓名："+student.getSname());
        Student student1 = this.studentService.selectStudentByName("kyrie");
        System.err.println("学号："+student1.getId()+"姓名："+student1.getSname());

    }
}
