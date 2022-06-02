package com.elasticsearch.engine.demo.common.utils;

import lombok.extern.slf4j.Slf4j;


/**
 * @author wanghuan
 * @description: 生成业务单据编号工具类
 * @mail 958721894@qq.com
 * @date 2022-06-01 20:11
 */
@Slf4j
public class GenerateBusinessNoUtils {


    /**
     * 生成仓库编码
     *
     * @return
     */
    public static String generateUserNo() {
        return "US" + new SnowflakeIdWorker(7, 8, 9).nextId();
    }
}
