package com.elasticsearch.engine.demo.extend.mybatis.mapper;

import com.elasticsearch.engine.demo.domain.entity.ItemsEntity;
import com.elasticsearch.engine.model.annotion.EsQuery;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-05-07 23:37
 */
@EsQueryIndex("supplier_item_spare")
@Mapper
public interface ItemsMapper2 {

    @EsQuery
    ItemsEntity getByItemNo(@Param("itemNo") String itemNo, @Param("status") String status);
}
