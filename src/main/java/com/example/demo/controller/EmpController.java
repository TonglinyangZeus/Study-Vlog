package com.example.demo.controller;

import com.example.demo.pojo.Emp;
import com.example.demo.pojo.EmpQueryParam;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Result;
import com.example.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 员工管理的controller
@RequestMapping("/emps")
@RestController
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    // 新增员工
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        empService.save(emp);
       return Result.success();
    }
    // 删除员工
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        empService.delete(ids);
        return Result.success();
    }
    // 根据ID查询员工信息
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
    // 修改员工
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }
    // 查询所有员工
    @GetMapping("/list")
    public Result list() {
        List<Emp> list = empService.list();
        return Result.success(list);
    }

}
