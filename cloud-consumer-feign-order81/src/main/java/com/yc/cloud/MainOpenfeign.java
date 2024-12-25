package com.yc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName MainOpenfeign
 * @Description TODO 采用Openfeign进行服务调用
 * @Author YanChen
 * @Date 2024/12/19 15:32
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MainOpenfeign {
    public static void main(String[] args) {

        SpringApplication.run(MainOpenfeign.class, args);
    }
}
