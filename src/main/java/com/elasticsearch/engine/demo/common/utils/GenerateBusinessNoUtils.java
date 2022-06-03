package com.elasticsearch.engine.demo.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author wanghuan
 * @description: 生成业务单据编号工具类
 * @mail 958721894@qq.com
 * @date 2022-06-01 20:11
 */
@Slf4j
public class GenerateBusinessNoUtils {

    private static AtomicInteger count = new AtomicInteger();
    
    /**
     * 生成仓库编码
     *
     * @return
     */
    public static String generateUserNo() {
        return "US" + new SnowflakeIdWorker(7, 8, 9).nextId();
    }

    /**
     * 生成自增业务单号
     *
     * @return
     */
    public static String generateBusinessNo() {
        String key = "US" + 20220601;
        long num = count.incrementAndGet();
        String str = String.format("%05d", num);
        return key + str;
    }

}
