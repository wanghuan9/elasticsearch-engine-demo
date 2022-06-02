package com.elasticsearch.engine.demo.domain.es.repository;

import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.model.annotion.EsQuery;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.model.domain.BaseESRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanghuan
 * @description sql查询测试示例
 * <p>
 * 查询的PersonEsParamRepository 必须继承 BaseESRepository 否则无法扫描注册
 * <p>
 * @mail 958721894@qq.com
 * @date 2022/6/2 13:30
 */
@EsQueryIndex("person_es_index")
public interface PersonEsSqlRepository extends BaseESRepository<PersonEsEntity, Long> {


    @EsQuery("SELECT * FROM supplier_item_spare WHERE item_no = #{itemNo} AND status = #{status}")
    PersonEsEntity queryOne(String itemNo, Integer status2);

    @EsQuery("SELECT * FROM supplier_item_spare WHERE item_no IN (#{status})")
    List<PersonEsEntity> queryList(List<String> status);

    @EsQuery("SELECT * FROM supplier_item_spare WHERE create_dt > #{createDt}")
    PersonEsEntity queryByCreateDt(LocalDateTime createDt);

    @EsQuery("SELECT COUNT(1) FROM supplier_item_spare")
    Long count();

}
