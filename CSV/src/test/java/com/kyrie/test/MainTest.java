package com.kyrie.test;
import	java.awt.TextArea;

import com.kyrie.csv.CSVApplication;
import com.kyrie.csv.service.CSVServie;
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
 * @Date 2019/10/10 18:45
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CSVApplication.class)
@Slf4j
public class MainTest {

    @Autowired
    private CSVServie csvServie;

    @Test
    public void test() throws Exception{
       log.info("csv测试开始");
       csvServie.csv();

    }
}
