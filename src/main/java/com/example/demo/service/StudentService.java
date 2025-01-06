package com.example.demo.service;

import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentQueryParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    PageResult<Student> getStudentList(StudentQueryParam studentQueryParam);

    void deleteByIds(List<Integer> ids);

    void insert(Student student);

    Student getStudentDetail(Integer id);

    void updateInfo(Student student);

    void handleWrongStudent(Integer id, Integer score);
}
