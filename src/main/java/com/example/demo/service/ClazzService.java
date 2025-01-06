package com.example.demo.service;

import com.example.demo.pojo.Clazz;
import com.example.demo.pojo.ClazzQueryParam;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClazzService {
    PageResult<Clazz> getClazz(ClazzQueryParam queryParam);

    void deleteById(Integer id);

    void addClazzs(Clazz clazz);

    Clazz getClazzDetail(Integer id);

    void update(Clazz clazz);

    List<Student> getStudentById(Integer id);

    List<Clazz> getClazzList();
}
