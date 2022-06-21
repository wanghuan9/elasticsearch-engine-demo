package com.elasticsearch.engine.demo.proxy;


import com.elasticsearch.engine.base.common.queryhandler.sql.EsSqlExecuteHandler;
import com.elasticsearch.engine.base.common.utils.JsonParser;
import com.elasticsearch.engine.base.model.emenu.SqlFormat;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.domain.es.repository.PersonEsSqlRepository;
import com.elasticsearch.engine.demo.domain.mysql.entity.PersonEntity;
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
 * @description sql查询测试示例
 * <p>
 * 查询的PersonEsParamRepository 必须继承 BaseESRepository 否则无法扫描注册
 * <p>
 * @mail 958721894@qq.com
 * @date 2022/6/2 2022/6/2 14:24
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsEngineProxySqlQueryTest {

    @Resource
    private EsSqlExecuteHandler esSqlExecuteHandler;

    @Resource
    private PersonEsSqlRepository personEsSqlRepository;

    /**
     * 单个查询
     */
    @Test
    public void testSqlOne() {
        PersonEsEntity personEsEntity = personEsSqlRepository.queryOne("US2022060100001", 1);
        log.info("res:{}", JsonParser.asJson(personEsEntity));
    }

    /**
     *  list 查询
     */
    @Test
    public void testSqlList() {
        List<PersonEsEntity> supplierItemEntities = personEsSqlRepository.queryList(Lists.newArrayList("US2022060100001","US2022060100002"));
        System.out.println(JsonParser.asJson(supplierItemEntities));
    }

    /**
     * 时间查询
     */
    @Test
    public void testSqlTime() {
        PersonEsEntity supplierItemEntity = personEsSqlRepository.queryByCreateDt(LocalDateTime.now().minusDays(300));
        System.out.println(JsonParser.asJson(supplierItemEntity));
    }

    /**
     * count查询
     */
    @Test
    public void testSqlCount() {
        Long count = personEsSqlRepository.count();
        System.out.println(JsonParser.asJson(count));
    }

    /**
     * like查询
     */
    @Test
    public void testSqlLike() {
        List<PersonEsEntity> res = personEsSqlRepository.likePersonName("狗",2);
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 分组查询
     */
    @Test
    public void testSqlGroup() {
        List<PersonEsEntity> res = personEsSqlRepository.groupBy("狗",2);
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 聚合查询(sum)
     */
    @Test
    public void testSqlSum() {
        BigDecimal res = personEsSqlRepository.sum("腾讯");
        System.out.println(JsonParser.asJson(res));
    }

    /**
     * 分组聚合查询
     */
    @Test
    public void testSqlSumGroup() {
        List<PersonGroupResult> results = personEsSqlRepository.sumGroup(Lists.newArrayList("蚂蚁", "米哈游", "美团", "字节跳动"), 4);
        System.out.println(JsonParser.asJson(results));
    }

    /**
     * 分组聚合查询
     */
    @Test
    public void testSqlHaving() {
        List<PersonGroupResult> results = personEsSqlRepository.having(Lists.newArrayList("蚂蚁", "米哈游", "美团", "字节跳动"), 4);
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
        List<PersonEntity> results = personEsSqlRepository.pageQuery(person);
        System.out.println(JsonParser.asJson(results));
    }

    /**
     * 查看默认size效果
     */
    @Test
    public void testSql() {
        //常规
        String sql1 = "select * from supplier_item_spare where item_no='20201226204656658857'";
        //like
        String sql2 = "select * from supplier_item_spare where product_name  like '%机%' ";
        //group by
        String sql3 = "select status from supplier_item_spare group by status";
        //sum
        String sql4 = "select sum(status) from supplier_item_spare";
        //count
        String sql5 = "select count(1) from supplier_item_spare";
        //having
        String sql6 = "select status,count(*) as count  from supplier_item_spare group by status having count>0";

//        Unknown column
        /**
         * 不支持的sql
         */
        String sqlError1 = "select distinct status from supplier_item_spare";
        String sqlError2 = "SELECT * FROM supplier_item_spare i inner join supplier_item_spare d WHERE iitem_no = '20201226204656658857' and status=1";

        String s1 = esSqlExecuteHandler.querySqlTranslate(sql1, SqlFormat.JSON);
        System.out.println("sql1: " +s1);
        String s2 = esSqlExecuteHandler.querySqlTranslate(sql2, SqlFormat.JSON);
        System.out.println("sql2: " +s2);
        String s3 = esSqlExecuteHandler.querySqlTranslate(sql3, SqlFormat.JSON);
        System.out.println("sql3: " +s3);
        String s4 = esSqlExecuteHandler.querySqlTranslate(sql4, SqlFormat.JSON);
        System.out.println("sql4: " +s4);
        String s5 = esSqlExecuteHandler.querySqlTranslate(sql5, SqlFormat.JSON);
        System.out.println("sql5: " +s5);


        String se1 = esSqlExecuteHandler.querySqlTranslate(sqlError1, SqlFormat.JSON);
        System.out.println("sqlError1: " +se1);
        String se2 = esSqlExecuteHandler.querySqlTranslate(sqlError2, SqlFormat.JSON);
        System.out.println("sqlError2: " +se2);

    }
}