package cn.yong.demo.netty.domain.protocol;

/**
 * 协议包
 * @author Allen
 * @date 2022/10/25
 */
public abstract class Packet {

    /**
     * 获取协议指令
     * @return
     */
    public abstract Byte getCommand();
}
