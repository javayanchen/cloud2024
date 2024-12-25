package com.yc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @auther yanChen
 * @create 2023-11-03 17:54
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.yc.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@RefreshScope
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }
}

