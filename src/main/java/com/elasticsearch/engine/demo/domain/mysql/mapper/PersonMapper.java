package com.elasticsearch.engine.demo.domain.mysql.mapper;

import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.domain.mysql.entity.PersonEntity;
import com.elasticsearch.engine.demo.dto.result.PersonGroupResult;
import com.elasticsearch.engine.model.annotion.EsQuery;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanghuan
 * @description: PersonMapper
 * @mail 958721894@qq.com
 * @date 2022-05-31 22:46
 */
@EsQueryIndex("person_es_index")
@Mapper
public interface PersonMapper {

    int insertList(@Param("persons") List<PersonEntity> persons);

    @EsQuery
    PersonEsEntity queryOne(@Param("personNo") String personNo, @Param("status") Integer status);

    @EsQuery
    List<PersonEsEntity> queryList(List<String> personNoList);

    @EsQuery
    PersonEsEntity queryByCreateDt(LocalDateTime createTime);

    @EsQuery
    Long count();

    @EsQuery
    List<PersonEsEntity> likePersonName(@Param("personName") String personName, @Param("status") Integer status);

    @EsQuery
    List<PersonEsEntity> groupBy(@Param("personName") String personName, @Param("status") Integer status);

    @EsQuery
    BigDecimal sum(String company);

    @EsQuery
    List<PersonGroupResult> sumGroup(@Param("company") List<String> company, @Param("status") Integer status);

    @EsQuery
    List<PersonGroupResult> having(@Param("company") List<String> company, @Param("status") Integer status);

    @EsQuery
    List<PersonEsEntity> pageQuery(PersonEntity person);

    @EsQuery(backColumn = "personNo",backColumnType = String.class)
    List<PersonEsEntity> findByStatus(@Param("status") Integer status);

    @EsQuery(backColumn = "id",backColumnType = Long.class)
    List<PersonEsEntity> findBySex(@Param("sex") Integer sex);


}
