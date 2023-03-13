package com.example.distributedlockdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author qzz
 * @date 2023/3/10
 */
@MapperScan("com.example.distributedlockdemo.dao")
@SpringBootApplication
public class DistributedLockDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedLockDemoApplication.class, args);
    }

}
