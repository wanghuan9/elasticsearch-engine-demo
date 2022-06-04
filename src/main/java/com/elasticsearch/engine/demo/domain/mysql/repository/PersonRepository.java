package com.elasticsearch.engine.demo.domain.mysql.repository;

import com.elasticsearch.engine.demo.domain.mysql.entity.PersonEntity;
import com.elasticsearch.engine.demo.dto.result.PersonGroupResult;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.model.annotion.JpaEsQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-05-25 21:58
 */
@EsQueryIndex("person_es_index")
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @JpaEsQuery
    PersonEntity getByPersonNoAndStatus(String personNo, Integer status);

    @JpaEsQuery
    List<PersonEntity> findByPersonNoIn(List<String> personNo);

    @JpaEsQuery
    List<PersonEntity> findByCreateTime(LocalDateTime createTime);

    @JpaEsQuery
    Long countByStatus(Integer status);

    @JpaEsQuery
    @Query(value = "SELECT * FROM person t WHERE t.person_name LIKE CONCAT('%',:personName,'%') OR t.company LIKE CONCAT('%',:company,'%') ", nativeQuery = true)
    List<PersonEntity> findByPersonLike(String personName, String company);

//    @JpaEsQuery
    @Query(value = "SELECT * FROM person WHERE person_name LIKE CONCAT('%',:personName,'%') GROUP BY status", nativeQuery = true)
    List<PersonEntity> groupBy(String personName);

    @JpaEsQuery
    @Query(value = "SELECT SUM(salary) AS sumSalary FROM person WHERE company = ?1", nativeQuery = true)
    double sum(String company);

    @JpaEsQuery
    @Query(value = "SELECT company,SUM(salary) AS sumSalary FROM person WHERE company IN (?1)  GROUP BY company", nativeQuery = true)
    List<PersonGroupResult> sumGroup(List<String> company, Integer status);

    @JpaEsQuery
    @Query(value = "SELECT company,SUM(salary) AS sumSalary FROM person WHERE company IN (?1)  GROUP BY company HAVING sumSalary>450000", nativeQuery = true)
    List<PersonGroupResult> having(List<String> company, Integer status);

}
