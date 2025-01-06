package com.example.demo;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class LogTest {
    private static final Logger log = Logger.getLogger(String.valueOf(LogTest.class));

    @Test
    public void testLog(){
//        System.out.println(LocalDateTime.now() + " : 开始计算...");
        log.info("开始计算");
        int sum = 0;
        int[] nums = {1, 5, 3, 2, 1, 4, 5, 4, 6, 7, 4, 34, 2, 23};
        for (int num : nums) {
            sum += num;
        }

//        System.out.println("计算结果为: "+sum);
        log.info("计算结果为: "+sum);
//        System.out.println(LocalDateTime.now() + "结束计算...");
        log.info("结束计算");
    }

}
