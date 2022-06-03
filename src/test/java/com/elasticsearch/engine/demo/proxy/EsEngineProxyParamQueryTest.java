package com.elasticsearch.engine.demo.proxy;


import com.elasticsearch.engine.common.utils.JsonParser;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.domain.es.repository.PersonEsParamRepository;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanghuan
 * @description 注解查询 param参数
 * <p>
 * 查询的PersonEsParamRepository 必须继承 BaseESRepository 否则无法扫描注册
 * <p>
 * 规则:
 * 1)查询参数为1个或多个, 参数类型都是基础类型
 * 2)响应参数的类型或者泛型 必须为Repository的泛型或者自定义响应的泛型,或者固定结果DefaultResp的子类型
 * @mail 958721894@qq.com
 * @date 2022/6/2 14:22
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsEngineProxyParamQueryTest {


    @Resource
    private PersonEsParamRepository personEsParamRepository;

    /**
     * 查询单个测试
     */
    @Test
    public void queryOneResponse() {
        PersonEsEntity supplierItemEntity = personEsParamRepository.queryOne("US2022060100001", 1);
        log.info("res:{}", JsonParser.asJson(supplierItemEntity));
    }


    /**
     * List查询测试
     */
    @Test
    public void queryListResponse() {
        List<String> personNoList = Lists.newArrayList("US2022060100001","US2022060100002");
        List<PersonEsEntity> res = personEsParamRepository.queryList(personNoList);
        log.info("res:{}", JsonParser.asJson(res));
    }

    /**
     * 时间查询
     */
    @Test
    public void queryOneResponse2() {
        List<PersonEsEntity> supplierItemEntities = personEsParamRepository.queryBycreateTime(LocalDateTime.now().minusDays(300),LocalDateTime.now());
        log.info("res:{}", JsonParser.asJson(supplierItemEntities));
    }
}
