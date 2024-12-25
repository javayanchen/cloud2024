package com.yc.cloud.controller;

import com.yc.cloud.api.PayApi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName OrderCircuitController
 * @Description TODO
 * @Author YanChen
 * @Date 2024/12/20 8:11
 * @Version 1.0
 */
@RestController
public class OrderCircuitController {

    @Resource
    private PayApi payApi;

    @GetMapping(value = "/feign/pay/circuit/{id}")
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "myCircuitFallback")
    public String myCircuitBreaker(@PathVariable("id") Integer id) {

        return payApi.myCircuit(id);
    }

    //myCircuitFallback就是服务降级后的兜底处理方法
    public String myCircuitFallback(Integer id, Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return "myCircuitFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }

    /**
     * (船的)舱壁,隔离
     *
     * @param id
     * @return
     */
    /*@GetMapping(value = "/feign/pay/bulkhead/{id}")
    @Bulkhead(name = "cloud-payment-service", fallbackMethod = "myBulkheadFallback", type = Bulkhead.Type.SEMAPHORE)
    public String myBulkhead(@PathVariable("id") Integer id) {
        return payApi.myBulkhead(id);
    }

    public String myBulkheadFallback(Throwable t) {
        return "myBulkheadFallback，隔板超出最大数量限制，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }*/
    @GetMapping(value = "/feign/pay/bulkhead/{id}")
    @Bulkhead(name = "cloud-payment-service",
            fallbackMethod = "myBulkheadPoolFallback",
            type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> myBulkheadThreadPool(@PathVariable("id") Integer id) {

        System.out.println(Thread.currentThread().getName() + "\t" + "-----开始进入");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t" + "-----准备离开");

        return CompletableFuture.supplyAsync(() -> payApi.myBulkhead(id) + "\t" + "Bulkhead.Type.THREADPOO");
    }

    public CompletableFuture<String> myBulkheadPoolFallback(Integer id, Throwable t) {
        return CompletableFuture.supplyAsync(() -> "Bulkhead.Type.THREADPOO, 系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~");
    }

    @GetMapping(value = "/feign/pay/ratelimit/{id}")
    @RateLimiter(name = "cloud-payment-service", fallbackMethod = "myRateLimitFallback")
    public String myBulkhead(@PathVariable("id") Integer id) {
        return payApi.myRateLimit(id);
    }

    public String myRateLimitFallback(Integer id, Throwable t) {
        return "你被限流了，禁止访问/(ㄒoㄒ)/~~";
    }


}
