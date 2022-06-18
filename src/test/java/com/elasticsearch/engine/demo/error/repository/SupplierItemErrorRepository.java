package com.elasticsearch.engine.demo.error.repository;

import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.demo.dto.query.SupplierItem;
import com.elasticsearch.engine.demo.execute.resultmodel.SupplierItemEntity;

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
