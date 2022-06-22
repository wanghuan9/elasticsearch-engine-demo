package com.elasticsearch.engine.demo.domain.es.errorrepository;

import com.elasticsearch.engine.base.mapping.annotation.Collapse;
import com.elasticsearch.engine.base.mapping.annotation.Term;
import com.elasticsearch.engine.base.model.domain.BaseEsRepository;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;

/**
 * @author wanghuan
 * @description PersonEsErrorRepositoryNoEsQueryIndex
 * @mail 958721894@qq.com
 * @date 2022-06-22 08:50
 */
public interface PersonEsNoEsQueryIndexErrorRepository extends BaseEsRepository<PersonEsEntity, Long> {

    /**
     * 查询单个
     *
     * @param personNo
     * @return
     */
    PersonEsEntity queryOne(@Term String personNo, @Collapse Integer status);

}
