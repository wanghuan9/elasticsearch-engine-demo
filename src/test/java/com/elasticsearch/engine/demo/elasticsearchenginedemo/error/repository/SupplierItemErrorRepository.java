package com.elasticsearch.engine.demo.elasticsearchenginedemo.error.repository;

import com.elasticsearch.engine.demo.elasticsearchenginedemo.execute.querymodel.SupplierItem;
import com.elasticsearch.engine.demo.elasticsearchenginedemo.execute.resultmodel.SupplierItemEntity;
import com.elasticsearch.engine.elasticsearchengine.model.annotion.EsQueryIndex;

/**
 * 异常场景测试  未继承BaseESRepository
 */
@EsQueryIndex(value = "supplier_item_spare")
public interface SupplierItemErrorRepository {

    /**
     * 查询单个
     *
     * @param param
     * @return
     */
    SupplierItemEntity queryOne(SupplierItem param);
}
