package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.base.mapping.annotation.*;
import com.elasticsearch.engine.base.mapping.model.extend.PageParam;
import com.elasticsearch.engine.base.mapping.model.extend.RangeParam;
import com.elasticsearch.engine.base.mapping.model.extend.SignParam;
import com.elasticsearch.engine.base.model.annotion.Base;
import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.base.model.annotion.Ignore;
import com.elasticsearch.engine.base.model.emenu.EsConnector;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanghuan
 * @description: 解析查询注解基础测试
 * @mail 958721894@qq.com
 * @date 2022-05-31 22:40
 */
@EsQueryIndex(value = "person_es_index")
@Data
public class PersonBaseQuery {

    @Terms(value = @Base("item_no"))
    private List<String> personNos;

    @Terms
    private List<String> personNoList;

    @Term
    private BigDecimal salary;

    @Range(value = @Base(value = "status", connect = EsConnector.SHOULD), tag = Range.LE_GE)
    private RangeParam rangeStatus;

    @Range
    private RangeParam createTime;

    @WildCard
    private String address;

    @Prefix
    private String personName;

    @To(@Base("create_time"))
    private LocalDateTime createTimeEnd;

    @From(value = @Base("create_time"))
    private LocalDateTime createTimeStart;

    @PageAndOrder
    private PageParam pageParam;

    /**
     * 标记注解不解析value,只解析注解值
     * 需要设置 value值不为空,查询条件才会生效, 但是设置的value不会被解析,仅仅标记是否添加该条件
     * 所以value可以任意设置, 但是注意 string 不能为空串,数组类型不能为null
     * 
     * SignParam 表示一种无需解析参数值得 类型
     * 也可以使用 Sign.DEFAULT_STRING 表示
     */
    @Sort
    private SignParam status;
    
    @Aggs(value = @Base("status"), type = Aggs.COUNT_DESC)
    private SignParam groupStatus;

    /**
     * 表示忽略某个字段 ,被忽略的字段 无论属性值是否为空, 查询时都不会被解析
     */
    @Ignore
    private String token;

}
