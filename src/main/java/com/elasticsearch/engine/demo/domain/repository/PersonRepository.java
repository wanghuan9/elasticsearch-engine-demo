package com.elasticsearch.engine.demo.domain.repository;

import com.elasticsearch.engine.demo.domain.entity.PersonEntity;
import com.elasticsearch.engine.model.annotion.EsQuery;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-05-25 21:58
 */
@EsQueryIndex("person_es_index")
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @EsQuery
    PersonEntity getByPersonNo(String personNo);
    
}
