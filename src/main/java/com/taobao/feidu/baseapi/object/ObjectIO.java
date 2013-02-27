package com.taobao.feidu.baseapi.object;

/**
 * User: feidu
 * Date: 13-2-22
 * Time: 上午10:58
 */

import com.taobao.feidu.baseapi.UserVO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Michael
 * @blog http://sjsky.iteye.com
 */
public class ObjectIO {

    /**
     * 文件转化为Object
     *
     * @param fileName
     * @return bytes[]
     */
    public static Object file2Object(String fileName) {

        InputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(fileName));
            ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 把Object输出到文件
     *
     * @param obj
     * @param outputFile
     */
    public static void object2File(Object obj, String outputFile) {
        ObjectOutputStream oos = null;
        OutputStream fos = null;
        try {
            fos = new BufferedOutputStream(new FileOutputStream(new File(outputFile)));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /**
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String fileName = "object.obj";
        List<String> list = new ArrayList<String>();
        list.add("michael");
        list.add("大大");

        ObjectIO.object2File(list, fileName);
        System.out.println("success write List<String> to file.");

        List<String> tmpList = (List<String>) ObjectIO
                .file2Object(fileName);
        for (String tmp : tmpList) {
            System.out.println(tmp);
        }

        System.out.println("--------------------------------");

        fileName = "uservo.obj";
        UserVO vo = new UserVO("michael", "大大", 18, new Date());

        ObjectIO.object2File(vo, fileName);
        System.out.println("success write bean:UserVo to file.");

        UserVO tmpvo = (UserVO) ObjectIO.file2Object(fileName);
        System.out.println("read bean:UserVo from file get info : " + tmpvo);

    }

}

