package cn.yong.demo.netty.msg;

/**
 * @author Line
 * @desc
 * @date 2022/10/22
 */
public class Response {

    private String requestId;

    private String param;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
