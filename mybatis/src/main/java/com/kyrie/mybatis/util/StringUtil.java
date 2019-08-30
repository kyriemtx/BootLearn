package com.kyrie.mybatis.util;

/**
 * @ClassName StringUtil
 * @Description
 * @Author Kyrie
 * @Date 2019/8/30 15:47
 * @Version 1.0
 **/
public class StringUtil {
    public static boolean isNotNull(Object object){
        if(object == null){
            return  false;
        }else {
            return true;
        }
    }
}
