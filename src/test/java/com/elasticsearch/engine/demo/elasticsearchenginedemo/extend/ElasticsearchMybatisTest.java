package com.elasticsearch.engine.demo.elasticsearchenginedemo.extend;

import com.elasticsearch.engine.demo.elasticsearchenginedemo.ElasticsearchEngineDemoApplicationTests;
import com.elasticsearch.engine.demo.elasticsearchenginedemo.domain.entity.ItemsEntity;
import com.elasticsearch.engine.demo.elasticsearchenginedemo.extend.jpa.entity.ItemEntity;
import com.elasticsearch.engine.demo.elasticsearchenginedemo.extend.jpa.repository.ItemRepository;
import com.elasticsearch.engine.demo.elasticsearchenginedemo.extend.mybatis.mapper.ItemsMapper;
import com.elasticsearch.engine.elasticsearchengine.common.utils.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-05-07 23:44
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticsearchEngineDemoApplicationTests.class)
public class ElasticsearchMybatisTest {

    @Resource
    private ItemsMapper itemsMapper;
    
    @Resource
    private ItemRepository itemRepository;

    @Test
    public void test() {
        ItemsEntity byItemNo = itemsMapper.getByItemNo("20201226204656658857","1");
        System.out.println(JsonParser.asJson(byItemNo));

    }

    @Test
    public void test1() {
        ItemEntity byItemNo = itemRepository.getByItemNo("20201226204656658857");
        System.out.println(JsonParser.asJson(byItemNo));

    }
}
