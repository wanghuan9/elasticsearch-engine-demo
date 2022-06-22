package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.base.mapping.annotation.From;
import com.elasticsearch.engine.base.mapping.annotation.To;
import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wanghuan
 * @description: 多组range 分组测试
 * @mail 958721894@qq.com
 * @date 2022-06-1 22:50
 */
@EsQueryIndex("person_es_index")
@Data
public class PersonRangeGroup {

    @From(group = 1)
    private LocalDateTime startCreateTime;

    @From
    private Integer startStatus;

    @To(group = 1)
    private LocalDateTime endCreateTime;

    @To
    private Integer endStatus;
}
