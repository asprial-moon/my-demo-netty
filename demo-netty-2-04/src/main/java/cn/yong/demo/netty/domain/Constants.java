package cn.yong.demo.netty.domain;

/**
 * @author Line
 * @desc
 * @date 2022/9/26
 */
public class Constants {

    public static class FileStatus {
        /**
         * 开始
         */
        public static int BEGIN     = 0;
        /**
         * 中间
         */
        public static int CENTER    = 1;
        /**
         * 结尾
         */
        public static int END       = 2;
        /**
         * 完成
         */
        public static int COMPLETE  = 3;
    }

    public static class TransferType {
        /**
         * 请求传输文件
         */
        public static int REQUEST   = 0;
        /**
         * 1 文件传输指令
         */
        public static int INSTRUCT  = 1;
        /**
         * 2 文件传输数据
         */
        public static int DATA      = 2;
    }
}
