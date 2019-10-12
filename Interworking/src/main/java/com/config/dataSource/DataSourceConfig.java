package com.config.dataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author:WangHongHao
 * @date:19-10-12创建
 * @date：修改
 * @description：
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource getDataSource1(){
        return DataSourceBuilder.create().build();
    }
}
