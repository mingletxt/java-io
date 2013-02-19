package com.taobao.feidu.baseapi;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * User: mingle
 * Date: 12-11-27
 * Time: 上午12:15
 * desc
 */
public class CharSetTest {
    public static void main(String args[]) throws Exception {
        String file = "stream.txt";
        String charset = "UTF-8";
        // 写字符换转成字节流
        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, charset);
        try {
            writer.write("这是要保存的中文字符");
        } finally {
            writer.close();
        }
        //读取字节转换成字符
        InputStream inputStream = new FileInputStream(file);
        inputStream = new BufferedInputStream(inputStream);
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        StringBuffer buffer = new StringBuffer();
        char[] buf = new char[64];
        int count = 0;
        try {
            while ((count = reader.read(buf)) != -1) {
                buffer.append(buf, 0, count);
            }
            System.out.println("buffer" + buffer.toString());
        } finally {
            reader.close();
        }

        String s = "这是一段中文字符串";
        byte[] b = s.getBytes("UTF-8");
        for (byte bit : b) {
            System.out.print(bit);
        }
        String n = new String(b, "UTF-8");
        System.out.println(n);

        String string = "我是mingle尼马";
        Charset charsetor = Charset.forName("UTF-8");
        ByteBuffer byteBuffer = charsetor.encode(string);
        System.out.println(byteBuffer.toString());
        CharBuffer charBuffer = charsetor.decode(byteBuffer);
        System.out.println(charBuffer.toString());
    }
}
