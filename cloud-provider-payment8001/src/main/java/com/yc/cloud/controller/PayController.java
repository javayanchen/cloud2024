package com.yc.cloud.controller;

import com.yc.cloud.entity.Pay;
import com.yc.cloud.entity.PayDTO;
import com.yc.cloud.resp.ResultData;
import com.yc.cloud.resp.ReturnCodeEnum;
import com.yc.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PayController
 * @Description TODO
 * @Author YanChen
 * @Date 2024/12/19 9:51
 * @Version 1.0
 */
@RestController
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/getInfo")
    public String getInfo(@Value("${yc.info}")String info) {
        return "this info is " + info + ", and port is " + port;
    }

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {

        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值：" + i);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);

        return ResultData.success(i);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改", description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);

        return ResultData.success(pay);
    }

    //全部查询getAll作为家庭作业
    @GetMapping(value = "/pay/list")
    @Operation(summary = "查询全部流水", description = "查询全部支付流水方法")
    public ResultData<List<Pay>> getAll() {
        List<Pay> payList = payService.getAll();

        return ResultData.success(payList);
    }

    @RequestMapping(value = "/pay/error", method = RequestMethod.GET)
    public ResultData<Integer> getPayError() {
        Integer i = Integer.valueOf(200);
        try {
            System.out.println("--------come here");
            int data = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return ResultData.success(i);
    }
}
