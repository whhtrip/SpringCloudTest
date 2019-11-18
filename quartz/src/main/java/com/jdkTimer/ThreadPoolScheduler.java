package com.jdkTimer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author:WangHongHao
 * @date:19-11-14创建
 * @date：修改
 * @description：
 */
public class ThreadPoolScheduler {
    Logger logger = LoggerFactory.getLogger(ThreadPoolScheduler.class);

    public void schedulerRun() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                logger.info("我开始执行了");
            }
        };
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(runnable,0,1, TimeUnit.SECONDS);
        //TimeUnit.MILLISECONDS;
    }

    public static void main(String[] args) {
        ThreadPoolScheduler threadPoolScheduler = new ThreadPoolScheduler();
        threadPoolScheduler.schedulerRun();
    }
}
