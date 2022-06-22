package com.elasticsearch.engine.demo.error;


import com.elasticsearch.engine.demo.domain.es.error.PersonEsNoExtendBaseESRepository;
import com.elasticsearch.engine.demo.dto.query.PersonBaseQuery;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author wanghuan
 * @description 异常测试示例
 * <p>
 * 注解查询未继承 BaseESRepository
 * @mail 958721894@qq.com
 * @date 2022/6/22 09:00
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsEngineProxyNoExtendQueryTest {

    @Resource
    private PersonEsNoExtendBaseESRepository personEsNoExtendBaseESRepository;

    @Test
    public void testNoExtendBaseESRepository() {
        personEsNoExtendBaseESRepository.queryOne(new PersonBaseQuery());
    }


}
