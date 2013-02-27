package com.taobao.feidu.baseapi.buffer;

import com.taobao.feidu.baseapi.Constants;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * User: feidu
 * Date: 13-2-20
 * Time: 下午3:31
 * To change this template use File | Settings | File Templates.
 */
public class BufferIO {
    public static void main(String[] args) throws Exception {
        //读取字节转换成字符
        InputStream inputStream = new FileInputStream(Constants.BYTE_FILE);
        //inputStream = new BufferedInputStream(inputStream);
        InputStreamReader reader = new InputStreamReader(inputStream, Constants.CHAR_SET);
        StringBuffer buffer = new StringBuffer();
        char[] buf = new char[64];
        int count = 0;
        try {
            while ((count = reader.read(buf)) != -1) {
                buffer.append(buf, 0, count);
            }
            System.out.println("buffer read :" + buffer.toString());
        } finally {
            reader.close();
        }
    }
}
