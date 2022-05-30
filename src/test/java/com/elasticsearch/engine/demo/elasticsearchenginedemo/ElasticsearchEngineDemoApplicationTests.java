package com.elasticsearch.engine.demo.elasticsearchenginedemo;

import com.elasticsearch.engine.elasticsearchengine.EnableEsEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEsEngine
@SpringBootApplication
public class ElasticsearchEngineDemoApplicationTests {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchEngineDemoApplicationTests.class, args);
    }

}
