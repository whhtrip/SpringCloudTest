package com.jdkTimer;

/**
 * @author:WangHongHao
 * @date:19-11-14创建
 * @date：修改
 * @description：
 */
public class ThreadSleep {
    public void sleepAndRun(Long timer){}

    public static void main(String[] args) {
        long timer = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //线程睡眠到执行时间执行，如果循环可以while  do实现
                    Thread.sleep(timer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).run();
    }
}
