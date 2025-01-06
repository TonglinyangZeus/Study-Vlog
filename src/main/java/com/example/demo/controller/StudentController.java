package com.example.demo.controller;

import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentQueryParam;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    // 分页条件查询学生列表
    @GetMapping
    public Result getStudents(StudentQueryParam studentQueryParam) {
        PageResult<Student> studentList = studentService.getStudentList(studentQueryParam);
        return Result.success(studentList);
    }
    // 删除学生
    @DeleteMapping("/{ids}")
    public Result deleteStudent(@PathVariable List<Integer> ids) {
        studentService.deleteByIds(ids);
        return Result.success();
    }
    // 新增学生信息
    @PostMapping
    public Result addStudent(@RequestBody Student student) {
        studentService.insert(student);
        return Result.success();
    }
    // 根据id查询学生信息
    @GetMapping("/{id}")
    public Result getStudentDetail(@PathVariable Integer id) {
         Student student = studentService.getStudentDetail(id);
         return Result.success(student);
    }
    // 修改学生信息
    @PutMapping
    public Result updateStudent(@RequestBody Student student) {
        studentService.updateInfo(student);
        return Result.success();
    }
    // 学生违纪处理
    @PutMapping("/violation/{id}/{score}")
    public Result handleWrongStudent(@PathVariable Integer id, @PathVariable Integer score) {
        studentService.handleWrongStudent(id, score);
        return Result.success();
    }


}
