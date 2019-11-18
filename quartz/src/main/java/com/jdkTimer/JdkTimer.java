package com.jdkTimer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author:WangHongHao
 * @date:19-11-14创建
 * @date：修改
 * @description：
 */
public class JdkTimer {
    static Logger logger = LoggerFactory.getLogger(JdkTimer.class);

    public static void doTimer() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                logger.info("====开始执行任务");
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long interl = 1000;
        timer.schedule(timerTask, delay, interl);
    }

    public static void main(String[] args) {

        System.out.println("====我执行了");
    }
}
