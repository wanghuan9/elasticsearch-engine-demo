package com.elasticsearch.engine.demo.extend;


import com.elasticsearch.engine.common.utils.JsonParser;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.domain.mysql.entity.PersonEntity;
import com.elasticsearch.engine.demo.domain.mysql.mapper.PersonExtendMapper;
import com.elasticsearch.engine.demo.domain.mysql.mapper.PersonMapper;
import com.elasticsearch.engine.demo.dto.result.PersonGroupResult;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
public class EsEngineExtendMybatisQueryTest {

    @Resource
    private PersonMapper personMapper;

    @Resource
    private PersonExtendMapper personExtendMapper;

    /**
     * 单个查询
     */
    @Test
    public void testSqlOne() {
        PersonEsEntity personEsEntity = personMapper.queryOne("US2022060100001", 1);
        log.info("res:{}", JsonParser.asJson(personEsEntity));
    }

    /**
     * list 查询
     */
    @Test
    public void testSqlList() {
        List<PersonEsEntity> supplierItemEntities = personMapper.queryList(Lists.newArrayList("US2022060100001", "US2022060100002"));
        System.out.println(JsonParser.asJson(supplierItemEntities));
    }

    /**
     * 时间查询
     */
    @Test
    public void testSqlTime() {
        PersonEsEntity supplierItemEntity = personMapper.queryByCreateDt(LocalDateTime.now().minusDays(300));
        System.out.println(JsonParser.asJson(supplierItemEntity));
    }

    /**
     * count查询
     */
    @Test
    public void testSqlCount() {
        Long count = personMapper.count();
        System.out.println(JsonParser.asJson(count));
    }

    /**
     * like查询
     */
    @Test
    public void testSqlLike() {
        List<PersonEsEntity> res = personMapper.likePersonName("狗", 2);
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 分组查询
     */
    @Test
    public void testSqlGroup() {
        List<PersonEsEntity> res = personMapper.groupBy("狗", 2);
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 聚合查询(sum)
     */
    @Test
    public void testSqlSum() {
        BigDecimal res = personMapper.sum("腾讯");
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 分组聚合查询
     */
    @Test
    public void testSqlSumGroup() {
        List<PersonGroupResult> results = personMapper.sumGroup(Lists.newArrayList("蚂蚁", "米哈游", "美团", "字节跳动"), 4);
        System.out.println(JsonParser.asJson(results));
    }

    /**
     * 分组聚合查询
     */
    @Test
    public void testSqlHaving() {
        List<PersonGroupResult> results = personMapper.having(Lists.newArrayList("蚂蚁", "米哈游", "美团", "字节跳动"), 4);
        System.out.println(JsonParser.asJson(results));
    }

    /**
     * 对象参数查询 测试
     */
    @Test
    public void testSqlPageQuery() {
        PersonEntity person = new PersonEntity();
        person.setStatus(1);
//        person.setSex(1);
        List<PersonEsEntity> results = personMapper.pageQuery(person);
        System.out.println(JsonParser.asJson(results));
    }

    

    //☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺ 关联查询测试 ☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺//

    //☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺ 回表查询测试 ☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺☻,*.,*.☺//

    /**
     * 回表查询测试 personNo
     */
    @Test
    public void testSqlBackByPersonNo() {
        List<PersonEsEntity> results = personMapper.findByStatus(4);
        System.out.println(JsonParser.asJson(results));
    }

    /**
     * 回表查询测试 id
     */
    @Test
    public void testSqlBackById() {
        List<PersonEsEntity> results = personMapper.findBySex(1);
        System.out.println(JsonParser.asJson(results));
    }
}