package com.config.mybatis;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author:WangHongHao
 * @date:19-10-14创建
 * @date：修改
 * @description：
 */
//@Configuration
public class MybatisConfig {
    Logger logger = LoggerFactory.getLogger(MybatisConfig.class);
    @Autowired
    DataSource dataSource;

   // @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSession(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        logger.info("创建MybatisSqlSession工厂："+sqlSessionFactoryBean);
        logger.info("sqlSessionFactory配置数据源："+dataSource);
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
}
