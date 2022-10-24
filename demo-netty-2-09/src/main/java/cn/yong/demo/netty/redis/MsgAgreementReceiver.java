package cn.yong.demo.netty.redis;

import cn.yong.demo.netty.domain.MsgAgreement;
import cn.yong.demo.netty.util.CacheUtil;
import cn.yong.demo.netty.util.MsgUtil;
import com.alibaba.fastjson.JSON;

import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 消息协议接收者
 * 实现抽象类用于接受订阅到的次奥西，接收消息后进行业务处理
 * @author Allen
 * @date 2022/10/24
 */
@Service
public class MsgAgreementReceiver extends AbstractReceiver {
    private Logger logger = LoggerFactory.getLogger(MsgAgreementReceiver.class);

    @Override
    public void receiveMessage(Object message) {
        logger.info("接收到PUSH消息：{}", message);
        MsgAgreement msgAgreement = JSON.parseObject(message.toString(), MsgAgreement.class);
        String toChannelId = msgAgreement.getToChannelId();
        Channel channel = CacheUtil.cacheChannel.get(toChannelId);
        if (null == channel) return;
        channel.writeAndFlush(MsgUtil.obj2Json(msgAgreement));
    }
}
