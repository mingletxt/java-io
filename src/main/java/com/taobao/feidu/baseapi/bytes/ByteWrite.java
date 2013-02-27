package com.taobao.feidu.baseapi.bytes;

import com.taobao.feidu.baseapi.Constants;

import java.io.FileOutputStream;

/**
 * User: feidu
 * Date: 13-2-20
 * Time: 下午3:45
 * 字节的output测试
 */
public class ByteWrite {
    public static void main(String[] args) throws Exception {
        FileOutputStream outputStream = new FileOutputStream(Constants.BYTE_FILE);
        try {
            byte[] bytes = Constants.STR.getBytes();
            for(int i = 0; i< bytes.length; i++){
                System.out.println(bytes[i]);
            }
            outputStream.write(bytes);
        } finally {
            outputStream.close();
        }
    }
}
