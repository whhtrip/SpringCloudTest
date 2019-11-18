package com.quartz.dateBase;

import com.quartz.test.HelloJob;
import com.quartz.test.HelloJobListener;
import com.quartz.test.HelloSchedulerListener;
import com.quartz.test.HelloTriggerListener;
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
public class DbqScheduler {
    static Logger logger = LoggerFactory.getLogger(DbqScheduler.class);

    public static void createScheduler() {
        try {
            //读取配置文件
            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory("dbquartz.properties");
            Scheduler scheduler = stdSchedulerFactory.getScheduler();
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
        createScheduler();
    }
}
