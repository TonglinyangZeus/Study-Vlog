package com.example.demo.mapper;

import com.example.demo.pojo.Clazz;
import com.example.demo.pojo.ClazzQueryParam;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {


    List<Clazz> getClazz(ClazzQueryParam queryParam);

    void deleteById(Integer id);

    void addClazz(Clazz clazz);

    Clazz getClazzDetail(Integer id);

    void update(Clazz clazz);

    List<Student> getStudentById(Integer id);

    List<Clazz> getClazzList();

    @MapKey("")
    List<Map<String, Object>> countStudentData();
}
