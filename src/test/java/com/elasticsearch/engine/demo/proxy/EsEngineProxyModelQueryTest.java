package com.elasticsearch.engine.demo.proxy;

import com.elasticsearch.engine.base.common.utils.JsonParser;
import com.elasticsearch.engine.base.mapping.model.extend.PageParam;
import com.elasticsearch.engine.base.mapping.model.extend.PageParam.OrderBuilder;
import com.elasticsearch.engine.base.mapping.model.extend.SignParam;
import com.elasticsearch.engine.base.model.annotion.Sign;
import com.elasticsearch.engine.base.model.domain.BaseResp;
import com.elasticsearch.engine.base.model.domain.DefaultAggResp;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.domain.es.repository.PersonEsModelRepository;
import com.elasticsearch.engine.demo.dto.query.PersonBaseQuery;
import com.elasticsearch.engine.demo.dto.query.PersonResExtend;
import com.elasticsearch.engine.demo.dto.query.PersonSearchResponseRes;
import com.elasticsearch.engine.demo.dto.query.ProductQueryByEs4AppReq;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.sort.SortOrder;
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
 * @description 注解查询 model参数
 * <p>
 * 查询的PersonEsParamRepository 必须继承 BaseESRepository 否则无法扫描注册
 * <p>
 * 规则:
 * 1)查询参数必须为1个, 并且不是基础类型
 * 2)响应参数的类型或者泛型 必须为Repository的泛型或者自定义响应的泛型,或者固定结果DefaultResp的子类型
 * @mail 958721894@qq.com
 * @date 2022/6/2 13:19
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsEngineProxyModelQueryTest {

    @Resource
    private PersonEsModelRepository personEsModelRepository;

    /**
     * 查询单个测试
     */
    @Test
    public void queryOneResponse() {
        PersonBaseQuery person = new PersonBaseQuery();
        List<String> itemNoList = Lists.newArrayList("US2022060100001");
        person.setPersonNoList(itemNoList);
        PersonEsEntity personEsEntity = personEsModelRepository.queryOne(person);
        log.info("res:{}", JsonParser.asJson(personEsEntity));
    }

    /**
     * List查询测试
     */
    @Test
    public void queryListResponse() {
        PersonBaseQuery person = new PersonBaseQuery();
        List<String> itemNoList = Lists.newArrayList("US2022060100001","US2022060100002");
        person.setPersonNoList(itemNoList);
        List<PersonEsEntity> personEsEntityList = personEsModelRepository.queryList(person);
        log.info("res:{}", JsonParser.asJson(personEsEntityList));
    }


    /**
     * List查询(可以用于分页查询结果构建)
     * BaseResp 用于拿到list及count
     */
    @Test
    public void queryListResponseBaseResp() {
        PersonBaseQuery person = new PersonBaseQuery();
        List<String> itemNoList = Lists.newArrayList("US2022060100001","US2022060100002");
        person.setPersonNoList(itemNoList);
        BaseResp<PersonEsEntity> resp = personEsModelRepository.queryListBaseResp(person);
        log.info("res:{}", JsonParser.asJson(resp));
    }

    /**
     * 分页查询测试
     */
    @Test
    public void queryPageResponseBaseResp() {
        PersonBaseQuery person = new PersonBaseQuery();
        //设置分页参数
        PageParam pageQuery = PageParam.builderPage().currentPage(2).pageSize(20)
            .order(new OrderBuilder().orderFiled("create_time").orderType(
                SortOrder.DESC)).build();
        person.setPageParam(pageQuery);
        List<String> itemNoList = Lists.newArrayList("US2022060100001", "US2022060100002");
        person.setPersonNoList(itemNoList);
        BaseResp<PersonEsEntity> resp = personEsModelRepository.queryListBaseResp(person);
        log.info("res:{}", JsonParser.asJson(resp));
    }

    /**
     * model查询测试
     */
    @Test
    public void queryByModelTest(){
        PersonBaseQuery person = new PersonBaseQuery();
        person.setPageParam(PageParam.builderPage().currentPage(1).pageSize(100).build());
        person.setSalary(new BigDecimal("67700"));
        person.setPersonName("张");
        person.setAddress("天府");
        person.setCreateTimeStart(LocalDateTime.now().minusDays(300));
        person.setCreateTimeEnd(LocalDateTime.now());
        List<PersonEsEntity> res = personEsModelRepository.queryByMode(person);
        log.info("res:{}", JsonParser.asJson(res));
    }

    /**
     * 固定结果值查询
     *
     * @return
     */
    @Test
    public void queryAggDefaultResp(){
        PersonBaseQuery person = new PersonBaseQuery();
        person.setGroupStatus(SignParam.builder());
        BaseResp<DefaultAggResp> resp = personEsModelRepository.queryAggDefaultResp(person);
        log.info("res:{}", JsonParser.asJson(resp));
    }


    /**
     * 自定义结果查询(分组查询)
     */
    @Test
    public void querySupplierItemResExtend() {
        PersonResExtend personResExtend = new PersonResExtend();
        List<String> itemNoList = Lists.newArrayList("US2022060100001");
        personResExtend.setItemNoList(itemNoList);
        personResExtend.setStatus(Sign.DEFAULT_INTER);
        List<DefaultAggResp> aggEntityExtends = personEsModelRepository.queryAgg(personResExtend);
        log.info("res:{}", JsonParser.asJson(aggEntityExtends));
    }

    /**
     * 自定义结果查询(拿到原生的SearchResponse)
     */
    @Test
    public void querySearchResponse() {
        PersonSearchResponseRes supplierItemResExtend = new PersonSearchResponseRes();
        List<String> itemNoList = Lists.newArrayList("US2022060100001");
        supplierItemResExtend.setPersonNoList(itemNoList);
        SearchResponse searchResponse = personEsModelRepository.querySearchResponse(supplierItemResExtend);
        log.info("res:{}", JsonParser.asJson(searchResponse));
    }

    /**
     * method查询注解测试
     */
    @Test
    public void queryByDto() {
        PersonBaseQuery person = new PersonBaseQuery();
        List<String> itemNoList = Lists.newArrayList("US2022060100001");
        person.setPersonNoList(itemNoList);
        PersonEsEntity personEsEntity = personEsModelRepository.queryByDto(person);
        log.info("res:{}", JsonParser.asJson(personEsEntity));
    }

    /**
     * 复杂查询解析耗时测试
     */
    @Test
    public void testPage() {
        ProductQueryByEs4AppReq req = new ProductQueryByEs4AppReq();
        req.setMerchantId(1231);
        req.setProductType(1);
        req.setStatus(10);
        PageParam pageQuery = PageParam.builderPage().currentPage(1).pageSize(20)
            .order(new OrderBuilder().orderFiled("create_time").orderType(
                SortOrder.DESC)).build();
        req.setPageParam(pageQuery);
        PersonEsEntity personEsEntity = personEsModelRepository.page(req);
        log.info("res:{}", JsonParser.asJson(personEsEntity));
    }


}
