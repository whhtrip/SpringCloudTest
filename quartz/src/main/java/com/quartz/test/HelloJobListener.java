package com.quartz.test;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:WangHongHao
 * @date:19-11-13创建
 * @date：修改
 * @description：
 */
public class HelloJobListener implements JobListener {
    Logger logger = LoggerFactory.getLogger(HelloJobListener.class);
    @Override
    public String getName() {
        return "HelloJobListener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        logger.info("====JobListener BeExected");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        logger.info("====JobListener Voted");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        logger.info("====JobListener WasExected");
    }
}
