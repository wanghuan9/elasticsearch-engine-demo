package com.elasticsearch.engine.demo.domain.mysql.mapper;

import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.domain.mysql.entity.PersonEntity;
import com.elasticsearch.engine.demo.dto.result.PersonGroupResult;
import com.elasticsearch.engine.mybatis.annotion.MybatisEsQuery;
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

    @MybatisEsQuery
    PersonEsEntity queryOne(@Param("personNo") String personNo, @Param("status") Integer status);

    @MybatisEsQuery
    List<PersonEsEntity> queryList(List<String> personNoList);

    @MybatisEsQuery
    List<PersonEsEntity> queryByCreateDt(LocalDateTime createTime);

    @MybatisEsQuery
    Long count();

    @MybatisEsQuery
    List<PersonEsEntity> likePersonName(@Param("personName") String personName, @Param("status") Integer status);

    @MybatisEsQuery
    List<PersonEsEntity> groupBy(@Param("personName") String personName, @Param("status") Integer status);

    @MybatisEsQuery
    BigDecimal sum(String company);

    @MybatisEsQuery
    List<PersonGroupResult> sumGroup(@Param("company") List<String> company, @Param("status") Integer status);

    @MybatisEsQuery
    List<PersonGroupResult> having(@Param("company") List<String> company, @Param("status") Integer status);

    @MybatisEsQuery
    List<PersonEsEntity> pageQuery(PersonEntity person);

    @MybatisEsQuery(backColumn = "personNo",backColumnType = String.class)
    List<PersonEsEntity> findByStatus(@Param("status") Integer status);

    @MybatisEsQuery(backColumn = "id",backColumnType = Long.class)
    List<PersonEsEntity> findBySex(@Param("sex") Integer sex);


}
