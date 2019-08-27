package com.kyrie.test;

import com.kyrie.straptable.StrapTableApplication;
import com.kyrie.straptable.entity.SysLog;
import com.kyrie.straptable.service.SysLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName Application
 * @Description
 * @Author Kyrie
 * @Date 2019/8/27 15:59
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StrapTableApplication.class)
public class Application {

    @Autowired
    private SysLogService sysLogService;

    @Test
    public void test() {
        SysLog sysLog = this.sysLogService.selectByPrimaryKey(1566463195547L);
        System.err.println("日志id："+sysLog.getIp());
    }

}
