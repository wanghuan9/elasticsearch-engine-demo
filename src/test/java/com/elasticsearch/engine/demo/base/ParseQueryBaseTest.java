package com.elasticsearch.engine.demo.base;

import com.elasticsearch.engine.base.common.queryhandler.ann.model.EsExecuteHandler;
import com.elasticsearch.engine.base.mapping.model.extend.PageParam;
import com.elasticsearch.engine.base.mapping.model.extend.RangeParam;
import com.elasticsearch.engine.base.mapping.model.extend.SignParam;
import com.elasticsearch.engine.base.model.annotion.Sign;
import com.elasticsearch.engine.demo.dto.query.*;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
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
 * @description 解析查询注解基础测试
 * <p>
 * 通过看控制台 输出的查询语句判断解析是否正确
 * @mail 958721894@qq.com
 * @date 2022-05-31 23:34
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ParseQueryBaseTest {

    @Resource
    private EsExecuteHandler esExecuteHandler;

    /**
     * 测试 Trem Trems Range
     */
    @Test
    public void findByProductNameAndStatusTest() {
        PersonBaseQuery person = new PersonBaseQuery();
        person.setRangeStatus(RangeParam.builder().left(1).right(2).build());
        List<String> itemNoList = Lists.newArrayList();
        itemNoList.add("US2022060100001");
        person.setPersonNos(itemNoList);
        person.setSalary(new BigDecimal("22.01"));
        person.setCreateTime(RangeParam.builder().left(LocalDateTime.now()).right(LocalDateTime.now().plusDays(1L)).build());
        esExecuteHandler.execute(person);
    }


    /**
     * 测试from to 及后缀
     */
    @Test
    public void fromToTest() {
        PersonBaseQuery person = new PersonBaseQuery();
        person.setCreateTimeStart(LocalDateTime.now());
        person.setCreateTimeEnd(LocalDateTime.now().plusDays(360));
        esExecuteHandler.execute(person);
    }

    /**
     * 测试WildCard
     */
    @Test
    public void wildCardTest() {
        PersonBaseQuery person = new PersonBaseQuery();
        person.setPersonName("蛋");
        esExecuteHandler.execute(person);
    }


    /**
     * 测试prefix
     */
    @Test
    public void prefixTest() {
        PersonBaseQuery person = new PersonBaseQuery();
        person.setPersonName("李");
        esExecuteHandler.execute(person);
    }

    /**
     * 测试 exist
     */
    @Test
    public void existTest() {
        PersonExist supplierItemExist = new PersonExist();
        supplierItemExist.setStatus(Sign.DEFAULT_STRING);
        supplierItemExist.setPersonName(Sign.DEFAULT_STRING);
        esExecuteHandler.execute(supplierItemExist);
    }


    /**
     * 测试should
     */
    @Test
    public void shouldTest() {
        PersonShould person = new PersonShould();
        person.setPersonName("李狗蛋");
        person.setPersonNo("US2022060100001");
        person.setPhone(18800000003L);
        esExecuteHandler.execute(person);
    }

    /**
     * 单个排序测试
     */
    @Test
    public void orderTest() {
        PersonBaseQuery person = new PersonBaseQuery();
        person.setPersonName("李狗蛋");
        person.setStatus(SignParam.builder());
        esExecuteHandler.execute(person);
    }

    /**
     * 多个排序并指定顺序测试
     */
    @Test
    public void sortOrderTest() {
        PersonMoreSort person = new PersonMoreSort();
        person.setCompany(SignParam.builder());
        person.setSalary(SignParam.builder());
        esExecuteHandler.execute(person);
    }

    /**
     * 测试多range
     */
    @Test
    public void rangeGroupTest() {
        PersonRangeGroup rangeGroup = new PersonRangeGroup();
        rangeGroup.setStartCreateTime(LocalDateTime.now());
        rangeGroup.setEndCreateTime(LocalDateTime.now().plusDays(200L));
        rangeGroup.setStartStatus(1);
        rangeGroup.setEndStatus(3);
        esExecuteHandler.execute(rangeGroup);
    }

    /**
     * 测试分页
     */
    @Test
    public void pageTest() {
        PersonBaseQuery person = new PersonBaseQuery();
        person.setPageParam(PageParam.builderPage().currentPage(2).pageSize(3).build());
        esExecuteHandler.execute(person);
    }

    /**
     * 测试分页+排序
     */
    @Test
    public void pageAndOrderTest() {
        PersonBaseQuery person = new PersonBaseQuery();
        person.setPageParam(PageParam.builderPage().currentPage(2).pageSize(3)
                .order(PageParam.builderOrder().orderFiled("status").orderType(SortOrder.ASC))
                .order(PageParam.builderOrder().orderFiled("create_dt").orderType(SortOrder.ASC))
                .build());
        esExecuteHandler.execute(person);
    }

    /**
     * 测试分组 aggs
     */
    @Test
    public void aggTest() {
        PersonBaseQuery person = new PersonBaseQuery();
        person.setGroupStatus(SignParam.builder());
        esExecuteHandler.execute(person);
    }

    /**
     * 测试查询参数后缀
     */
    @Test
    public void collapseTest() {
        PersonBaseQuery person = new PersonBaseQuery();
        List<String> itemNoList = Lists.newArrayList();
        itemNoList.add("US2022060100001");
        person.setPersonNoList(itemNoList);
        esExecuteHandler.execute(person);
    }

    /**
     * 测试ignore
     */
    @Test
    public void ignoreTest() {
        PersonBaseQuery person = new PersonBaseQuery();
        person.setPersonName("李狗蛋");
        person.setToken("token");
        esExecuteHandler.execute(person);
    }
    
    //查询参数支持继承
    //查询参数支持嵌套

    /**
     * 测试 自定义扩展查询
     */
    @Test
    public void extendTest() {
        PersonReqExtend person = new PersonReqExtend();
        List<String> itemNoList = Lists.newArrayList("6547831", "6547832");
        person.setStatus(1);
        person.setPersonNoList(itemNoList);
        esExecuteHandler.execute(person);
    }

    /**
     * 测试 自定义扩展查询 参数继承
     */
    @Test
    public void nestedExtendTest() {
        PersonReqExtendInherit personReqExtendInherit = new PersonReqExtendInherit();
        List<String> list = Lists.newArrayList("US2022060100001", "US2022060100002");
        personReqExtendInherit.setStatus(4);
        personReqExtendInherit.setPersonNoList(list);
        personReqExtendInherit.setPersonName("郭德纲");
        esExecuteHandler.execute(personReqExtendInherit, Object.class);
    }

    /**
     * 测试 自定义扩展查询 参数嵌套
     */
    @Test
    public void extendExtendTest() {
        PersonReqExtendNested supplierItemNestedExtend = new PersonReqExtendNested();
        PersonReqExtend personReqExtend = new PersonReqExtend();
        List<String> list = Lists.newArrayList("US2022060100001", "US2022060100002");
        personReqExtend.setStatus(1);
        personReqExtend.setPersonNoList(list);
        supplierItemNestedExtend.setPersonReqExtend(personReqExtend);
        supplierItemNestedExtend.setPersonName("123");
        esExecuteHandler.execute(supplierItemNestedExtend, Object.class);
    }

   
}
