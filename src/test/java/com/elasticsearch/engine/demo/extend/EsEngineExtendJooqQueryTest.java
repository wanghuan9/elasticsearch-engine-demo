package com.elasticsearch.engine.demo.extend;

import com.elasticsearch.engine.base.common.utils.JsonParser;
import com.elasticsearch.engine.demo.domain.mysql.entity.PersonEntity;
import com.elasticsearch.engine.demo.domain.mysql.jooq.repository.PersonJooqDao;
import com.elasticsearch.engine.demo.dto.result.PersonGroupResult;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanghuan
 * @description jooq查询测试示例
 * @mail 958721894@qq.com
 * @date 2022-06-05 12:45
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsEngineExtendJooqQueryTest {
    
    @Resource
    private PersonJooqDao personJooqDao;

    /**
     * 单个查询
     */
    @Test
    public void testSqlOne() {
        PersonEntity personEntity = personJooqDao.getByPersonNoAndStatus("US2022060100001", 4);
        log.info("res:{}", JsonParser.asJson(personEntity));
    }

    /**
     *  list 查询
     */
    @Test
    public void testSqlList() {
        List<PersonEntity> supplierItemEntities = personJooqDao.findByPersonNoIn(Lists.newArrayList("US2022060100001","US2022060100002"));
        System.out.println(JsonParser.asJson(supplierItemEntities));
    }

    /**
     * 时间查询
     */
    @Test
    public void testSqlTime() {
        List<PersonEntity> supplierItemEntity = personJooqDao.findByCreateTime(LocalDateTime.now().minusDays(300));
        System.out.println(JsonParser.asJson(supplierItemEntity));
    }

    /**
     * count查询
     */
    @Test
    public void testSqlCount() {
        Long count = personJooqDao.countByStatus(2);
        System.out.println(JsonParser.asJson(count));
    }

    /**
     * like查询
     */
    @Test
    public void testSqlLike() {
        List<PersonEntity> res = personJooqDao.findByPersonLike("%狗%","%蚁%");
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 分组查询
     */
    @Test
    public void testSqlGroup() {
        List<PersonEntity> res = personJooqDao.groupBy("%李狗蛋%");
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 聚合查询(sum)
     */
    @Test
    public void testSqlSum() {
        double res = personJooqDao.sumQuery("腾讯");
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 分组聚合查询
     */
    @Test
    public void testSqlSumGroup() {
        List<PersonGroupResult> results = personJooqDao.sumGroup(Lists.newArrayList("蚂蚁", "米哈游", "美团", "字节跳动"), 4);
        System.out.println(JsonParser.asJson(results));
    }

    /**
     * Having分组聚合查询
     */
    @Test
    public void testSqlHaving() {
        List<PersonGroupResult> results = personJooqDao.havingQuery(Lists.newArrayList("蚂蚁", "米哈游", "美团", "字节跳动"), 450000);
        System.out.println(JsonParser.asJson(results));
    }

    /**
     * 对象参数查询 测试
     */
    @Test
    public void testSqlPageQuery() {
        PersonEntity person = new PersonEntity();
        person.setStatus(1);
        person.setSex(1);
        List<PersonEntity> results = personJooqDao.pageQuery(person);
        System.out.println(JsonParser.asJson(results));
    }


    //☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺ 关联查询测试 ☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺//

    //☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺ 回表查询测试 ☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺//

    /**
     * 回表查询测试 personNo
     */
    @Test
    public void testSqlBackByPersonNo() {
        List<PersonEntity> results = personJooqDao.findByStatus(4);
        System.out.println(JsonParser.asJson(results));
    }

    /**
     * 回表查询测试 id
     */
    @Test
    public void testSqlBackById() {
        List<PersonEntity> results = personJooqDao.findBySex(1);
        System.out.println(JsonParser.asJson(results));
    }

}
