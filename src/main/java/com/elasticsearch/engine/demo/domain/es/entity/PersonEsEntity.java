package com.elasticsearch.engine.demo.domain.es.entity;

import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author wanghuan
 * @description: PersonEsEntity
 * @mail 958721894@qq.com
 * @date 2022-06-01 16:58
 */
@Data
@EsQueryIndex("person_es_index")
public class PersonEsEntity  {
    private String personNo;
    private String personName;
    private Long phone;
    private BigDecimal salary;
    private String company;
    private Integer status;
    private Integer sex;
    private String address;
    private LocalDateTime createTime;
    private String createUser;
    private String mail;
    private String hobby;
}
