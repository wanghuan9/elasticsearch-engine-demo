package com.elasticsearch.engine.demo.proxy.repository;

import com.elasticsearch.engine.demo.dto.query.SupplierItem;
import com.elasticsearch.engine.demo.dto.query.PersonResExtend;
import com.elasticsearch.engine.demo.execute.resultmodel.AggEntityExtend;
import com.elasticsearch.engine.demo.execute.resultmodel.SupplierItemEntity;
import com.elasticsearch.engine.demo.proxy.entity.params.SupplierItemProxyResExtend;
import com.elasticsearch.engine.mapping.annotation.From;
import com.elasticsearch.engine.model.annotion.EsQuery;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.model.domain.BaseESRepository;
import com.elasticsearch.engine.model.domain.BaseResp;
import org.elasticsearch.action.search.SearchResponse;

import java.time.LocalDateTime;
import java.util.List;

/**
 * EsAccountMapper
 * response:
 * 1.T *
 * 2.自定义 *
 *
 * @author JohenTeng
 * @date 2021/12/9
 */
@EsQueryIndex(value = "supplier_item_spare")
public interface SupplierItemRepository extends BaseESRepository<SupplierItemEntity, String> {

    /**
     * 查询单个
     *
     * @param param
     * @return
     */
    SupplierItemEntity queryOne(SupplierItem param);

    /**
     * List查询
     *
     * @param param
     * @return
     */
    List<SupplierItemEntity> queryList(SupplierItem param);

    /**
     * List查询
     * BaseResp 用于拿到list及count
     *
     * @param param
     * @return
     */
    BaseResp<SupplierItemEntity> queryByParam(SupplierItem param);

    /**
     * 自定义结果查询(分组查询)
     *
     * @param param
     * @return
     */
    List<AggEntityExtend> queryAggs(PersonResExtend param);

    /**
     * 辅助查询
     *
     * @return
     */
    SearchResponse querySearchResponse(SupplierItemProxyResExtend param);


    /**
     * 时间查询
     *
     * @return
     */
    List<SupplierItemEntity> queryList(@From LocalDateTime createDt);


    @EsQuery("select * from supplier_item_spare where item_no = #{itemNo} and status = #{status}")
    SupplierItemEntity queryOne(String itemNo, Integer status);


//    @UseRequestHook("aggReqHook")
//    @UseResponseHook("aggResRespHook")
//    AccountAggResult aggByParamAnn(SupplierItem param);

}
