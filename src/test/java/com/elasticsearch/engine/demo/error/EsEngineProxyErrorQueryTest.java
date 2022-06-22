package com.elasticsearch.engine.demo.error;


import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.domain.es.errorrepository.PersonEsNoEsQueryIndexErrorRepository;
import com.elasticsearch.engine.demo.domain.es.errorrepository.PersonEsParamErrorRepository;
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
 * 注解查询 入参 出差异常
 * <p>
 * No qualifying bean of type 'com.elasticsearch.engine.demo.domain.es.error.PersonEsNoExtendBaseESRepository'
 * @mail 958721894@qq.com
 * @date 2022/6/22 09:00
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsEngineProxyErrorQueryTest {

    @Resource
    private PersonEsParamErrorRepository personEsParamErrorRepository;


    @Resource
    private PersonEsNoEsQueryIndexErrorRepository personEsNoEsQueryIndexErrorRepository;


    /**
     * 测试未添加 @EsQueryIndex
     * com.elasticsearch.engine.base.model.exception.EsEngineQueryException: undefine query-index @EsQueryIndex
     */
    @Test
    public void testUndefineEsQueryIndexError() {
        personEsNoEsQueryIndexErrorRepository.queryOne("", 1);
    }

    /**
     * 测试接口定义 入参异常
     */
    @Test
    public void testRequestParamError() {
        personEsParamErrorRepository.queryOne(new PersonBaseQuery(), new PersonEsEntity());
    }


    /**
     * 测试接口定义 出参异常
     */
    @Test
    public void testResponseParamError() {
        personEsParamErrorRepository.queryOne(new PersonBaseQuery());
    }

}
