package com.example.demo.service.impl;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentQueryParam;
import com.example.demo.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> getStudentList(StudentQueryParam studentQueryParam) {
        // 设置分页参数
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        // 执行查询
        List<Student> studentList = studentMapper.getStudent(studentQueryParam);
        // 解析结果
        Page<Student> s = (Page<Student>) studentList;
        return new PageResult<Student>(s.getTotal(), s.getResult());
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public Student getStudentDetail(Integer id) {
        return studentMapper.getStudentDetail(id);
    }

    @Override
    public void updateInfo(Student student) {
        studentMapper.updateInfo(student);
    }

    @Override
    public void handleWrongStudent(Integer id, Integer score) {
        studentMapper.handleWrongStudent(id, score);
    }
}
