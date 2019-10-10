package com.kyrie.test;

import com.kyrie.mybatis.MybatisApplication;
import com.kyrie.mybatis.entity.Student;
import com.kyrie.mybatis.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName MainTest
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/10 16:43
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public class MainTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void test() {
        String sname = "kyrie";
        log.info("测试开始-------");
        Student student = new Student();
        student = studentService.selectStudentByName(sname);
        log.info("测试结束--------");
    }
}
