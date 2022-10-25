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
 * @see <a href="https://bugstack.cn/md/netty/expand/2019-08-24-netty%E6%A1%88%E4%BE%8B%EF%BC%8Cnetty4.1%E4%B8%AD%E7%BA%A7%E6%8B%93%E5%B1%95%E7%AF%87%E4%B9%9D%E3%80%8ANetty%E9%9B%86%E7%BE%A4%E9%83%A8%E7%BD%B2%E5%AE%9E%E7%8E%B0%E8%B7%A8%E6%9C%8D%E5%8A%A1%E7%AB%AF%E9%80%9A%E4%BF%A1%E7%9A%84%E8%90%BD%E5%9C%B0%E6%96%B9%E6%A1%88%E3%80%8B.html">Netty集群部署实现跨服务端通信的落地方案</a>
 */
@SpringBootApplication
@ComponentScan("cn.yong.demo.netty")
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
