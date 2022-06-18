package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.base.model.annotion.Ignore;
import lombok.Data;

import java.util.List;

@EsQueryIndex(value = "supplier_item_spare")
@Data
public class SupplierItemIgnore {

    private List<String> itemNo;

    @Ignore
    private String productName;

}

