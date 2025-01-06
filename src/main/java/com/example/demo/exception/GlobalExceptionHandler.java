//package com.example.demo.exception;
//
//import com.example.demo.pojo.Result;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler
//    public Result handleException(Exception e) {
//        return Result.error("系统异常，请联系管理员");
//    }
//
//    @ExceptionHandler
//    public Result handleDuplicateKeyException(DuplicateKeyException e) {
//        String message = e.getMessage();
//        int i = message.indexOf("Duplicate entry");
//        String errorMessage = message.substring(i);
//        String[] arr = errorMessage.split(" ");
//        return Result.error(arr[2]+"已存在");
//    }
//
//    @ExceptionHandler(StudentExistsException.class)
//    public Result handleStudentExistsException(StudentExistsException ex) {
//         return Result.error(ex.getMessage());
//    }
//
//}
