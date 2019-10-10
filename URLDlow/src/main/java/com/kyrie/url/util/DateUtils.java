package com.kyrie.url.util;
import	java.util.Calendar;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/10 19:10
 **/
@Component
public class DateUtils {

    private static final String DATE_YYYYMMDD = "yyyyMMdd";

    /**
     *  检验时间参数是否合法
     * @param text
     * @return
     * @throws Exception
     */
    public Boolean checkPar(String text) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DATE_YYYYMMDD);
        sdf.setLenient(false);
        Date date = sdf.parse(text);
        return true;
    }

    /**
     * 获取当前当前是的前一天日期
     * @param bussdate
     * @return
     * @throws Exception
     */
    public String getBefor(String bussdate) throws  Exception{
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.DATE_YYYYMMDD);
       //字符串转时间
       Date date = simpleDateFormat.parse(bussdate);
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(date);
       calendar.add(Calendar.DAY_OF_MONTH,-1);
       Date yesterday = calendar.getTime();
       String yester = simpleDateFormat.format(yesterday);
       return yester;
    }

    /**
     * 获取当前时间的下一天日期
     * @param bussdate
     * @return
     * @throws Exception
     */
    public String getAfter(String bussdate)throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.DATE_YYYYMMDD);
        Date date = simpleDateFormat.parse(bussdate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date tomorrow = calendar.getTime();;
        String tomo = simpleDateFormat.format(tomorrow);
        return tomo;
    }
}
