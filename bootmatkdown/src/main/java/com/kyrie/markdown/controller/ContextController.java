package com.kyrie.markdown.controller;
import	java.util.ResourceBundle;

import com.kyrie.markdown.entity.Content;
import com.kyrie.markdown.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import	java.util.ResourceBundle.Control;

/**
 * @ClassName ContextController
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/25 17:59
 **/
@Controller
public class ContextController {
    @Autowired
    private ContentService contentService;
    @RequestMapping("/edit")
    public String edit() {
        return "edit";
    }

    @PostMapping("/addText")
    public String addText(Content content){
        contentService.addText(content);
        return "success";
    }
}
