package com.elasticsearch.engine.demo.error;

//import com.elasticsearch.engine.demo.elasticsearchenginedemo.ElasticsearchEngineDemoApplicationTests;

import com.elasticsearch.engine.demo.error.repository.SupplierItemErrorRepository;
import com.elasticsearch.engine.demo.dto.query.SupplierItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 查询引擎 异常场景测试  未继承BaseESRepository
 */
@Slf4j
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ElasticsearchEngineDemoApplicationTests.class)
public class EsEngineProxyNoExtendQueryTest {

    @Resource
    private SupplierItemErrorRepository supplierItemErrorRepository;

    @Test
    public void testNoExtendBaseESRepository() {
        supplierItemErrorRepository.queryOne(new SupplierItem());
    }


}
