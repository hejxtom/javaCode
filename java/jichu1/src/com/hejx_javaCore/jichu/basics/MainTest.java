package com.hejx_javaCore.jichu.basics;
/**
 * main()方法：
 *    1.main()方法是程序的入口
 *    2.mian()方法也是一个普通的static方法
 *    3.main()方法可以与控制台交互（之前：Scanner）
 *
 */
public class MainTest {
    public static void main(String[] args){
        if (args.length != 0)
            for (int i = 0; i < args.length; i++)
                System.out.println("-->"+args[i]);
        else
            System.out.println("hello world");
    }

}

class Main{
    public static void main(String[] args){
        args = new String[10];
        for (int i = 0; i < args.length; i++)
            args[i] = "args_" + (i + 1);
        MainTest.main(args);
    }
}