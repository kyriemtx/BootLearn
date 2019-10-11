package com.kyrie.test;
import java.text.ParseException;
import	java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * 字符串与Date互转
     */
    @Test
    public void StringAndDate(){
        //字符串
        String str = "20190919";
        try {
            //定义时间格式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            //字符串转换成时间戳
            Date date = simpleDateFormat.parse(str);
            System.err.println("字符串转换成时间戳："+date);
            //时间戳转换成一个字符串
            String newString = simpleDateFormat.format(date);
            System.err.println("时间戳转换成一个字符串："+newString);
        }catch (DateTimeException | ParseException e){
            log.info("字符串转换日期异常结束",e.getMessage());
        }

    }

    @Test
    public void StingToOther(){
        String string = "2019";
        int i = 100;
        System.err.println("字符串转Int类型：" + Integer.parseInt(string));
        System.err.println("Int类型转字符串：" + Integer.toString(i));

    }

    @Test
    public void stream() {
        List<String> list = new ArrayList<>();
        list.add("马腾霄");
        list.add("马林");
        list.add("李若男");
        list.add("张琦我爱你");
        //常规过滤
        for(String s: list){
            if(s.startsWith("马")){
                System.out.println(s);
            }else if(s.length() == 5) {
                System.err.println(s);
            }
        }
        //Stream流常用方法： forEach、filter
        System.out.println("=======================================================================");
        list.stream().filter(aa->aa.startsWith("张"));
        System.out.println( list.stream().filter(aa->aa.startsWith("张")));
        list.stream().filter(aa -> aa.length()==2);
        System.out.println((list.stream().filter(aa -> aa.length()==2).toString()));
        list.stream().forEach(aa->System.err.println("Java8新特性遍历:"+aa));
    }

}
