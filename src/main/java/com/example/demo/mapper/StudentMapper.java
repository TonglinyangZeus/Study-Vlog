package com.example.demo.mapper;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> getStudent(StudentQueryParam studentQueryParam);

    void deleteByIds(List<Integer> ids);

    void insert(Student student);

    Student getStudentDetail(Integer id);

    void updateInfo(Student student);

    void handleWrongStudent(Integer id, Integer score);

    List<Map<String, Object>> getDegreeCount();
}
