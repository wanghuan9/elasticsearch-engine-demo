package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.base.holder.AbstractEsRequestHolder;
import com.elasticsearch.engine.base.hook.RequestHook;
import com.elasticsearch.engine.base.mapping.annotation.PageAndOrder;
import com.elasticsearch.engine.base.mapping.model.extend.PageParam;
import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import lombok.Data;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-04-18 14:42
 */
@Data
@EsQueryIndex(value = "${elastic.search.index.supply.product:supply_product}", include = {"id", "productNo", "goodNo"})
public class ProductQueryByEs4AppReq extends ProductQueryByEsBaseReq implements RequestHook<ProductQueryByEs4AppReq> {

    @PageAndOrder
    private PageParam pageParam;

    @Override
    public AbstractEsRequestHolder handleRequest(AbstractEsRequestHolder holder, ProductQueryByEs4AppReq req) {
        super.handleRequest(holder, req);
        return holder;
    }
}

