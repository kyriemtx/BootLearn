package com.kyrie.mybatis.controller;

import lombok.extern.java.Log;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ArticleController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/27 17:29
 * @Version 1.0
 **/
@Controller
public class ArticleController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("article")
    public String index() {
        return "web/article";
    }


}
