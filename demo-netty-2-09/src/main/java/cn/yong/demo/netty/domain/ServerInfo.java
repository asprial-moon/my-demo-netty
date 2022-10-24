package cn.yong.demo.netty.domain;

import java.util.Date;

/**
 * 服务端信息
 * @author Allen
 * @date 2022/10/24
 */
public class ServerInfo {

    private String ip;
    private int port;
    private Date openDate;

    public ServerInfo(String ip, int port, Date openDate) {
        this.ip = ip;
        this.port = port;
        this.openDate = openDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
}
