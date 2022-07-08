package com.elasticsearch.engine.demo.domain.es.repository;

import com.elasticsearch.engine.base.model.annotion.EsQuery;
import com.elasticsearch.engine.base.model.domain.BaseEsRepository;
import com.elasticsearch.engine.demo.domain.es.entity.PersonEsEntity;
import com.elasticsearch.engine.demo.domain.mysql.entity.PersonEntity;
import com.elasticsearch.engine.demo.dto.result.PersonGroupResult;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanghuan
 * @description sql查询测试示例
 * <p>
 * 查询的PersonEsParamRepository 必须继承 BaseESRepository 否则无法扫描注册
 * <p>
 * idea sql识别设置:
 * Editor 〉 Language Injections
 * @mail 958721894@qq.com
 * @date 2022/6/2 13:30
 */
public interface PersonEsSqlRepository extends BaseEsRepository<PersonEsEntity, Long> {

    /**
     * 单个查询
     *
     * @param personNo
     * @param status
     * @return
     */
    @EsQuery("SELECT * FROM person_es_index WHERE personNo = #{personNo} AND status = #{status}")
    PersonEsEntity queryOne(String personNo, Integer status);

    /**
     * list 查询
     *
     * @param personNoList
     * @return
     */
    @EsQuery("SELECT * FROM person_es_index WHERE personNo IN (#{personNoList})")
    List<PersonEsEntity> queryList(List<String> personNoList);

    /**
     * 时间查询
     *
     * @param createDt
     * @return
     */
    @EsQuery("SELECT * FROM person_es_index WHERE createTime > #{createDt}")
    PersonEsEntity queryByCreateDt(LocalDateTime createDt);

    /**
     * count查询
     *
     * @return
     */
    @EsQuery("SELECT COUNT(1) FROM person_es_index")
    Long count();

    /**
     * like查询
     * '$' 在es查询引擎中 不存在sql注入的问题, $ 和 # 只是解析规则少有区别
     *
     * @return
     */
    /*@EsQuery("SELECT * FROM person_es_index WHERE personName  LIKE '%${personName}%' AND status = #{status}")*/
    @EsQuery("SELECT * FROM person_es_index WHERE personName  LIKE CONCAT('%',#{personName},'%') AND status = #{status}")
    List<PersonEsEntity> likePersonName(String personName, Integer status);

    /**
     * group by查询
     *
     * @return
     */
    @EsQuery("SELECT status FROM person_es_index WHERE personName  LIKE '%${personName}%' AND status = #{status} GROUP BY status")
    List<PersonEsEntity> groupBy(String personName, Integer status);

    /**
     * sum 查询
     *
     * @return
     */
    @EsQuery("SELECT SUM(salary) AS sumSalary FROM person_es_index WHERE company = #{company}")
    BigDecimal sum(String company);

    /**
     * group by sum 查询
     *
     * @return
     */
    @EsQuery("SELECT company,SUM(salary) AS sumSalary FROM person_es_index WHERE company IN (#{company})  GROUP BY company")
    List<PersonGroupResult> sumGroup(List<String> company, Integer status);

    /**
     * having
     *
     * @return
     */
    @EsQuery("SELECT company,SUM(salary) AS sumSalary FROM person_es_index WHERE company IN (#{company})  GROUP BY company HAVING sumSalary>450000")
    List<PersonGroupResult> having(List<String> company, Integer status);

    /**
     * 对象参数测试
     * @param person
     * @return
     */
    @EsQuery("SELECT * FROM person_es_index WHERE status = #{person.status}  AND sex = #{person.sex}")
    List<PersonEntity> pageQuery(PersonEntity person);
}
