package com.config.dataSource;

import com.interworking.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

import static org.junit.Assert.*;
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class DataSourceConfigTest {
    @Autowired
    DataSource dataSource;
    @Test
    public void getDataSource1() {
        System.out.println(dataSource);
    }
}