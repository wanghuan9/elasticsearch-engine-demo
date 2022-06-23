package com.elasticsearch.engine.demo.domain.mysql.mapper;

import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.domain.mysql.entity.PersonExtendEntity;
import com.elasticsearch.engine.mybatis.annotion.MybatisEsQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    @MybatisEsQuery
    List<PersonEsEntity> queryList(@Param("status") Integer status, @Param("hobby") String hobby);

    @MybatisEsQuery(backColumn = "personNo", backColumnType = String.class)
    List<PersonEsEntity> queryListBack(@Param("status") Integer status, @Param("hobby") String hobby);

    /**
     * sql中person_extend
     *
     * @param status
     * @param hobby
     * @return
     */
    @MybatisEsQuery(tableName = "person_extend", backColumn = "personNo", backColumnType = String.class)
    List<PersonEsEntity> queryListBackPe(@Param("status") Integer status, @Param("hobby") String hobby);
}
