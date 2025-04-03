package com.elasticsearch.engine.demo.dto.query;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductQueryListBaseReq {

    private String orderNo;

    private List<String> orderNos;

    private String productNo;

    private List<String> productNos;

    private String goodNo;

    private List<String> goodNos;

    private String outProductNo;

    private String imei;

    private Integer merchantId;

    private Integer status;

    private List<Integer> statusList;

    private Integer subStatus;

    private List<Integer> subStatusList;

    private Integer productType;

    private List<Integer> productTypes;

    private Integer channel;

    private Integer saleChannel;

    private List<Integer> tags;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;

    private Boolean needConfirm;


}
