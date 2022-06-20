package com.elasticsearch.engine.demo.error.repository;

import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.base.model.domain.BaseEsRepository;
import com.elasticsearch.engine.demo.dto.query.SupplierItem;
import com.elasticsearch.engine.demo.execute.resultmodel.SupplierItemEntity;

/**
 * 异常场景测试  出入参不符合标准
 */
@EsQueryIndex(value = "supplier_item_spare")
public interface SupplierItemParamErrorRepository extends BaseEsRepository<SupplierItemEntity, String> {

    /**
     * 入参异常测试
     *
     * @param param
     * @return
     */
    SupplierItemEntity queryOne(SupplierItem param, SupplierItemEntity item);

    /**
     * 出参异常测试
     *
     * @param param
     * @return
     */
    SupplierItem queryOne(SupplierItem param);
}
