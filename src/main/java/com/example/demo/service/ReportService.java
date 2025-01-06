package com.example.demo.service;

import com.example.demo.pojo.ClazzCountOption;
import com.example.demo.pojo.JobOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    ClazzCountOption getStudentCount();

    List<Map<String, Object>> getDegreeCount();
}
