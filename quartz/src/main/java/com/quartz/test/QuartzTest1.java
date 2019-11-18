package com.quartz.test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author:WangHongHao
 * @date:19-11-13创建
 * @date：修改
 * @description：
 */
public class QuartzTest1 {
    Logger logger = LoggerFactory.getLogger(QuartzTest1.class);

    public void test1() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            //添加执行器
            Scheduler scheduler = schedulerFactory.getScheduler();
            logger.info("====初始化执行器" + scheduler);
            Date date = DateBuilder.evenSecondDate(new Date());
            logger.info("====初始化时间器：" + date);
            JobDetail jobBuilder = JobBuilder.newJob(HelloJob.class).
                    withIdentity("job1", "group1").
                    build();
            logger.info("====初始化任务构造器：" + jobBuilder);
            Trigger trigger = TriggerBuilder.newTrigger().
                    withIdentity("trigger1", "group1").
                    startNow().
                    withSchedule(
                            SimpleScheduleBuilder.
                                    repeatSecondlyForever()).
                    build();
            logger.info("====初始化触发器：" + trigger);
            //EverythingMatcher.allJobs();匹配所有任务
            scheduler.scheduleJob(jobBuilder, trigger);
            logger.info("====添加任务监听");
            scheduler.getListenerManager().addJobListener(new HelloJobListener(), GroupMatcher.jobGroupEquals("group1"));
            logger.info("====添加触发器监听");
            scheduler.getListenerManager().addTriggerListener(new HelloTriggerListener(),GroupMatcher.groupEquals("group1"));
            logger.info("====添加执行器监听");
            scheduler.getListenerManager().addSchedulerListener(new HelloSchedulerListener());
            logger.info("====启动执行器");
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QuartzTest1 quartzTest1 = new QuartzTest1();
        quartzTest1.test1();
    }

}
