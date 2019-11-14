package com.test.logtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:WangHongHao
 * @date:19-10-24创建
 * @date：修改
 * @description：
 */
@RestController
@RequestMapping("warnLog")
public class LogControllerWarn {
    Logger logger = LoggerFactory.getLogger(LogControllerWarn.class);
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
        logger.error(error);        System.out.println("/n");
        return s.toString();
    }
}
