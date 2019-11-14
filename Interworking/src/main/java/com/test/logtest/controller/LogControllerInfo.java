package com.test.logtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author:WangHongHao
 * @date:19-10-24创建
 * @date：修改
 * @description：
 */
@RestController
@RequestMapping("infoLog")
public class LogControllerInfo {
    Logger logger = LoggerFactory.getLogger(LogControllerInfo.class);
    @Resource(name = "dataSource1")
    DataSource dataSource;
    @RequestMapping("testLog")
    public String testLog(){
        StringBuilder s = new StringBuilder();
        String info = "info";
        String debug = "debug";
        String trace = "trace";
        String warn = "warn";
        String error = "error";
        System.out.println("/n");
        logger.info(info);
        logger.warn(warn);
        logger.trace(trace);
        logger.debug(debug);
        logger.error(error);
        System.out.println("/n");
        return s.toString();
    }
}
