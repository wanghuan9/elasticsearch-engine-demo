package com.elasticsearch.engine.demo.domain.mysql.jooq.repository;

import com.elasticsearch.engine.demo.domain.mysql.entity.PersonEntity;
import com.elasticsearch.engine.demo.dto.result.PersonGroupResult;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-05-25 21:58
 */
public interface PersonJooqDao{

    PersonEntity getByPersonNoAndStatus(String personNo, Integer status);

    List<PersonEntity> findByPersonNoIn(List<String> personNoList);

    List<PersonEntity> findByCreateTime(LocalDateTime createTime);

    Long countByStatus(Integer status);

    List<PersonEntity> findByPersonLike(String personName, String company);

    List<PersonEntity> groupBy(String personName);

    double sumQuery(String company);

    List<PersonGroupResult> sumGroup(List<String> company, Integer status);

    List<PersonGroupResult> havingQuery(List<String> company, Integer gtSalary);

}
