package com.kyrie.bootmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MailController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/26 15:26
 * @Version 1.0
 **/
@RestController
@RequestMapping("/email")

public class MailController {

    @Autowired
    private JavaMailSender jms;

    @Value("${spring.mail.username}")
    private String from;
    @RequestMapping("send")
    public String sendSimpleEmail(){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo("1664134661@qq.com");
            message.setSubject("一封简单的邮件demo");
            message.setText("使用springboot发送简单邮件demo");
            jms.send(message);
            return "发送成功";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
