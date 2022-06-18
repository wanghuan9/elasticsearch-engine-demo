package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.base.mapping.annotation.Sort;
import com.elasticsearch.engine.base.mapping.model.extend.SignParam;
import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import lombok.Data;
import org.elasticsearch.search.sort.SortOrder;

@EsQueryIndex("person_es_index")
@Data
public class SupplierItemSort {

    @Sort(type = SortOrder.DESC)
    private SignParam status;

    private String productName;

}

