package com.elasticsearch.engine.demo.service;

import com.elasticsearch.engine.demo.common.utils.EntityUtils;
import com.elasticsearch.engine.demo.common.utils.GenerateBusinessNoUtils;
import com.elasticsearch.engine.demo.domain.entity.PersonEntity;
import com.elasticsearch.engine.demo.domain.entity.PersonExtendEntity;
import com.elasticsearch.engine.demo.domain.entity.es.PersonEsEntity;
import com.elasticsearch.engine.demo.domain.mapper.PersonExtendMapper;
import com.elasticsearch.engine.demo.domain.mapper.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author wanghuan
 * @description: ROOD
 * @date 2022-05-31 22:48
 */
@Slf4j
@Service
public class PersonTestDataInitService {
    @Resource
    private PersonMapper personMapper;
    @Resource
    private PersonExtendMapper personExtendMapper;
    @Resource
    private RestHighLevelClient restHighLevelClient;
    private Random random = new Random();
    private String[] names = {"黄某人", "负债程序猿", "谭sir", "郭德纲", "蔡徐鸡", "蔡徐母鸡", "李狗蛋", "铁蛋", "赵铁柱"};
    private String[] addrs = {"二仙桥", "成华大道", "春熙路", "锦里", "宽窄巷子", "双子塔", "天府大道", "软件园", "熊猫大道", "交子大道"};
    private String[] companys = {"京东", "腾讯", "百度", "小米", "米哈游", "网易", "字节跳动", "美团", "蚂蚁", "完美世界"};
    private String[] hobbys = {"游泳", "打羽毛球", "玩游戏", "看书", "听音乐", "踢足球", "打篮球", "蹦迪", "烫头", "抽烟"};
    private String indexName = "person_es_index";
    
    /**
     * 初始化测试数据
     *
     * @param count 数据量
     */
    public void insertList(int count) {
        ArrayList<PersonEntity> persons = new ArrayList<>(count);
        ArrayList<PersonExtendEntity> personExtends = new ArrayList<>(count);
        try {
            for (int i = 0; i < count; i++) {
                String personNo = GenerateBusinessNoUtils.generateUserNo();
                persons.add(getPerson(personNo, count));
                personExtends.add(getPersonExtend(personNo, count));
                Thread.sleep(10);
            }
            personMapper.insertList(persons);
            personExtendMapper.insertList(personExtends);
            writeDataToES(persons,personExtends,indexName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private PersonEntity getPerson(String personNo, int count) {
        PersonEntity person = PersonEntity.builder()
                .personNo(personNo)
                .personName(names[random.nextInt(names.length)])
                .phone(18800000000L + random.nextInt(count))
                .salary(new BigDecimal(random.nextInt(99999)))
                .company(companys[random.nextInt(companys.length)])
                .status(random.nextInt(5))
                .sex(random.nextInt(2))
                .address("四川省成都市" + addrs[random.nextInt(addrs.length)])
                .createUser(names[random.nextInt(names.length)]).build();
        return person;
    }

    private PersonExtendEntity getPersonExtend(String personNo, int count) {
        PersonExtendEntity personExtend = PersonExtendEntity.builder()
                .personNo(personNo)
                .mail("2022060100" + random.nextInt(count) + "@163.com")
                .hobby(hobbys[random.nextInt(companys.length)]).build();
        return personExtend;
    }

    /**
     * 批量插入多条记录到ES中
     * @param persons
     * @param personExtends
     * @param indexName
     */
    public void writeDataToES(List<PersonEntity> persons,List<PersonExtendEntity> personExtends, String indexName) {
        List<Map<String , Object>> list = new ArrayList<>();
        for(int i=0;i<persons.size();i++){
            PersonEntity personEntity = persons.get(i);
            PersonExtendEntity personExtendEntity = personExtends.get(i);
            PersonEsEntity personEsEntity = new PersonEsEntity();
            BeanUtils.copyProperties(personEntity,personEsEntity);
            BeanUtils.copyProperties(personExtendEntity,personEsEntity);
            list.add(EntityUtils.entityToMap(personEsEntity));
        }
        bulkAddEsDocument(list,indexName);
    }

    //批量插入
    public String bulkAddEsDocument(List<Map<String , Object>> data,String indexName){
        //创建批量新增文档请求
        BulkRequest bulkRequest = new BulkRequest();
        //批量为属性赋值
        for (Map<String, Object> datum : data) {
            bulkRequest.add(new IndexRequest().index(indexName).source(datum));
        }
        //发送批量新新增请求
        try {
            BulkResponse bulk = this.restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println(bulk.status());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "bulk add es document complete";
    }
}
