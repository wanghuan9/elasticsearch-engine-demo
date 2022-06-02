package com.elasticsearch.engine.demo.domain.mysql.repository;

import com.elasticsearch.engine.demo.domain.mysql.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-05-31 23:18
 */
public interface PersonExtendRepository extends JpaRepository<PersonEntity, Long>{
}
