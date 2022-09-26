package cn.yong.demo.netty.test;

import cn.yong.demo.netty.server.NettyServer;

/**
 * @author Line
 * @desc
 * @date 2022/9/26
 */
public class NettyServerTest {
    public static void main(String[] args) {
        System.out.println("hi 微信公众号：bugstack虫洞栈 | 欢迎关注&获取更多专题案例");
        // 启动服务
        new NettyServer().bing(7397);
    }
}
