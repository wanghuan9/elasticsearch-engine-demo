package com.elasticsearch.engine.demo.domain.es.errorrepository;

import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.dto.query.PersonBaseQuery;

/**
 * @author wanghuan
 * @description PersonEsNoExtendBaseESRepository
 * @mail 958721894@qq.com
 * @date 2022-06-22 08:53
 */
@EsQueryIndex("person_es_index")
public interface PersonEsNoExtendBaseESRepository {


    /**
     * 查询单个
     *
     * @param param
     * @return
     */
    PersonEsEntity queryOne(PersonBaseQuery param);

}
