package com.hitol.springboot.test.threadPool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    private static ExecutorService es =
            new ThreadPoolExecutor(50, 100, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(100000));


    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            es.execute(new AsyncMethod(i));
        }
        System.out.println("main");

        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) es);
        int queueSize = tpe.getQueue().size();
        System.out.println("当前排队线程数：" + queueSize);
        int activeCount = tpe.getActiveCount();
        System.out.println("当前活动线程数：" + activeCount);
        long completedTaskCount = tpe.getCompletedTaskCount();
        System.out.println("执行完成线程数：" + completedTaskCount);
        long taskCount = tpe.getTaskCount();
        System.out.println("总线程数：" + taskCount);

        Thread.sleep(3000);
        tpe.shutdownNow();
    }

}
