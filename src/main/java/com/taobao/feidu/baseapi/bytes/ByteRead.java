package com.taobao.feidu.baseapi.bytes;

import com.taobao.feidu.baseapi.Constants;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * User: feidu
 * Date: 13-2-20
 * Time: 下午3:49
 */
public class ByteRead {
    public static void main(String[] args) throws Exception {
        File file = new File(Constants.BYTE_FILE);
        InputStream inputStream = new FileInputStream(file);
        inputStream = new BufferedInputStream(inputStream);
        inputStream = new DataInputStream(inputStream);
        StringBuffer buffer = new StringBuffer();
        byte[] buf = new byte[64];
        int count = 0;
        try {
            while ((count = inputStream.read(buf)) != -1) {
                for (int i = 0; buf.length > i; i++) {
                    System.out.print(buf[i]);
                }
            }
        } finally {
            inputStream.close();
        }
        System.out.println();
        byte[] strByte = Constants.STR.getBytes();
        for (int i = 0; strByte.length > i; i++) {
            Byte b = strByte[i];
            System.out.print(b);
        }
    }
}
