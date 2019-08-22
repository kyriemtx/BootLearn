package com.kyrie.aop.controller;

import com.kyrie.aop.annotation.Log;
import com.kyrie.aop.entity.Student;
import com.kyrie.aop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AopController
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 10:42
 * @Version 1.0
 **/

@RestController
public class AopController {

    @Autowired
    private StudentService studentService;

    /**
     * 根据用户名查询
     * @param sname
     * @return
     */
    @Log(value = "查询用户")
    @GetMapping("/test")
    public Student selectStudentByName(String sname){
       Student student = studentService.selectStudentByName(sname);
       if(student == null){
           return  null;
       }else {
           return  student;
       }
    }

    /**
     * 新增
     * @param student
     * @return
     */
    @PostMapping("/add")
    public String insert(Student student){
        //查询数据库是否有该学生,有则添加失败，没有则新增
        Student student1 = studentService.selectStudentByName(student.getSname());
        if(student1 == null){
            int result = studentService.insert(student);
            if(result > 0){
                return "添加成功";
            }else {
                return  "操作失败";
            }

        }else {
            return  "该用户已存在";
        }

    }

    /**
     * 更新信息
     * @param student
     * @return
     */
    @PostMapping("/edit")
    public String updateStudent(Student student){
        //根据用户名查询，若有该学生存在，则更新，若不存在则返回无此用户
        Student student1 = studentService.selectStudentByName(student.getSname());
        if(student1 != null){
           int result = studentService.updateStudent(student);
           if(result > 0){
               return "更新成功";
           }else {
               return "更新失败";
           }
        }else {
            return  "无此学生信息";
        }

    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Log("删除操作")
    @DeleteMapping("/delete")
    public String deleteStudentByKey(Integer id){
        int result = studentService.deleteStudentByKey(id);
        if(result > 0){
            return  "删除成功";
        }else {
            return "操作失败";
        }

    }

    /**
     * 列表
     * @return
     */
    @GetMapping("/list")
    public List<Student> studentlist(){
        List<Student> list = studentService.studentlist();
        int size = list.size();
        return  list;
    }


}
