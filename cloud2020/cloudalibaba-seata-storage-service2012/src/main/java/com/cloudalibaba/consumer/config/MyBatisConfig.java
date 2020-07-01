package com.cloudalibaba.consumer.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.cloudalibaba.consumer.dao"})
public class MyBatisConfig {


}
