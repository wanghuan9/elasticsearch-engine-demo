package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.mapping.annotation.Exist;
import com.elasticsearch.engine.model.annotion.Base;
import com.elasticsearch.engine.model.annotion.EsQueryIndex;
import com.elasticsearch.engine.model.emenu.EsConnector;
import lombok.Data;

/**
 * @author wanghuan
 * @description: exist查询测试
 * @mail 958721894@qq.com
 * @date 2022-05-31 22:50
 */
@EsQueryIndex("person_es_index")
@Data
public class PersonExist {

    // productName!=null
    @Exist
    private String personName;

    //status==null
    @Exist(@Base(connect = EsConnector.MUST_NOT))
    private String status;
}

