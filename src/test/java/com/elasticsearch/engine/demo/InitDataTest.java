package com.elasticsearch.engine.demo;

import com.elasticsearch.engine.base.common.proxy.EsQueryProxy;
import com.elasticsearch.engine.base.common.queryhandler.EsProxyExecuteHandler;
import com.elasticsearch.engine.demo.domain.es.repository.PersonEsModelRepository;
import com.elasticsearch.engine.demo.dto.query.PersonBaseQuery;
import com.elasticsearch.engine.demo.service.PersonTestDataInitService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;
import java.util.List;


/**
 * @author wanghuan
 * @description 测试数据初始化
 * @mail 958721894@qq.com
 * @date 2022/6/2 10:23
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class InitDataTest {

    @Resource
    private PersonTestDataInitService personTestDataInitService;

    @Test
    public void initData() {
        personTestDataInitService.insertList(30);
    }

    public static void main(String[] args) {
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.out.println("$Proxy0.class全名: " + Proxy.getProxyClass(PersonEsModelRepository.class.getClassLoader(), PersonEsModelRepository.class).toString());

        PersonEsModelRepository repository = (PersonEsModelRepository) Proxy.newProxyInstance(
                PersonEsModelRepository.class.getClassLoader(),
                new Class[]{PersonEsModelRepository.class},
                new EsQueryProxy<PersonEsModelRepository>(PersonEsModelRepository.class, true, new EsProxyExecuteHandler(), true));

        PersonBaseQuery person = new PersonBaseQuery();
        List<String> itemNoList = Lists.newArrayList("US2022060100001");
        person.setPersonNoList(itemNoList);
        repository.queryOne(person);
    }

}
