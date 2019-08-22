package com.kyrie.mybatis.service;

import com.kyrie.mybatis.entity.Student;
import com.kyrie.mybatis.mapperr.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudentService
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 10:59
 * @Version 1.0
 **/
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询
     * @param sname
     * @return
     */
    public Student selectStudentByName(String sname){
        return studentMapper.selectStudentByName(sname);
    }


    /**
     * 新增
     * @param student
     * @return
     */
    public int insert(Student student){
        return  studentMapper.insert(student);

    }

    /**
     * 修改
     * @param student
     * @return
     */
    public int updateStudent(Student student){
        return studentMapper.updateStudent(student);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteStudentByKey(Integer id){
        return studentMapper.deleteStudentByKey(id);

    }

    /**
     * 查询全部
     * @return
     */
    public List<Student> studentlist(){
        return  studentMapper.studentlist();
    }

}
