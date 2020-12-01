package com.hejx_javaCore.jichu.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 异常处理的方式二：throws + 异常类型
 *     1."throws + 异常类型"写在方法声明处。指明此方法执行时，可能会抛出的异常类型
 *       一旦当方法体执行时，出现异常，仍会在异常代码生成一个异常类的对象，
 *       此对象满足throws后异常类型时，就会被抛出。异常后的代码就不再执行了！
 *     2.try-catch-finally:真正的将异常处理
 *       throws的方式只是将异常抛给调用者
 *
 *
 * 开发中如何选择使用try-catch-finally 还是使用throws
 *     1.如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能用throws,
 *       意味着如果子类重写的方法中有异常，必须用try-catch-finally
 *     2.执行的方法a中,先后又调用了另外的几个方法，这几个方法是递进关系执行的。
 *       我们建议这个几个方法使用throws的方式进行异常处理。而执行的方法a可以考虑使用try-catch-finally方式进行处理
 *
 */
public class ExceptionTest2 {

    public static void main(String[] args){

         try {
             method1();
         }catch(Exception e){
             e.printStackTrace();
         }
    }

    public static void method1() throws IOException {
        method();
    }

    public static void method() throws IOException {
        File file =new File("src/com/hejx_javaCore/jichu/exception/hello.txt");
        FileInputStream fis=new FileInputStream(file);
        int data=fis.read();
        while (data !=-1){
            System.out.print((char)data);
            data=fis.read();
        }
        fis.close();
    }


}
