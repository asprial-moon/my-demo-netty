package cn.yong.demo.netty.test;

import cn.yong.demo.netty.client.ClientSocket;
import cn.yong.demo.netty.future.SyncWrite;
import cn.yong.demo.netty.msg.Request;
import cn.yong.demo.netty.msg.Response;
import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelFuture;

/**
 * @author Allen
 * @date 2022/10/23
 */
public class StartClient {
    private static ChannelFuture future;

    public static void main(String[] args) {
        System.out.println("Hi Netty 学习开始");
        ClientSocket client = new ClientSocket();
        new Thread(client).start();

        while (true) {
            try {
                // 获取future, 线程有等待处理时间
                if (null == future) {
                    future = client.getFuture();
                    Thread.sleep(2000);
                    continue;
                }
                // 构建发送参数
                Request request = new Request();
                request.setResult("查询 {Netty 学习} 用户信息");
                SyncWrite s = new SyncWrite();
                Response response = s.writeAndSync(future.channel(), request, 1000);
                System.out.println("调用结果：" + JSON.toJSON(response));
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
