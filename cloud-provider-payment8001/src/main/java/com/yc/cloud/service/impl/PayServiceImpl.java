package com.yc.cloud.service.impl;

import com.yc.cloud.entity.Pay;
import com.yc.cloud.mapper.PayMapper;
import com.yc.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PayServiceImpl
 * @Description TODO
 * @Author YanChen
 * @Date 2024/12/19 9:47
 * @Version 1.0
 */
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;


    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
