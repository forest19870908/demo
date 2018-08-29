package com.example.demo.service;

import com.example.demo.entity.StudentEntity;

import java.util.List;
import java.util.Map;

public interface StudentService {

    //写入数据
    int saveStudent();

    //查询数据
    List<StudentEntity> queryAllStudent();

    //更新数据
    int updateStudent(StudentEntity StudentEntity);

    //删除数据
    int deleteStudent(Integer id);

    Map findById(String name,Integer id,Map param);

}