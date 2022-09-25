package cn.yong.demo.netty.domain;

/**
 * @author Line
 * @desc 文件描述信息
 * @date 2022/9/26
 */
public class FileDescInfo {
    private String fileUrl;
    private String fileName;
    private String fileSize;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}
