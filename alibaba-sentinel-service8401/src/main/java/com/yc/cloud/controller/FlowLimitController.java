package com.yc.cloud.controller;

import com.yc.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class FlowLimitController {

    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC() {

        flowLimitService.common();
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD() {

        flowLimitService.common();
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String now_date = dateFormat.format(date);

        log.info(now_date + "-----testE, 流控效果---排队等待");
        return "------testE";
    }
}
