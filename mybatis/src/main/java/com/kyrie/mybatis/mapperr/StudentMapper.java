package com.kyrie.mybatis.mapperr;

import com.kyrie.mybatis.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);

    Student selectStudentByName(String  sname);

    List<Student>  studentlist();

    int updateStudent(Student student);

    int deleteStudentByKey(Integer id);




}