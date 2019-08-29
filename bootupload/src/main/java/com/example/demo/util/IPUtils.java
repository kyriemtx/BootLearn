package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @ClassName IPUtils
 * @Description
 * @Author Kyrie
 * @Date 2019/8/29 14:38
 * @Version 1.0
 **/
public class IPUtils {
    private static final Logger logger = LoggerFactory.getLogger(IPUtils.class);
    /**
     * @param
     * @return IP Address
     */
    public  String getIpAddrByRequest(HttpServletRequest request) {

        logger.info("获取远程请求IP地址开始。。。。。。。。。。。。。。。。。");
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * @return 获取本机IP
     * @throws SocketException
     */
    public  String getRealIp() throws SocketException {

        Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        String localHostAddress = "";
        while(allNetInterfaces.hasMoreElements()){
            NetworkInterface networkInterface = allNetInterfaces.nextElement();
            Enumeration<InetAddress> address = networkInterface.getInetAddresses();
            while(address.hasMoreElements()){
                InetAddress inetAddress = address.nextElement();
                if(inetAddress != null && inetAddress instanceof Inet4Address){
                    localHostAddress = inetAddress.getHostAddress();
                }
            }
        }
        return localHostAddress;

    }

}
