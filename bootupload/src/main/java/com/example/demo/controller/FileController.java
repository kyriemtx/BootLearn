package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName FileController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/29 15:38
 * @Version 1.0
 **/
@Controller
public class FileController {

    @RequestMapping("file")
    public String file(){
        return "file";
    }

    /**
     * 单文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String fileUpload(@RequestParam("filename")MultipartFile file){
        if(file.isEmpty()){
            return "上传文件为空";
        }
        String fileName = file.getOriginalFilename();
        int size = (int)file.getSize();
        System.err.println("文件大小为："+size);

        String path = "D:/test";
        File dest = new File(path + "/" + fileName);
          if(!dest.getParentFile().exists()){
              dest.getParentFile().mkdir();
          }try {
              file.transferTo(dest);
              return  "上传成功";
        }catch (IllegalStateException  e){
              return "上传失败";
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }

    }

    /**
     * 多文件上传
     * @param request
     * @return
     */
    @RequestMapping(value="multifileUpload",method=RequestMethod.POST)
    public @ResponseBody String multifileUpload(HttpServletRequest request) {

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");

        if (files.isEmpty()) {
            return "上传文件为空";
        }

        String path = "D:/test";

        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            System.out.println(fileName + "-->" + size);

            if (file.isEmpty()) {
                return "上传文件为空";
            } else {
                File dest = new File(path + "/" + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return "上传失败";
                }
            }
        }
        return "上传成功";

    }

}
