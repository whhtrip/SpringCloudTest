package com.quartz.dateBase;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author:WangHongHao
 * @date:19-11-15创建
 * @date：修改
 * @description：
 */
public class DbJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("======DbJob run");
    }
}
