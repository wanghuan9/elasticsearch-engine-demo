package com.elasticsearch.engine.demo.domain.mysql.jooq.repository;

import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;

import java.util.List;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-05-31 23:18
 */
public interface PersonExtendJooqDao {

    List<PersonEsEntity> queryList(Integer status, String hobby);

    List<PersonEsEntity> queryListBack(Integer status, String hobby);

    List<PersonEsEntity> queryListBackPe(Integer status, String hobby);

}
