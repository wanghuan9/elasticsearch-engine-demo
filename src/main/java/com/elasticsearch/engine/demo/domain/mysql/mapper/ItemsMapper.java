package com.elasticsearch.engine.demo.domain.mysql.mapper;

import com.elasticsearch.engine.base.model.annotion.EsQuery;
import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.demo.domain.mysql.entity.ItemsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-05-07 23:37
 */
@EsQueryIndex("supplier_item_spare")
@Mapper
public interface ItemsMapper {

    @EsQuery
    ItemsEntity getByItemNo(@Param("itemNo") String itemNo, @Param("status") String status);
}
