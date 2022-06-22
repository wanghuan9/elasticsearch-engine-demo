package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.base.holder.AbstractEsRequestHolder;
import com.elasticsearch.engine.base.hook.RequestHook;
import com.elasticsearch.engine.base.mapping.annotation.Term;
import com.elasticsearch.engine.base.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.base.model.annotion.Ignore;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermsQueryBuilder;

import java.util.List;

/**
 * @author wanghuan
 * @description 自定义扩展查询
 * <p>
 * 当注解查询无法满足时, 可以通过自定义查询对注解查询进行扩展
 * <p>
 * 注解查询和自定义查询条件将合并
 * @mail 958721894@qq.com
 * @date 2022/6/2 10:21
 */
@Slf4j
@EsQueryIndex("person_es_index")
@Data
public class PersonReqExtend implements RequestHook<PersonReqExtendInherit> {

    @Term
    private Integer status;

    @Ignore
    private List<String> personNoList;

    /**
     * user define the operation of request
     * you can extend-define Es-request or
     * define aggregation
     *
     * @param holder
     * @param person
     */
    @Override
    public AbstractEsRequestHolder handleRequest(AbstractEsRequestHolder holder, PersonReqExtendInherit person) {
        TermsQueryBuilder queryBuilder = QueryBuilders.termsQuery("person_no", person.getPersonNoList());
        holder.addQueryBuilder(queryBuilder);
        return holder;
    }
}

