package com.quartz.test;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:WangHongHao
 * @date:19-11-13创建
 * @date：修改
 * @description：
 */
public class HelloTriggerListener implements TriggerListener {
    Logger logger = LoggerFactory.getLogger(HelloTriggerListener.class);

    @Override
    public String getName() {
        return "HelloTrigger";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        logger.info("====HelloTrigger Fired");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        logger.info("====HelloTrigger vetoJobExecution");
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        logger.info("====HelloTrigger Misfired");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        logger.info("====HelloTrigger Complete");
    }
}
