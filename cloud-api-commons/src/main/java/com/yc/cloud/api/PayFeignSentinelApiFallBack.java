package com.yc.cloud.api;

import com.yc.cloud.resp.ResultData;
import com.yc.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {


    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),
                "对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}