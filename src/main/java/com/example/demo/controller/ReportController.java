package com.example.demo.controller;

import com.example.demo.pojo.ClazzCountOption;
import com.example.demo.pojo.JobOption;
import com.example.demo.pojo.Result;
import com.example.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {


    @Autowired
    private ReportService reportService;
    // 获取员工职位
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        List<Map<String, Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }
    // 班级人数统计
    @GetMapping("studentCountData")
    public Result getStudentCountData() {
        ClazzCountOption clazzCountOption = reportService.getStudentCount();
        return Result.success(clazzCountOption);
    }
    // 班级学历统计
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        List<Map<String, Object>> list = reportService.getDegreeCount();
        return Result.success(list);
    }



}
