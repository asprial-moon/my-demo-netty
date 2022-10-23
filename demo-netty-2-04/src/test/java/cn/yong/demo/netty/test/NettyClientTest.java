package cn.yong.demo.netty.test;

import cn.yong.demo.netty.client.NettyClient;
import cn.yong.demo.netty.domain.FileTransferProtocol;
import cn.yong.demo.netty.util.MsgUtil;
import io.netty.channel.ChannelFuture;

import java.io.File;

/**
 * @author Line
 * @desc
 * @date 2022/9/26
 */
public class NettyClientTest {
    public static void main(String[] args) {
        ChannelFuture channelFuture = new NettyClient().connect("127.0.0.1", 7397);

        File file = new File("D:\\RECON_FILE_10000016247_01042022\\JOICOM_CORPORATION_10000016247_MP_01042022_reconciliationreport.zip");
        FileTransferProtocol fileTransferProtocol = MsgUtil.buildRequestTransferFile(file.getAbsolutePath(), file.getName(), file.length());

        // 发送信息
        channelFuture.channel().writeAndFlush(fileTransferProtocol);
    }
}
