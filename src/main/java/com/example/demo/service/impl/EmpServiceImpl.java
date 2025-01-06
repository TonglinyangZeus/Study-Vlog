package com.example.demo.service.impl;

import com.example.demo.mapper.EmpExprMapper;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.pojo.*;
import com.example.demo.service.EmpLogService;
import com.example.demo.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {

        // 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        // 执行查询
        List<Emp> emplist =  empMapper.list( empQueryParam.getName(),  empQueryParam.getGender(),  empQueryParam.getBegin(),  empQueryParam.getEnd());
        // 解析结果并封转
        Page<Emp> p = (Page<Emp>) emplist;
        //结果封装
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            // 保存员工的基本信息
            empMapper.insert(emp);

            // 保存员工工作经历
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                // 遍历集合，给这个empId赋值，因为insert使用了主键返回
                exprList.forEach(e -> {
                    e.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            //记录操作的日志
            // emplogservice已经新开了一个事务，不会参与当前的事务，意思就是不论上面的SQL执行的对或者错误这个都会执行
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), emp.toString());
            empLogService.insertLog(empLog);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        // 删除删除员工的基本信息
        empMapper.deleteByIds(ids);

        // 删除员工的经历信息
        empExprMapper.deleteByEmpIds(ids);



    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getInfo(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        // 修改员工信息
        // 根据id修改员工的基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        // 根据id修改员工的工作经历信息
        // 1.先删除
         empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        // 2.再添加
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(e -> {
                e.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList) ;
        }

    }

    @Override
    public List<Emp> list() {
        return empMapper.getlist();
    }
}
