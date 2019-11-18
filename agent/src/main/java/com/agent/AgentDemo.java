package com.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author:WangHongHao
 * @date:19-11-15创建
 * @date：修改
 * @description：
 */
public class AgentDemo {
    /**
     * 在main方法前运行，与Main方法运行在同一个JVM中
     *
     * @param agentArgs
     * @param instrumentation
     */
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("======agent premain执行");
        System.out.println("======方法参数"+agentArgs);
    }

    /**
     * 如果上一个没有，则运行这个
     * @param args
     */
    public static void premain(String args) {
        System.out.println("======main运行");
        System.out.println("======方法参数：" + args);
    }
}
