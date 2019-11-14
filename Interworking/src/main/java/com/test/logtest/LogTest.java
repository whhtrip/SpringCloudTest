package com.test.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:WangHongHao
 * @date:19-10-24创建
 * @date：修改
 * @description：
 */
public class LogTest {
    static Logger logger = LoggerFactory.getLogger(LogTest.class);
    public static void main(String[] args) {
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
        logger.warn("warn");
        logger.trace("trace");
    }

}
