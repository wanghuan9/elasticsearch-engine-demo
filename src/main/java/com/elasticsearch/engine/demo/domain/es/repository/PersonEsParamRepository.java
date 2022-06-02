package com.elasticsearch.engine.demo.domain.es.repository;

import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.mapping.annotation.Collapse;
import com.elasticsearch.engine.mapping.annotation.From;
import com.elasticsearch.engine.mapping.annotation.Term;
import com.elasticsearch.engine.mapping.annotation.Terms;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.model.domain.BaseESRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanghuan
 * @description 注解查询 param参数
 * <p>
 * 查询的PersonEsParamRepository 必须继承 BaseESRepository 否则无法扫描注册
 * <p>
 * 规则:
 * 1)查询参数为1个或多个, 参数类型都是基础类型
 * 2)响应参数的类型或者泛型 必须为Repository的泛型或者自定义响应的泛型,或者固定结果DefaultResp的子类型
 * @mail 958721894@qq.com
 * @date 2022/6/2 13:19
 */
//@EsQueryIndex(index = "person_es_index")
//@EsQueryIndex(index = "${es.person.index.name}")
@EsQueryIndex(value = "${es.person.index.name:person_es_index}")
public interface PersonEsParamRepository extends BaseESRepository<PersonEsEntity, Long> {

    /**
     * 查询单个
     *
     * @param itemNo
     * @return
     */
    PersonEsEntity queryOne(@Term String itemNo, @Collapse Integer status);

    /**
     * List查询
     *
     * @return
     */
    List<PersonEsEntity> queryList(@Terms List<String> itemNoList);

    /**
     * 时间查询
     *
     * @return
     */
    List<PersonEsEntity> queryList(@From LocalDateTime createDt);


}
