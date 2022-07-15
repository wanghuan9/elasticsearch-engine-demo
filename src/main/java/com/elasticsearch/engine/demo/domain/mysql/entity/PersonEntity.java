package com.elasticsearch.engine.demo.domain.mysql.entity;

import com.elasticsearch.engine.base.model.annotion.ESColumn;
import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @description: PersonEntity
 * @author wanghuan
 * @mail 958721894@qq.com    
 * @date  2022-05-31 22:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity // jpa的注解，需要加
@EsQueryIndex("")
@Table(name = "person")
public class PersonEntity {
    @Id
    private Long id;
    private String personNo;
    private String personName;
    private Long phone;
    private BigDecimal salary;
    private String company;
    private Integer status;
    private Integer sex;
    private String address;
    private LocalDateTime createTime;
    @ESColumn(table = "person", sqlColumn = "create_user", esColumn = "createUser")
    private String createUser;
}
