package com.elasticsearch.engine.demo.error;

//import com.elasticsearch.engine.demo.elasticsearchenginedemo.ElasticsearchEngineDemoApplicationTests;

import com.elasticsearch.engine.demo.error.repository.SupplierItemErrorRepository2;
import com.elasticsearch.engine.demo.error.repository.SupplierItemParamErrorRepository;
import com.elasticsearch.engine.demo.dto.query.SupplierItem;
import com.elasticsearch.engine.demo.execute.resultmodel.SupplierItemEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 查询引擎 查询测试
 */
@Slf4j
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ElasticsearchEngineDemoApplicationTests.class)
public class EsEngineProxyErrorQueryTest {

    @Resource
    private SupplierItemErrorRepository2 supplierItemErrorRepository2;

    @Resource
    private SupplierItemParamErrorRepository supplierItemParamErrorRepository;


    /**
     * 测试为添加 @EsQueryIndex
     */
    @Test
    public void testUndefineEsQueryIndexError() {
        supplierItemErrorRepository2.queryOne("", 1);
    }

    /**
     * 测试接口定义 入参异常
     */
    @Test
    public void testRequestParamError() {
        supplierItemParamErrorRepository.queryOne(new SupplierItem(), new SupplierItemEntity());
    }


    /**
     * 测试接口定义 出参异常
     */
    @Test
    public void testResponseParamError() {
        supplierItemParamErrorRepository.queryOne(new SupplierItem());
    }

}
