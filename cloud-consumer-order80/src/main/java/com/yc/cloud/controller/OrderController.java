package com.yc.cloud.controller;

import com.yc.cloud.entity.PayDTO;
import com.yc.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author YanChen
 * @Date 2024/12/19 10:56
 * @Version 1.0
 */
@RestController
public class OrderController {

    //public static final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码
    public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/getInfo")
    private String getInfoByConsul() {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/getInfo", String.class);
    }

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     *
     * @param payDTO
     * @return
     */
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    // 删除+修改操作作为家庭作业，O(∩_∩)O。。。。。。。
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
    }

    @DeleteMapping("/consumer/pay/delete/{id}")
    public ResultData deletePayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/del/" + id, ResultData.class, id);
    }

    /**
     * Update payment information.
     * @param payDTO the updated payment data transfer object
     * @return the result data of the update operation
     */
    @PutMapping("/consumer/pay/update")
    public ResultData updatePayInfo(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/update", payDTO, ResultData.class);
    }

    /**
     * Get all payment information.
     * @return a list of all payment information
     */
    @GetMapping("/consumer/pay/getAll")
    public ResultData getAllPayInfo() {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/list", ResultData.class);
    }
}
