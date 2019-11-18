package com.springbootTimer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author:WangHongHao
 * @date:19-11-14创建
 * @date：修改
 * @description：
 */
@Component
public class SpringBootTimerTest {
    private Logger logger = LoggerFactory.getLogger(SpringBootTimerTest.class);

    @Scheduled(cron = "0 * * * * ?")
    public void run1() {
        logger.info("====run1执行了");
    }
    @Scheduled(fixedRate = 1000l)
    public void run2(){
        logger.info("====run2执行了");
    }
}
