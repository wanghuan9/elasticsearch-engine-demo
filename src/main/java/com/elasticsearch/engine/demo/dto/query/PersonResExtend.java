package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.hook.ResponseHook;
import com.elasticsearch.engine.mapping.annotation.Aggs;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.model.annotion.Ignore;
import com.elasticsearch.engine.model.constant.EsConstant;
import com.elasticsearch.engine.model.domain.DefaultAggResp;
import com.elasticsearch.engine.model.exception.EsEngineQueryException;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;

import java.util.List;
import java.util.Objects;

/**
 * @author wanghuan
 * @description 自定义扩展响应
 * <p>
 * 当查询结果比较复杂 不是简单的将hits转为json对象时, 可以通过自定义响应对结果进行扩展
 * <p>
 * 例如 负责的分组嵌套查询, 或者响应结果未map之类的
 * @mail 958721894@qq.com
 * @date 2022/6/2 10:59
 */
@Slf4j
@EsQueryIndex("person_es_index")
@Data
public class PersonResExtend implements ResponseHook<List<DefaultAggResp>> {

    @Aggs
    private Integer status;

    @Ignore
    private List<String> itemNoList;

    /**
     * user define the method to handle ElasticSearch-Response
     *
     * @param resp return
     */
    @Override
    public List<DefaultAggResp> handleResponse(SearchResponse resp) {
        List<DefaultAggResp> rr = Lists.newArrayList();
        if (Objects.isNull(resp.getAggregations())) {
            throw new EsEngineQueryException("aggs param is null, result aggs is null");
        }
        Terms aggs = resp.getAggregations().get(EsConstant.AGG);
        for (Terms.Bucket agg : aggs.getBuckets()) {
            if (!agg.getKeyAsString().equals(EsConstant.STRING_ZERO)) {
                DefaultAggResp result = new DefaultAggResp();
                String id = agg.getKeyAsString();
                long docCount = agg.getDocCount();
                result.setKey(id);
                result.setCount(docCount);
                rr.add(result);
            }
        }
        return rr;
    }
}

