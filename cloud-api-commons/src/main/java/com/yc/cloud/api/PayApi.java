package com.yc.cloud.api;

import com.yc.cloud.entity.PayDTO;
import com.yc.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName PayApi
 * @Description TODO
 * @Author 18727
 * @Date 2024/12/19 15:34
 * @Version 1.0
 */
//@FeignClient("cloud-payment-service")
@FeignClient("cloud-gateway")
public interface PayApi {

    /**
     * 新增一条支付相关流水记录
     * @param payDTO
     * @return
     */
    @PostMapping("/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    /**
     * 按照主键记录查询支付流水信息
     * @param id
     * @return
     */
    @GetMapping("/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id);

    /**
     * openfeign天然支持负载均衡演示
     * @return
     */
    @GetMapping(value = "/pay/getInfo")
    public String myInfo();

    /*
     * @Title: myCircuit
     * @Description: TODO 
     * @Date: 2024-12-20 08:11:13
     * @Params: [id]
     * @Return: String
     */
    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);

    @GetMapping("/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id") Integer id);

    @GetMapping("/pay/ratelimit/{id}")
    public String myRateLimit(@PathVariable("id") Integer id);

    /**
     * Micrometer(Sleuth)进行链路监控的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例01
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例02
     * @return
     */
    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo();
}
