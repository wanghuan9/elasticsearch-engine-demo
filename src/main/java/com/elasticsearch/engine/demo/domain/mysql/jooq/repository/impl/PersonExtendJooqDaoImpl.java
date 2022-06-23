package com.elasticsearch.engine.demo.domain.mysql.jooq.repository.impl;

import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.domain.mysql.jooq.generator.Tables;
import com.elasticsearch.engine.demo.domain.mysql.jooq.generator.tables.Person;
import com.elasticsearch.engine.demo.domain.mysql.jooq.generator.tables.PersonExtend;
import com.elasticsearch.engine.demo.domain.mysql.jooq.repository.PersonExtendJooqDao;
import com.elasticsearch.engine.jooq.annotion.JooqEsQuery;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wanghuan
 * @description PersonExtendJooqDaoImpl
 * @mail 958721894@qq.com
 * @date 2022-06-05 12:31
 */
@EsQueryIndex("person_es_index")
@Component
public class PersonExtendJooqDaoImpl implements PersonExtendJooqDao {

    @Autowired
    private DSLContext context;

    private final PersonExtend PERSON_EXTEND = Tables.PERSON_EXTEND;


    private final Person PERSON = Tables.PERSON;


    /**
     * @param status
     * @param hobby
     * @return
     */
    @JooqEsQuery
    @Override
    public List<PersonEsEntity> queryList(Integer status, String hobby) {
        return context.select().from(PERSON).leftJoin(PERSON_EXTEND).on(PERSON.PERSON_NO.eq(PERSON_EXTEND.PERSON_NO))
                .where(PERSON.STATUS.eq(status.byteValue()).and(PERSON_EXTEND.HOBBY.eq(hobby))
                ).fetchInto(PersonEsEntity.class);
    }

    @JooqEsQuery(backColumn = "personNo", backColumnType = String.class)
    @Override
    public List<PersonEsEntity> queryListBack(Integer status, String hobby) {
        return context.select().from(PERSON).leftJoin(PERSON_EXTEND).on(PERSON.PERSON_NO.eq(PERSON_EXTEND.PERSON_NO))
                .where(PERSON.STATUS.eq(status.byteValue()).and(PERSON_EXTEND.HOBBY.eq(hobby))
                ).fetchInto(PersonEsEntity.class);
    }


    @JooqEsQuery(tableName = "person_extend", backColumn = "personNo", backColumnType = String.class)
    @Override
    public List<PersonEsEntity> queryListBackPe(Integer status, String hobby) {
        return context.select().from(PERSON).leftJoin(PERSON_EXTEND).on(PERSON.PERSON_NO.eq(PERSON_EXTEND.PERSON_NO))
                .where(PERSON.STATUS.eq(status.byteValue()).and(PERSON_EXTEND.HOBBY.eq(hobby))
                ).fetchInto(PersonEsEntity.class);
    }
}
