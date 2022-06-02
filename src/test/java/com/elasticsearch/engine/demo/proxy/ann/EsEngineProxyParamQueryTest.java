package com.elasticsearch.engine.demo.proxy.ann;

//import com.elasticsearch.engine.demo.elasticsearchenginedemo.ElasticsearchEngineDemoApplicationTests;

import com.elasticsearch.engine.common.utils.JsonParser;
import com.elasticsearch.engine.demo.execute.resultmodel.SupplierItemEntity;
import com.elasticsearch.engine.demo.proxy.repository.SupplierItemParamRepository;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
* @Description :  
* @Author : wanghuan
* @Date: -- : 
*/

@Slf4j
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ElasticsearchEngineDemoApplicationTests.class)
public class EsEngineProxyParamQueryTest {


    @Resource
    private SupplierItemParamRepository supplierItemParamRepository;

    /**
     * 查询单个测试
     */
    @Test
    public void queryOneResponse() {
        SupplierItemEntity supplierItemEntity = supplierItemParamRepository.queryOne("20201226204656658857", 1);
        log.info("res:{}", JsonParser.asJson(supplierItemEntity));
    }


    /**
     * 查询单个测试
     */
    @Test
    public void queryOneResponse2() {
        List<SupplierItemEntity> supplierItemEntities = supplierItemParamRepository.queryList(LocalDateTime.now());
        log.info("res:{}", JsonParser.asJson(supplierItemEntities));
    }


    /**
     * List查询测试
     */
    @Test
    public void queryListResponse() {
        List<String> itemNoList = Lists.newArrayList("20201226204656658857");
        List<SupplierItemEntity> res = supplierItemParamRepository.queryList(itemNoList);
        log.info("res:{}", JsonParser.asJson(res));
    }
}
