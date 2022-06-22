package com.elasticsearch.engine.demo.error;

import com.elasticsearch.engine.demo.domain.es.errorrepository.EsEngineSqlErrorRepository;
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
 * sql查询异常场景测试
 * @mail 958721894@qq.com
 * @date 2022-06-22 15:13
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsEngineSqlErrorQueryTest {

    @Resource
    private EsEngineSqlErrorRepository esEngineSqlErrorRepository;

    /**
     * 不支持的sql
     * <p>
     * SQL查询异常:  {"error":{"type":"verification_exception","reason":"Found 1 problem\nline 1:8: SELECT DISTINCT is not yet supported"},"status":400}
     */
    @Test
    public void testQueryDistinctError() {
        esEngineSqlErrorRepository.queryDistinct();
    }

    /**
     * sql错误
     */
    @Test
    public void testQuerySqlError() {
        esEngineSqlErrorRepository.querySqlError("US2022060100001",1);
    }


    /**
     * sql错误 Unknown column
     */
    @Test
    public void testQueryUnknownColumnError() {
        esEngineSqlErrorRepository.queryUnknownColumnError("US2022060100001",1);
    }

    /**
     * 参数错误
     * 方法中的参数和sql中的参数 不匹配
     */
    @Test
    public void testQueryParamError() {
        esEngineSqlErrorRepository.queryParamError("US2022060100001");
    }
}
