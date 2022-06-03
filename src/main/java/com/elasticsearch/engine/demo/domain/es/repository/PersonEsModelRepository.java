package com.elasticsearch.engine.demo.domain.es.repository;

import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.dto.query.PersonBaseQuery;
import com.elasticsearch.engine.demo.dto.query.PersonResExtend;
import com.elasticsearch.engine.demo.dto.query.PersonSearchResponseRes;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.model.domain.BaseESRepository;
import com.elasticsearch.engine.model.domain.BaseResp;
import com.elasticsearch.engine.model.domain.DefaultAggResp;
import org.elasticsearch.action.search.SearchResponse;

import java.util.List;

/**
 * @author wanghuan
 * @description 注解查询 model参数
 * <p>
 * 查询的PersonEsParamRepository 必须继承 BaseESRepository 否则无法扫描注册
 * <p>
 * 规则:
 * 1)查询参数必须为1个, 并且不是基础类型
 * 2)响应参数的类型或者泛型 必须为Repository的泛型或者自定义响应的泛型,或者固定结果DefaultResp的子类型
 * @mail 958721894@qq.com
 * @date 2022/6/2 13:19
 */
@EsQueryIndex("person_es_index")
public interface PersonEsModelRepository extends BaseESRepository<PersonEsEntity, Long> {

    /**
     * 查询单个
     *
     * @param param
     * @return
     */
    PersonEsEntity queryOne(PersonBaseQuery param);

    /**
     * List查询
     *
     * @param param
     * @return
     */
    List<PersonEsEntity> queryList(PersonBaseQuery param);

    /**
     * List查询(可以用于分页查询结果构建)
     * BaseResp 用于拿到list及count
     *
     * @param param
     * @return
     */
    BaseResp<PersonEsEntity> queryListBaseResp(PersonBaseQuery param);

    /**
     * 固定结果值查询
     *
     * @param param
     * @return
     */
    BaseResp<DefaultAggResp> queryAggDefaultResp(PersonBaseQuery param);

    /**
     * 自定义结果查询(分组查询)
     *
     * @param param
     * @return
     */
    List<DefaultAggResp> queryAgg(PersonResExtend param);

    /**
     * 自定义结果查询(拿到原生的SearchResponse)
     *
     * @return
     */
    SearchResponse querySearchResponse(PersonSearchResponseRes param);

}
