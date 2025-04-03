package com.elasticsearch.engine.demo.dto.query;

import com.elasticsearch.engine.base.holder.AbstractEsRequestHolder;
import com.elasticsearch.engine.base.mapping.annotation.From;
import com.elasticsearch.engine.base.mapping.annotation.Sort;
import com.elasticsearch.engine.base.mapping.annotation.Term;
import com.elasticsearch.engine.base.mapping.annotation.Terms;
import com.elasticsearch.engine.base.mapping.annotation.To;
import com.elasticsearch.engine.base.model.annotion.Base;
import com.elasticsearch.engine.base.model.annotion.Ignore;
import com.elasticsearch.engine.base.model.emenu.EsConnector;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-04-18 14:42
 */
@Data
public class ProductQueryByEsBaseReq {

    @Sort
    private Integer id;

    @Term
    private String orderNo;

    @Terms(@Base("orderNo"))
    private List<String> orderNos;

    @Ignore
    private String productNo;

    @Terms(@Base("productNo"))
    private List<String> productNos;

    @Ignore
    private String goodNo;

    @Terms(@Base("goodNo"))
    private List<String> goodNos;

    private String outProductNo;

    @Term
    private String imei;

    @Term
    private Integer merchantId;

    @Term
    private Integer status;


    @Terms(@Base("status"))
    private List<Integer> statusList;

    @Term
    private Integer subStatus;

    @Terms(@Base("subStatus"))
    private List<Integer> subStatusList;

    @Term
    private Integer productType;

    @Terms(@Base("productType"))
    private List<Integer> productTypes;

    @Term
    private Integer channel;

    @Term
    private Integer saleChannel;

    @From(@Base("createDt"))
    private LocalDateTime beginTime;

    @To(@Base("createDt"))
    private LocalDateTime endTime;

    @Terms(@Base("tag"))
    private List<Integer> tags;

    public AbstractEsRequestHolder handleRequest(AbstractEsRequestHolder holder, ProductQueryByEsBaseReq req) {
        if (StringUtils.isNotEmpty(req.getGoodNo())) {
            holder.addQueryBuilder(EsConnector.FILTER, QueryBuilders.termQuery("goodNo", req.getGoodNo()));
        } else if (StringUtils.isNotEmpty(req.getOutProductNo())) {
            holder.addQueryBuilder(EsConnector.FILTER, QueryBuilders.termQuery("outProductNo", req.getOutProductNo()));
        } else if (StringUtils.isNotEmpty(req.getProductNo())) {
            holder.addQueryBuilder(EsConnector.FILTER, QueryBuilders.termQuery("productNo", req.getProductNo()));
        }

        return holder;
    }


}

