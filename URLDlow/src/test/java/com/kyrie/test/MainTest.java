package com.kyrie.test;

import com.kyrie.url.IoWithCsvApplication;
import com.kyrie.url.service.IoService;
import com.kyrie.url.util.DateUtils;
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
 * @Date 2019/10/10 17:07
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IoWithCsvApplication.class)
@Slf4j
public class MainTest {

    @Autowired
    private IoService ioService;
    @Autowired
    private DateUtils dateUtils;


    @Test
    public void test() {
        String url = "https://app.masget.com/files/companyvsfile/404244197/COD2404244197_003_20190921_01.TXT";
        String data = "20190919";
        String result = null;
        try {
            result = ioService.fileDown(data, url);
            result = result;
        } catch (Exception e) {
            log.info("下载文件失败！");
        }
    }

    @Test
    public void checkPar() {
        String ss = "20190812";
        try {
            Boolean b = dateUtils.checkPar(ss);
            System.out.println(b);
        } catch (Exception e) {
            log.info("时间校验出错", e.getMessage());
        }
    }

    @Test
    public void befor() {
        String ss = "20190901";
        try {
            String yesterday = dateUtils.getBefor(ss);
            System.err.println(yesterday);
        } catch (Exception e) {
            log.info("获取前一天失败", e.getMessage());
            return;
        }
    }

    @Test
    public void after() {
        String ss = "20190901";
        try {
            String tomorrow = dateUtils.getAfter(ss);
            System.err.println(tomorrow);
        } catch (Exception e) {
            log.info("获取后一天失败", e.getMessage());
        }
    }
}
