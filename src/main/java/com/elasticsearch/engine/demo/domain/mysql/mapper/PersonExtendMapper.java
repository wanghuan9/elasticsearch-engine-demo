package com.elasticsearch.engine.demo.domain.mysql.mapper;

import com.elasticsearch.engine.demo.domain.mysql.entity.PersonExtendEntity;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wanghuan
 * @description: PersonMapper
 * @mail 958721894@qq.com
 * @date 2022-05-31 22:46
 */
@EsQueryIndex("person_es_index")
@Mapper
public interface PersonExtendMapper {
    int insertList(List<PersonExtendEntity> persons);
}
