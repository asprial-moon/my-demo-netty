package cn.yong.demo.netty;

import cn.yong.demo.netty.redis.RedisUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import javax.annotation.Resource;

/**
 * @author Line
 * @desc
 * @date 2022/10/25
 */
@SpringBootApplication
@ComponentScan(value = {"cn.yong.demo.netty"})
public class NetttyApplication implements CommandLineRunner {

    @Resource
    private RedisUtil redisUtil;

    public static void main(String[] args) {
        SpringApplication.run(NetttyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        redisUtil.clear();
    }
}
