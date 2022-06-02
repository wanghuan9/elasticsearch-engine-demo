package com.elasticsearch.engine.demo.domain.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @description: PersonExtendEntity
 * @author wanghuan
 * @mail 958721894@qq.com    
 * @date  2022-05-31 22:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity // jpa的注解，需要加
@Table(name = "person_extend")
public class PersonExtendEntity {
    @Id
    private Long id;
    private String personNo;
    private String mail;
    private String hobby;
    private LocalDateTime createTime;
}
