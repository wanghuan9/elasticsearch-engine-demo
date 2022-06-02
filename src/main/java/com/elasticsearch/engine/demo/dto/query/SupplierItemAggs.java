package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.mapping.annotation.Aggs;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import lombok.Data;

/**
* @description SupplierItemAggs 
* @author wanghuan
* @mail 958721894@qq.com       
* @date 2022/6/2 09:29 
*/
@EsQueryIndex(value = "supplier_item_spare")
@Data
public class SupplierItemAggs {

    @Aggs(type = Aggs.COUNT_DESC)
    private Integer status;
}
