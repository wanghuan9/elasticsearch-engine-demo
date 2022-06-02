package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.mapping.annotation.Term;
import com.elasticsearch.engine.model.annotion.Base;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.model.emenu.EsConnector;
import lombok.Data;


/**
* @author wanghuan
* @description should查询测试
* @mail 958721894@qq.com       
* @date 2022/6/2 10:22 
*/
@EsQueryIndex("person_es_index")
@Data
public class PersonShould {

    @Term(value = @Base(connect = EsConnector.SHOULD))
    private String personNo;

    @Term(value = @Base(connect = EsConnector.SHOULD))
    private Long phone;

    @Term(value = @Base(connect = EsConnector.SHOULD))
    private String personName;

}

