package com.hejx_javaCore.senior.iostream.serialization;

import org.junit.Test;

import java.io.*;

/**
 * @Classname ObjectInputOutputStream
 * @Description TODO
 * @Date 13:47 2021/1/27
 * @Created by hejx
 *
 * 对象流的使用：
 *     1.ObjectInputStream 和 Object OutputStream
 *     2.作用：用于存储和读取基本数据类型或对象处理流。他的强大之处在于可以把Java中的对象序列化与反序列化
 *
 *
 *
 */

public class ObjectInputOutputStream {
    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去。
     * 使用ObjectOutputStream实现
     *
     *
     */

    @Test
    public void test1() throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("D:\\HejxCode\\data.dat"));
        oos.writeObject(new Person("王明",23));

        oos.flush();

        oos.close();
    }


    /**
     * 反序列化过程：将磁盘文件中的对象或者从网络中获取的对象(网络传输对象一般利用json)，还原成内存中的一个Java对象
     * 使用ObjectInputStream实现
     *
     *
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream oos=new ObjectInputStream(new FileInputStream("D:\\HejxCode\\data.dat"));
        Object obj=oos.readObject();
        System.out.println(obj);

        oos.close();
    }



}
