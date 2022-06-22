package com.elasticsearch.engine.demo.domain.es.error;

import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.base.model.domain.BaseEsRepository;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.dto.query.PersonBaseQuery;
import com.elasticsearch.engine.demo.dto.query.PersonResExtend;

/**
 * @author wanghuan
 * @description PersonEsErrorRepositoryNoEsQueryIndex
 * @mail 958721894@qq.com
 * @date 2022-06-22 08:50
 */
@EsQueryIndex("person_es_index")
public interface PersonEsParamErrorRepository extends BaseEsRepository<PersonEsEntity, Long> {


    /**
     * 入参异常测试
     *
     * @param param
     * @return
     */
    PersonEsEntity queryOne(PersonBaseQuery param, PersonEsEntity item);

    /**
     * 出参异常测试
     *
     * @param param
     * @return
     */
    PersonResExtend queryOne(PersonBaseQuery param);
}
