package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.mapping.annotation.Sort;
import com.elasticsearch.engine.mapping.model.extend.SignParam;
import com.elasticsearch.engine.model.annotion.Base;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import lombok.Data;
import org.elasticsearch.search.sort.SortOrder;

/**
 * @author wanghuan
 * @description: 先按company 排序 再按 salary排序
 * @mail 958721894@qq.com
 * @date 2022-05-31 22:50
 */
@EsQueryIndex("person_es_index")
@Data
public class PersonMoreSort {

    @Sort(value = @Base(order = 4), type = SortOrder.DESC)
    private SignParam company;

    @Sort(value = @Base(order = 5), type = SortOrder.DESC)
    private SignParam salary;

}

