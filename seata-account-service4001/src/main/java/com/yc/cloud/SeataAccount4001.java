package com.yc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.yc.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
public class SeataAccount4001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccount4001.class, args);
    }
}
