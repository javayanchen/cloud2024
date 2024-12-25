package com.yc.cloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PayCircuitController
 * @Description TODO
 * @Author YanChen
 * @Date 2024/12/20 8:00
 * @Version 1.0
 */
@RestController
public class PayCircuitController {

    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id")Integer id) {

        if (id ==  -4) throw new RuntimeException("-----circuit不能为负数");

        if (id == 9999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Hello, circuit inputId:" + id + "\t" + IdUtil.simpleUUID();
    }

    @GetMapping("/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id")Integer id) {

        if (id ==  -4) throw new RuntimeException("-----bulkhead不能为负数");

        if (id == 9999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Hello, bulkhead inputId:" + id + "\t" + IdUtil.simpleUUID();
    }

    @GetMapping("/pay/ratelimit/{id}")
    public String myRateLimit(@PathVariable("id") Integer id) {
        return "Hello myRateLimit - 欢迎来到 inputId:" + id + "\t" + IdUtil.simpleUUID();
    }
}
