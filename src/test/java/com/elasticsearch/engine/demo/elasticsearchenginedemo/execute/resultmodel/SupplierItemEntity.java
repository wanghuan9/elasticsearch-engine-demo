package com.elasticsearch.engine.demo.elasticsearchenginedemo.execute.resultmodel;

import com.elasticsearch.engine.elasticsearchengine.model.domain.BaseHit;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SupplierItemEntity extends BaseHit {

    private String itemNo;

    private Integer status;

    private String productName;

    private BigDecimal warehousePrice;

    private LocalDateTime createDt;

}

