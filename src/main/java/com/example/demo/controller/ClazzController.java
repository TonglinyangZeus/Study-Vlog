package com.example.demo.controller;

import com.example.demo.pojo.*;
import com.example.demo.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    // 获取班级信息
    @GetMapping
    public Result getClazzs(ClazzQueryParam queryParam) {
        PageResult<Clazz> clazzList = clazzService.getClazz(queryParam);
        return Result.success(clazzList);
    }
    @DeleteMapping("/{id}")
    public Result deleteClazzs(@PathVariable Integer id) {
        clazzService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result addClazzs(@RequestBody Clazz clazz) {
        clazzService.addClazzs(clazz);
        return Result.success();
    }
    // 根据id查询班级信息
    @GetMapping("/{id}")
    public Result getClazzDetail(@PathVariable Integer id) {
        Clazz clazz = clazzService.getClazzDetail(id);
        return Result.success(clazz);
    }

    // 修改班级信息
    @PutMapping
    public Result updateClazzs(@RequestBody Clazz clazz) {
        clazzService.update(clazz);
        return Result.success();
    }

    // 根据班级id查询该班级下的学生
    @GetMapping("/class/{id}")
    public Result getClazzByClassId(@PathVariable Integer id) {
        List<Student> studentList = clazzService.getStudentById(id);
        return Result.success(studentList);
    }

    // 查询全部班级
    @GetMapping("/list")
    public Result getClazzList() {
        List<Clazz> clazzList = clazzService.getClazzList();
        return Result.success(clazzList);
    }





}
