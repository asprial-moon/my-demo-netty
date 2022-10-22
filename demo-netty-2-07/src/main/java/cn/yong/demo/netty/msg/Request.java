package cn.yong.demo.netty.msg;

/**
 * @author Line
 * @desc
 * @date 2022/10/22
 */
public class Request {

    private String requestId;

    private Object result;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
