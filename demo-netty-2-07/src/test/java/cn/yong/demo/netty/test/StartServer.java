package cn.yong.demo.netty.test;


import cn.yong.demo.netty.server.ServerSocket;

/**
 * @author Allen
 * @date 2022/10/23
 */
public class StartServer {
    public static void main(String[] args) {
        new Thread(new ServerSocket()).start();
        System.out.println("Netty Server start done!");
    }
}
