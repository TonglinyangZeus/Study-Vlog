package com.example.demo.service.impl;

import com.example.demo.mapper.ClazzMapper;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.Clazz;
import com.example.demo.pojo.ClazzCountOption;
import com.example.demo.pojo.JobOption;
import com.example.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        // 调用mapper接口，获取统计数据
        List<Map<String, Object>> list = empMapper.countEmpJobData();

        // 组装结果并返回
       List<Object> joblist = list.stream().map(dataMap -> dataMap.get("pos")).toList();
       List<Object> datalist = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(joblist, datalist);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public ClazzCountOption getStudentCount() {
        // 调用mapper接口获取班级全部班级
        List<Map<String, Object>> list = clazzMapper.countStudentData();
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("classname")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new ClazzCountOption(clazzList, dataList);
    }

    @Override
    public List<Map<String, Object>> getDegreeCount() {
        return studentMapper.getDegreeCount();
    }
}
