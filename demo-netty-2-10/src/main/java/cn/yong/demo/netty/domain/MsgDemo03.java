package cn.yong.demo.netty.domain;

import cn.yong.demo.netty.domain.protocol.Command;
import cn.yong.demo.netty.domain.protocol.Packet;

/**
 * 消息协议
 * @author Allen
 * @date 2022/10/25
 */
public class MsgDemo03 extends Packet {

    private String channelId;
    private String demo03;

    public MsgDemo03(String channelId, String demo03) {
        this.channelId = channelId;
        this.demo03 = demo03;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getDemo03() {
        return demo03;
    }

    public void setDemo03(String demo03) {
        this.demo03 = demo03;
    }

    @Override
    public Byte getCommand() {
        return Command.Demo03;
    }
}
