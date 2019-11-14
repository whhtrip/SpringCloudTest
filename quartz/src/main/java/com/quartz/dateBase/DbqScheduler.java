package com.quartz.dateBase;

import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author:WangHongHao
 * @date:19-11-13创建
 * @date：修改
 * @description：
 */
public class DbqScheduler {
    public void createScheduler(){
        try {
            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory("dbquartz.properties");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
