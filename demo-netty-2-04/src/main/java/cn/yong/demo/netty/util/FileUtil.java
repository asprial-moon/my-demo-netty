package cn.yong.demo.netty.util;

import cn.yong.demo.netty.domain.Constants;
import cn.yong.demo.netty.domain.FileBurstData;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Line
 * @desc 文件读写工具
 * @date 2022/9/26
 */
public class FileUtil {

    public static FileBurstData readFile(String fileUrl, Integer readPosition) throws IOException {
        File file = new File(fileUrl);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");// r:只读模式  rw:读写模式
        randomAccessFile.seek(readPosition);
        byte[] bytes = new byte[1024 * 100];
        int readSize = randomAccessFile.read(bytes);
        if (readSize <= 0) {
            randomAccessFile.close();
            //Constants.FileStatus ｛0开始、1中间、2结尾、3完成｝
            return new FileBurstData(Constants.FileStatus.COMPLETE);
        }

        FileBurstData fileInfo = new FileBurstData();
        fileInfo.setFileUrl(fileUrl);
        fileInfo.setFileName(file.getName());
        fileInfo.setBeginPos(readPosition);
        fileInfo.setEndPos(readPosition + readSize);
        // 不足1024需要拷贝去掉空字符
        if (readSize < 1024 * 1024) {
            byte[] copy = new byte[readSize];
            System.arraycopy(bytes, 0, copy, 0, readSize);
            fileInfo.setBytes(copy);
            fileInfo.setStatus(Constants.FileStatus.END);
        } else {
            fileInfo.setBytes(bytes);
            fileInfo.setStatus(Constants.FileStatus.CENTER);
        }
        randomAccessFile.close();
        return fileInfo;
    }

}
