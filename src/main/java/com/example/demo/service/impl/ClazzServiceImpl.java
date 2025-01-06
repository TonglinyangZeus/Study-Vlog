package com.example.demo.service.impl;

import com.example.demo.exception.StudentExistsException;
import com.example.demo.mapper.ClazzMapper;
import com.example.demo.pojo.Clazz;
import com.example.demo.pojo.ClazzQueryParam;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Student;
import com.example.demo.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult<Clazz> getClazz(ClazzQueryParam queryParam) {
        // 设置分页参数
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());
        // 执行查询
        List<Clazz> clazzList = clazzMapper.getClazz(queryParam);
        // 解析结果
        Page<Clazz> p = (Page<Clazz>) clazzList;

        return new PageResult<Clazz>(p.getTotal(), clazzList);
    }

    @Override
    public void deleteById(Integer id) {
        // 检测该班级下面是否有学生
        List<Student> studentList = clazzMapper.getStudentById(id);
        if(!studentList.isEmpty()) {
            throw new StudentExistsException("对不起, 该班级下有学生, 不能直接删除");
        }
        clazzMapper.deleteById(id);
    }

    @Override
    public void addClazzs(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.addClazz(clazz);
    }

    @Override
    public Clazz getClazzDetail(Integer id) {

        return clazzMapper.getClazzDetail(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Student> getStudentById(Integer id) {
        return clazzMapper.getStudentById(id);
    }

    @Override
    public List<Clazz> getClazzList() {
        return clazzMapper.getClazzList();
    }
}
