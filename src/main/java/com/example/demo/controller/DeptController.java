package com.example.demo.controller;

import com.example.demo.pojo.Dept;
import com.example.demo.pojo.Result;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 查询部门
    @GetMapping
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> deptlist =  deptService.findAll();
        return Result.success(deptlist);
    }
    // 删除部门
    @DeleteMapping
    public Result delete(Integer id) {
        System.out.println("删除部门id");
        deptService.deleteById(id);
        return Result.success();
    }
    // 新增部门
    @PostMapping
    // @RequestBody接受json格式
    public Result add (@RequestBody Dept dept) {
        deptService.add(dept);
        return Result.success();
    }

    // 根据id来查询部门
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable() Integer id) {
        Dept dept =  deptService.getById(id);
        return Result.success(dept);
    }

    // 修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }
}
