package com.yc.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName PayDTO
 * @Description TODO
 * @Author YanChen
 * @Date 2024/12/19 11:42
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO {
    private Integer id;
    //支付流水号
    private String payNo;
    //订单流水号
    private String orderNo;
    //用户账号ID
    private Integer userId;
    //交易金额
    private BigDecimal amount;
}