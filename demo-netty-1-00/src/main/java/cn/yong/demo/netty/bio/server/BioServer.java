package cn.yong.demo.netty.bio.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author Allen
 * @date 2022/9/20
 */
public class BioServer extends Thread {

    private ServerSocket serverSocket = null;

    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
        bioServer.start();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(7397));
            System.out.println("itstack-demo-netty bio server start done. {关注公众号：bugstack虫洞栈 | 欢迎关注&获取源码}");
            while (true) {
                Socket socket = serverSocket.accept();
                BioServerHandler handler = new BioServerHandler(socket, Charset.forName("utf-8"));
                handler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
