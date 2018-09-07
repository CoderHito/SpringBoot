package com.hitol.springboot.test.threadPool;

public class AsyncMethod implements Runnable {

    private int data;

    public AsyncMethod(int i) {
        this.data = i;
    }

    @Override
    public void run() {
        try {
            long startTimt = System.currentTimeMillis();
            if (data % 2 == 0) {
                Thread.sleep(1000);
            }
            System.out.println(Thread.currentThread().getName() + " id " + Thread.currentThread().getId() + "-----------花费时间----" + (System.currentTimeMillis() - startTimt));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
