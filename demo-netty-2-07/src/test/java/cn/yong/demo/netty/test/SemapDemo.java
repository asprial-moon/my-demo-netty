package cn.yong.demo.netty.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Line
 * @desc
 * @date 2022/10/16
 */
public class SemapDemo implements Runnable {
    final Semaphore semp = new Semaphore(5);
    
    @Override
    public void run() {
        try {
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ": done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semp.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);

        }
    }
}
