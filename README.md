# elasticsearch-engine-demo

## 1.介绍
elasticsearch-engine-demo 是 [elasticsearch-engine](https://github.com/wanghuan9/elasticsearch-engine) 项目的测试示例;

包括环境搭建和详细的测试示例

## 2.架构模块

base:  base测试模块为注解查询测试示例 具体的一个查询语句测试

proxy: proxy测试模块为注解查询测试示例 包括 复杂参数,简单参数,sql查询

extend: extend测试模块为orm扩展示例 包括 mybatis,jpa,jooq 普通查询,关联查询,回表查询

error:  error测试模块常见的异常测试示例 包括接口定义不符合规则,参数异常,sql异常,sql不被支持

# 4.测试环境搭建

## 4.1 建表和索引

doc/mysql_init.sql

doc/elasticsearch.init.txt


## 4.2 测试数据初始化
```
com.elasticsearch.engine.demo.InitDataTest#initData
```
## 5.测试模块

###  5.1 base
#### 1)ParseQueryBaseTest 解析查询注解基础测试


通过看控制台 输出的查询语句判断解析是否正确

#### 2)ParseResponseBaseTest 构建基础响应测试模块


当查询结果比较复杂 不是简单的将hits转为json对象时, 可以通过自定义响应对结果进行扩展
###  5.2 proxy
#### 1)EsEngineProxyModelQueryTest 注解查询 model参数


查询的PersonEsParamRepository 必须继承 BaseESRepository 否则无法扫描注册
 
 规则:
 * 1)查询参数必须为1个, 并且不是基础类型
 * 2)响应参数的类型或者泛型 必须为Repository的泛型或者自定义响应的泛型,或者固定结果DefaultResp的子类型

#### 2)EsEngineProxyParamQueryTest 注解查询 param参数


查询的PersonEsParamRepository 必须继承 BaseESRepository 否则无法扫描注册

规则:
* 1)查询参数为1个或多个, 参数类型都是基础类型(额外包括 List,LocalDateTime,LocalDate,BigDecimal)
* 2)响应参数的类型或者泛型 必须为Repository的泛型或者自定义响应的泛型,或者固定结果DefaultResp的子类型

#### 3)EsEngineProxySqlQueryTest sql查询测试示例

查询的PersonEsParamRepository 必须继承 BaseESRepository 否则无法扫描注册

###  5.3 extend

#### 1)EsEngineExtendMybatisQueryTest

mybatis查询测试示例

#### 2)EsEngineExtendJpaQueryTest

jpa查询测试示例

#### 3)EsEngineExtendJooqQueryTest

jooq查询测试示例

###  5.4 error

#### 1)EsEngineProxyNoExtendQueryTest 异常测试示例
注解查询未继承 BaseESRepository

#### 2)EsEngineProxyErrorQueryTest 异常测试示例
注解查询 入参 出差异常

#### 3)EsEngineSqlErrorQueryTest sql查询异常场景测试
* 不支持的sql
* sql语法错误
* 参数错误
* Unknown column