package com.example.demo.service;

import com.example.demo.pojo.Emp;
import com.example.demo.pojo.EmpQueryParam;
import com.example.demo.pojo.PageResult;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<Emp> list();
}
