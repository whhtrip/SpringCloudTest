package com.test.logtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:WangHongHao
 * @date:19-10-24创建
 * @date：修改
 * @description：
 */
public class LogUtil {
    private static Logger logger = LoggerFactory.getLogger(LogUtil.class);
    public static void logPrint(){
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
    }
}
