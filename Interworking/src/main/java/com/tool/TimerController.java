package com.tool;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author:WangHongHao
 * @date:19-11-08创建
 * @date：修改
 * @description：
 */
public class TimerController {


    public static void main(String[] args) {
        dealTimer();
    }

    public static void dealTimer() {
        Date date = new Date();
        Long sss = date.getTime() + 1000;
        Date date1 = new Date(sss);
        System.out.println(date.toString() + date1.toString() + "时间差" + (date1.getTime() - date.getTime()));
    }

    public static String sleep() throws InterruptedException {
        Thread.sleep(5000);
        return "SUCCESS";
    }

    public static void doTimer() {
        boolean bdStatus = false;
        final ExecutorService exec = Executors.newFixedThreadPool(1);
        Callable<String> call = new Callable<String>() {
            public String call() throws Exception {
                //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
                sleep();
                return "执行成功";
            }
        };
        try {
            Future<String> future = exec.submit(call);
            // set db connection timeout to 10 seconds
            String obj = future.get(1000 * 2, TimeUnit.MILLISECONDS);
            System.out.println(obj);
        } catch (TimeoutException ex) {
            //ex.printStackTrace();
            System.out.println("执行超时");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // close thread pool
        exec.shutdown();
        System.out.println("执行完毕");
    }
}
