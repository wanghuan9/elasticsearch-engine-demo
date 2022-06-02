package com.elasticsearch.engine.demo.domain.mapper;

import com.elasticsearch.engine.demo.domain.entity.PersonEntity;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wanghuan
 * @description: PersonMapper
 * @mail 958721894@qq.com
 * @date 2022-05-31 22:46
 */
@EsQueryIndex("supplier_item_spare")
@Mapper
public interface PersonMapper {
    int insertList(@Param("persons") List<PersonEntity> persons);

    PersonEntity getById(Long id);
}
