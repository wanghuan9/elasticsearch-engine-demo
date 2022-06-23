package com.elasticsearch.engine.demo.base;

import com.elasticsearch.engine.base.common.queryhandler.ann.model.EsExecuteHandler;
import com.elasticsearch.engine.base.common.utils.JsonParser;
import com.elasticsearch.engine.base.mapping.model.extend.RangeParam;
import com.elasticsearch.engine.base.model.annotion.Sign;
import com.elasticsearch.engine.base.model.domain.BaseResp;
import com.elasticsearch.engine.base.model.domain.DefaultAggResp;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.dto.query.PersonBaseQuery;
import com.elasticsearch.engine.demo.dto.query.PersonResExtend;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wanghuan
 * @description 构建基础响应测试模块
 * <p>
 * 当查询结果比较复杂 不是简单的将hits转为json对象时, 可以通过自定义响应对结果进行扩展
 * <p>
 * 例如 复杂的分组嵌套查询, 或者响应结果未map之类的
 * @mail 958721894@qq.com
 * @date 2022/6/2 10:59
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ParseResponseBaseTest {

    @Resource
    private EsExecuteHandler esExecuteHandler;

    /**
     * 测试普通查询响应
     */
    @Test
    public void findByProductNameAndStatusTest() {
        PersonBaseQuery person = new PersonBaseQuery();
        person.setRangeStatus(RangeParam.builder().left(0).right(1).build());
        BaseResp<PersonEsEntity> baseHitBaseResp = esExecuteHandler.execute(person, PersonEsEntity.class);
        log.info(JsonParser.asJson(baseHitBaseResp));
    }

    /**
     * 测试自定义扩展response查询
     */
    @Test
    public void extendTest() {
        PersonResExtend personResExtend = new PersonResExtend();
        personResExtend.setStatus(Sign.DEFAULT_INTER);
        BaseResp<List<DefaultAggResp>> resp = esExecuteHandler.execute(personResExtend, List.class);
        List<DefaultAggResp> result = resp.getResult();
        log.info(JsonParser.asJson(result));
    }

}
