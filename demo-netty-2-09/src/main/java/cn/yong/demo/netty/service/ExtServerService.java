package cn.yong.demo.netty.service;

import cn.yong.demo.netty.domain.MsgAgreement;
import cn.yong.demo.netty.redis.Publisher;
import cn.yong.demo.netty.redis.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 扩展服务
 * @author Allen
 * @date 2022/10/24
 */
@Service("extServerService")
public class ExtServerService {
    @Resource
    private Publisher publisher;
    @Resource
    private RedisUtil redisUtil;

    public void push(MsgAgreement msgAgreement) {
        publisher.pushMessage("itstack-demo-netty-push-msgAgreement", msgAgreement);
    }

    public RedisUtil getRedisUtil() {
        return redisUtil;
    }
}
