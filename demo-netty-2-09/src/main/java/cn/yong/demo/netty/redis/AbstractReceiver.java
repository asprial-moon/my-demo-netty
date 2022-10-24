package cn.yong.demo.netty.redis;

/**
 * 抽象接收器
 * @author Allen
 * @date 2022/10/24
 */
public abstract class AbstractReceiver {

    public abstract void receiveMessage(Object message);

}
