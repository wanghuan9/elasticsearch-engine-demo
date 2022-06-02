package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.hook.ResponseHook;
import com.elasticsearch.engine.mapping.annotation.Aggs;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.model.annotion.Ignore;
import com.elasticsearch.engine.model.constant.EsConstant;
import com.elasticsearch.engine.model.domain.DefaultAggResp;
import com.elasticsearch.engine.model.exception.EsHelperQueryException;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;

import java.util.List;
import java.util.Objects;

@Slf4j
@EsQueryIndex(value = "supplier_item_spare")
@Data
public class SupplierItemResExtend implements ResponseHook<List<DefaultAggResp>> {

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
            throw new EsHelperQueryException("aggs param is null, result aggs is null");
        }
//        resp.getInternalResponse()
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

