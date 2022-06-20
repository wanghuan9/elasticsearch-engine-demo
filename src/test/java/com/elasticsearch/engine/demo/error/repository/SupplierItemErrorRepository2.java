package com.elasticsearch.engine.demo.error.repository;

import com.elasticsearch.engine.base.mapping.annotation.Collapse;
import com.elasticsearch.engine.base.mapping.annotation.Term;
import com.elasticsearch.engine.base.model.domain.BaseEsRepository;
import com.elasticsearch.engine.demo.execute.resultmodel.SupplierItemEntity;

/**
 * 异常场景测试  未添加EsQueryIndex
 */
public interface SupplierItemErrorRepository2 extends BaseEsRepository<SupplierItemEntity, String> {

    /**
     * 查询单个
     *
     * @param itemNo
     * @return
     */
    SupplierItemEntity queryOne(@Term String itemNo, @Collapse Integer status);


}
