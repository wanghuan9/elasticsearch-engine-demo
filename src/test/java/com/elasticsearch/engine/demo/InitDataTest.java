package com.elasticsearch.engine.demo;

import com.elasticsearch.engine.demo.service.PersonTestDataInitService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


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
}
