package com.elasticsearch.engine.demo.domain.repository;

import com.elasticsearch.engine.demo.domain.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-05-31 23:18
 */
public interface PersonExtendRepository extends JpaRepository<PersonEntity, Long>{
}
