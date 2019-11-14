package com.quartz.test;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:WangHongHao
 * @date:19-11-13创建
 * @date：修改
 * @description：
 */
public class HelloSchedulerListener implements SchedulerListener {
    Logger logger = LoggerFactory.getLogger(HelloSchedulerListener.class);

    @Override
    public void jobScheduled(Trigger trigger) {
        logger.info("====jobScheduled");
    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {
        logger.info("====jobUnscheduled");
    }

    @Override
    public void triggerFinalized(Trigger trigger) {
        logger.info("====triggerFinalized");
    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {
        logger.info("====triggerPaused");
    }

    @Override
    public void triggersPaused(String s) {
        logger.info("====triggersPaused");
    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {
        logger.info("====triggerResumed");
    }

    @Override
    public void triggersResumed(String s) {
        logger.info("====triggersResumed");
    }

    @Override
    public void jobAdded(JobDetail jobDetail) {
        logger.info("====jobAdded");
    }

    @Override
    public void jobDeleted(JobKey jobKey) {
        logger.info("====jobDeleted");
    }

    @Override
    public void jobPaused(JobKey jobKey) {
        logger.info("====jobPaused");
    }

    @Override
    public void jobsPaused(String s) {
        logger.info("====jobsPaused");
    }

    @Override
    public void jobResumed(JobKey jobKey) {
        logger.info("====jobResumed");
    }

    @Override
    public void jobsResumed(String s) {
        logger.info("====jobsResumed");
    }

    @Override
    public void schedulerError(String s, SchedulerException e) {
        logger.info("====schedulerError");
    }

    @Override
    public void schedulerInStandbyMode() {
        logger.info("====schedulerInStandbyMode");
    }

    @Override
    public void schedulerStarted() {
        logger.info("====schedulerStarted");
    }

    @Override
    public void schedulerStarting() {
        logger.info("====schedulerStarting");
    }

    @Override
    public void schedulerShutdown() {
        logger.info("====schedulerShutdown");
    }

    @Override
    public void schedulerShuttingdown() {
        logger.info("====schedulerShuttingdown");
    }

    @Override
    public void schedulingDataCleared() {
        logger.info("====schedulingDataCleared");
    }
}
