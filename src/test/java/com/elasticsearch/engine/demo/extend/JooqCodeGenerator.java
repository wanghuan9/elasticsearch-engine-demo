//package com.elasticsearch.engine.demo.extend;
//
//import org.junit.Test;
//
///**
// * User：David Young
// * Date：2020/8/4
// */
//public class JooqCodeGenerator {
//
//  @Test
//  public void byYangYong() {
//    SingleModeConfig.builder()//单模块模式，生成的所有代码默认放置在同一个模块下
//        .defaultModuleName("supply-pop-service")//默认生成代码所属module名称
//        .defaultSrc("src/main/java")//默认生成代码所属资源目录
//        .defaultPackage("com.aihuishou.supply.pop.service")//默认生成代码所属package
//        .author("David Young")//默认生成代码作者
//        .email("yong.yang@aihuishou.com")//默认生成代码邮箱
//        .jooqModuleName("supply-pop-service")//jOOQ代码所属module名称
//        .jooqPackage("com.aihuishou.supply.pop.service.jooq")//jOOQ代码所属package
//        .modelModuleName("supply-pop-model")//model模型所属module名称
//        .modelPackage("com.aihuishou.supply.pop.model")//model模型所属package
////        .dataSource(DataSourceConfig.builder()
////            .jdbc("jdbc:mysql://rm-bp1c7x903mw3i114j.mysql.rds.aliyuncs.com:3306/supplier?useUnicode=true&characterEncoding=UTF-8&useSSL=false")//数据源连接
////            .username("ahs_user")//数据源用户名
////            .password("1s186XMPRvB9bTY2")//数据源密码
////            .build()
////        )
//        .dataSource(DataSourceConfig.builder()
//            .jdbc("jdbc:mysql://mysql-cn-east-2-e992edb38eac40c2.rds.jdcloud.com")//数据源连接
//            .username("user_dev")//数据源用户名
//            .password("User_DEV_JD_1024KB")//数据源密码
//            .build()
//        )
//        .table(Tables.ITEM_DRAFTS_JDX_EXTEND)//待生成的表
//        .build()
//        .init()//初始化上下文
//        .genEntity()//生成实体类
//        .genDao()//生成DAO类
//        .genSpi()//生成服务提供接口类
//        .genService()//生成服务提供接口实现类
////        .genBiz()//生成业务类
////        .genRequest()//生成request类
////        .genResponse()//生成response类
//    ;
//  }
//}
