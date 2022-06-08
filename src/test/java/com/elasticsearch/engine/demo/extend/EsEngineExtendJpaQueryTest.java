package com.elasticsearch.engine.demo.extend;


import com.elasticsearch.engine.common.utils.JsonParser;
import com.elasticsearch.engine.demo.domain.mysql.entity.PersonEntity;
import com.elasticsearch.engine.demo.domain.mysql.repository.PersonExtendRepository;
import com.elasticsearch.engine.demo.domain.mysql.repository.PersonRepository;
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
 * @description mybatis查询测试示例
 * <p>
 * 查询的PersonEsParamRepository 必须继承 BaseESRepository 否则无法扫描注册
 * <p>
 * @mail 958721894@qq.com
 * @date 2022/6/2 2022/6/2 14:24
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsEngineExtendJpaQueryTest {

    @Resource
    private PersonRepository personRepository;

    @Resource
    private PersonExtendRepository personExtendRepository;

    /**
     * 单个查询
     */
    @Test
    public void testSqlOne() {
        PersonEntity personEntity = personRepository.getByPersonNoAndStatus("US2022060100001", 1);
        log.info("res:{}", JsonParser.asJson(personEntity));
    }

    /**
     *  list 查询
     */
    @Test
    public void testSqlList() {
        List<PersonEntity> supplierItemEntities = personRepository.findByPersonNoIn(Lists.newArrayList("US2022060100001","US2022060100002"));
        System.out.println(JsonParser.asJson(supplierItemEntities));
    }

    /**
     * 时间查询
     */
    @Test
    public void testSqlTime() {
        List<PersonEntity> supplierItemEntity = personRepository.findByCreateTime(LocalDateTime.now().minusDays(300));
        System.out.println(JsonParser.asJson(supplierItemEntity));
    }

    /**
     * count查询
     */
    @Test
    public void testSqlCount() {
        Long count = personRepository.countByStatus(2);
        System.out.println(JsonParser.asJson(count));
    }

    /**
     * like查询
     */
    @Test
    public void testSqlLike() {
        List<PersonEntity> res = personRepository.findByPersonLike("狗","蚁");
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 分组查询
     */
    @Test
    public void testSqlGroup() {
        List<PersonEntity> res = personRepository.groupBy("李狗蛋");
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 聚合查询(sum)
     */
    @Test
    public void testSqlSum() {
        double res = personRepository.sumQuery("腾讯");
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 分组聚合查询
     */
    @Test
    public void testSqlSumGroup() {
        List<PersonGroupResult> results = personRepository.sumGroup(Lists.newArrayList("蚂蚁", "米哈游", "美团", "字节跳动"), 4);
        System.out.println(JsonParser.asJson(results));
    }

    /**
     * Having分组聚合查询
     */
    @Test
    public void testSqlHaving() {
        List<PersonGroupResult> results = personRepository.havingQuery(Lists.newArrayList("蚂蚁", "米哈游", "美团", "字节跳动"), 4);
        System.out.println(JsonParser.asJson(results));
    }


    //☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺ 关联查询测试 ☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺//

    //☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺ 回表查询测试 ☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺//


}