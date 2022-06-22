package com.elasticsearch.engine.demo.domain.es.errorrepository;

import com.elasticsearch.engine.base.model.annotion.EsQuery;
import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.base.model.domain.BaseEsRepository;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;

/**
 * @author wanghuan
 * @description EsEngineSqlErrorRepository
 * @mail 958721894@qq.com
 * @date 2022-06-22 15:15
 */
@EsQueryIndex("person_es_index")
public interface EsEngineSqlErrorRepository extends BaseEsRepository<PersonEsEntity, Long> {

    /**
     * 不支持的sql
     * 
     * @return
     */
    @EsQuery("select distinct status from supplier_item_spare")
    PersonEsEntity queryDistinct();

    /**
     * sql错误
     * @param personNo
     * @param status
     * @return
     */
    @EsQuery("SELECT  FROM person_es_index WHERE personNo = #{personNo} AND status = #{status}")
    PersonEsEntity querySqlError(String personNo, Integer status);

    /**
     * sql错误 Unknown column
     * @param personNo
     * @return
     */
    @EsQuery("SELECT * FROM person_es_index WHERE personNo_2 = #{personNo} AND status = #{status}")
    PersonEsEntity queryUnknownColumnError(String personNo, Integer status);
    
    /**
     * 参数错误
     * @param personNo
     * @return
     */
    @EsQuery("SELECT * FROM person_es_index WHERE personNo = #{personNo} AND status = #{status}")
    PersonEsEntity queryParamError(String personNo);

}
