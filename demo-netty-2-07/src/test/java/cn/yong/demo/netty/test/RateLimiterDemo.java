package cn.yong.demo.netty.test;


import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;

/**
 * @author Line
 * @desc
 * @date 2022/10/17
 */
public class RateLimiterDemo {
    static RateLimiter limiter = RateLimiter.create(2);

    public static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() / 1000);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            limiter.acquire();
            new Thread(new Task()).start();
        }
    }
}
