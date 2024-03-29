package com.kyrie.aop.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName IPUtils
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 15:22
 * @Version 1.0
 **/
public class IPUtils {
    public static String getIpAddr(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip =request.getHeader("Proxy-Client-IP");
        }if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;

    }
}
