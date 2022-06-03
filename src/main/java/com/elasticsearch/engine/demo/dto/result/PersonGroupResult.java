package com.elasticsearch.engine.demo.dto.result;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wanghuan
 * @description PersonGroupResult
 * @mail 958721894@qq.com
 * @date 2022-06-03 17:12
 */
@Data
public class PersonGroupResult {
    
    private String company;
    private BigDecimal sumSalary;
}
