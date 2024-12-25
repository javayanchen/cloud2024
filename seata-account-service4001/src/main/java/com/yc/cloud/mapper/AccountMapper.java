package com.yc.cloud.mapper;

import com.yc.cloud.entity.Account;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


public interface AccountMapper extends Mapper<Account> {

    /**
     * @param userId
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}