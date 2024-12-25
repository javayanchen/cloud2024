package com.yc.cloud.service;

import com.yc.cloud.entity.Pay;

import java.util.List;

/**
 * @ClassName PayService
 * @Description TODO
 * @Author 18727
 * @Date 2024/12/19 9:47
 * @Version 1.0
 */
public interface PayService {

    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);

    public Pay   getById(Integer id);
    public List<Pay> getAll();
}
