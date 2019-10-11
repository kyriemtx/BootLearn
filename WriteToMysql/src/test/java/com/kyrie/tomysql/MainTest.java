package com.kyrie.tomysql;
import	java.io.IOException;

import com.kyrie.tomysql.service.CSVService;
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
 * @Date 2019/10/11 10:10
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WriteToMysqlApplication.class)
@Slf4j
public class MainTest {

    @Autowired
    private CSVService csvService;

    @Test
    public void write(){
        String filePath = "D:\\zazq\\测试用户实体.txt";
        try {
            csvService.writeToMysql(filePath);
        }catch (IOException e){
            log.error(e.getMessage(), e);
        }
    }


    @Test
    public void read(){
        int uage = 23;
        try {
            csvService.readFromMysql(uage);
        }catch (Exception e){
            log.info("写入文件失败",e.getMessage());
        }
    }
}
