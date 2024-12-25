package com.yc.cloud.service.impl;

import com.yc.cloud.mapper.StorageMapper;
import com.yc.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    /**
     * 扣减库存
     */
    @Override
    @GlobalTransactional
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }
}