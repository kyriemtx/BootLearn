package com.kyrie.straptable.controller;

import com.kyrie.straptable.entity.Account;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IndexController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/27 15:53
 * @Version 1.0
 **/
@Controller
public class IndexController {
    @RequestMapping("/account")
    public String index(Model m) {
        List<Account> list = new ArrayList<Account>();
        list.add(new Account("KangKang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
        list.add(new Account("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "13444444444"));
        list.add(new Account("Jane","简","e10adc3949ba59abbe56e","运维人员","18666666666"));
        list.add(new Account("Maria", "玛利亚", "e10adc3949ba59abbe56e", "清算人员", "19999999999"));
        m.addAttribute("accountList",list);
        return "account";
    }
}
