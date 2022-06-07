package com.elasticsearch.engine.demo.domain.mysql.jooq.repository.impl;

import com.elasticsearch.engine.demo.domain.mysql.entity.PersonEntity;
import com.elasticsearch.engine.demo.domain.mysql.jooq.generator.Tables;
import com.elasticsearch.engine.demo.domain.mysql.jooq.generator.tables.Person;
import com.elasticsearch.engine.demo.domain.mysql.jooq.repository.PersonJooqDao;
import com.elasticsearch.engine.demo.dto.result.PersonGroupResult;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.model.annotion.JooqEsQuery;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-05-25 21:58
 */
@EsQueryIndex("person_es_index")
@Component
public class PersonJooqDaoImpl implements PersonJooqDao {

    @Autowired
    private DSLContext context;

    private final Person PERSON = Tables.PERSON;

    /**
     * @param personNo
     * @param status
     * @return
     */
    @JooqEsQuery(backColumn = "personNo",backColumnType = String.class)
    @Override
    public PersonEntity getByPersonNoAndStatus(String personNo, Integer status) {
        return context.select().from(PERSON).where(
                PERSON.PERSON_NO.eq(personNo).and(PERSON.STATUS.eq(status.byteValue()))
        ).fetchOneInto(PersonEntity.class);
    }

    /**
     * @param personNoList
     * @return
     */
    @JooqEsQuery
    @Override
    public List<PersonEntity> findByPersonNoIn(List<String> personNoList) {
        return context.select().from(PERSON).where(
                PERSON.PERSON_NO.in(personNoList)
        ).fetchInto(PersonEntity.class);
    }

    /**
     * @param createTime
     * @return
     */
    @JooqEsQuery
    @Override
    public List<PersonEntity> findByCreateTime(LocalDateTime createTime) {
        return context.select().from(PERSON).where(
                PERSON.CREATE_TIME.gt(createTime)
        ).fetchInto(PersonEntity.class);
    }

    /**
     * @param status
     * @return
     */
    @JooqEsQuery
    @Override
    public Long countByStatus(Integer status) {
        return context.selectCount().from(PERSON).where(
                PERSON.STATUS.eq(status.byteValue())
        ).fetchOne(0, Long.class);
    }

    /**
     * @param personName
     * @param company
     * @return
     */
    @JooqEsQuery(backColumn = "personNo",backColumnType = String.class)
    @Override
    public List<PersonEntity> findByPersonLike(String personName, String company) {
        return context.select().from(PERSON).where(
                PERSON.PERSON_NAME.like(personName)
                        .or(PERSON.COMPANY.like(company))
        ).fetchInto(PersonEntity.class);
    }

    /**
     * @param personName
     * @return
     */
    @JooqEsQuery
    @Override
    public List<PersonEntity> groupBy(String personName) {
        return context.select(PERSON.STATUS).from(PERSON).where(
                        PERSON.PERSON_NAME.like(personName)
                ).groupBy(PERSON.STATUS)
                .fetchInto(PersonEntity.class);
    }

    /**
     * @param company
     * @return
     */
    @JooqEsQuery
    @Override
    public double sumQuery(String company) {
        return context.select(DSL.sum(PERSON.SALARY)).from(PERSON).where(
                PERSON.COMPANY.eq(company)
        ).fetchOne(0, Double.class);
    }

    /**
     * @param company
     * @param status
     * @return
     */
    @JooqEsQuery
    @Override
    public List<PersonGroupResult> sumGroup(List<String> company, Integer status) {
        return context.select(PERSON.COMPANY, DSL.sum(PERSON.SALARY)).from(PERSON).where(
                        PERSON.COMPANY.in(company)
                ).groupBy(PERSON.COMPANY)
                .fetchInto(PersonGroupResult.class);
    }

    /**
     * @param company
     * @param gtSalary
     * @return
     */
    @JooqEsQuery
    @Override
    public List<PersonGroupResult> havingQuery(List<String> company, Integer gtSalary) {
        return context.select(PERSON.COMPANY, DSL.sum(PERSON.SALARY)).from(PERSON).where(
                        PERSON.COMPANY.in(company)
                )
                .groupBy(PERSON.COMPANY)
                .having(DSL.sum(PERSON.SALARY).gt(new BigDecimal(gtSalary)))
                .fetchInto(PersonGroupResult.class);
    }
}
