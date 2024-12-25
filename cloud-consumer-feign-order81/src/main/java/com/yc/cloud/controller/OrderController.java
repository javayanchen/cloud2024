package com.yc.cloud.controller;

import com.yc.cloud.api.PayApi;
import com.yc.cloud.entity.PayDTO;
import com.yc.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName OrderController
 * @Description TODO 连接Openfeign，进行消费者调用
 * @Author YanChen
 * @Date 2024/12/19 15:38
 * @Version 1.0
 */
@RestController
public class OrderController {

    @Resource
    private PayApi payApi;

    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return payApi.addPay(payDTO);
    }

    @GetMapping(value = "/feign/pay/getInfo/{id}")
    private ResultData getInfo(@PathVariable("id") Integer id) {

        if (id == -1) throw new RuntimeException("id不能为负数");

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return payApi.getPayInfo(id);
    }

    @GetMapping("/feign/pay/getMyInfo")
    public String getMyInfo() {
        return payApi.myInfo();
    }


    /*// 删除+修改操作作为家庭作业，O(∩_∩)O。。。。。。。
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
    }

    @DeleteMapping("/consumer/pay/delete/{id}")
    public ResultData deletePayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/del/" + id, ResultData.class, id);
    }

    *//**
     * Update payment information.
     * @param payDTO the updated payment data transfer object
     * @return the result data of the update operation
     *//*
    @PutMapping("/consumer/pay/update")
    public ResultData updatePayInfo(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/update", payDTO, ResultData.class);
    }

    *//**
     * Get all payment information.
     * @return a list of all payment information
     *//*
    @GetMapping("/consumer/pay/getAll")
    public ResultData getAllPayInfo() {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/list", ResultData.class);
    }*/
}
