package com.kyrie.straptable.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kyrie.straptable.entity.SysLog;
import com.kyrie.straptable.service.SysLogService;
import com.sun.org.apache.regexp.internal.RE;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ClassName SysLogController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/26 17:37
 * @Version 1.0
 **/
@Controller
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;
    @GetMapping("/list")
    public String getAllLogs(Model model){
        List<SysLog> list = sysLogService.getAllLogs();
        int size = list.size();
        model.addAttribute("logList",list);
        return "log";
    }

    @ResponseBody
    @GetMapping("/ttt")
    public Object getData(HttpServletRequest request,Model model){
        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
        PageHelper.startPage(pageNum,pageSize);
        List<SysLog> list = sysLogService.getAllLogs();
        PageInfo pageInfo = new PageInfo(list,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return list;
    }



    @ResponseBody
    @GetMapping("/get")
    public String logs(Model model,
                       @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                       @RequestParam(defaultValue="5",value="pageSize")Integer pageSize){
        if(pageNum == null){
            pageNum = 1;

        }if(pageNum < 0){
            pageNum = 1;
        }if(pageSize == null){
            pageSize = 5;
        }
        System.err.println("当前页是："+pageNum+"显示条数是："+pageSize);
        PageHelper.startPage(pageNum,pageSize);
        try {
            List<SysLog> logList = sysLogService.getAllLogs();
            System.out.println("分页数据："+logList);
            PageInfo<SysLog> pageInfo = new PageInfo<SysLog>(logList,pageSize);
            model.addAttribute("pageInfo",pageInfo);
        }finally {
            PageHelper.clearPage();
        }
        return "log";
    }




}
