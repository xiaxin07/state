package com.xiaxin;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author cxq
 */
public class TestCountDownLatch {


    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        CountDownRunnable countDownRunnable = new CountDownRunnable(countDownLatch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(countDownRunnable).start();
        }

        try {
//            CyclicBarrier
//            Semaphore
//            countDownLatch.await()
//            Executors.newCachedThreadPool()
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}

class CountDownRunnable implements Runnable {
    private CountDownLatch latch;

    public CountDownRunnable(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            latch.countDown();
        }
    }
}