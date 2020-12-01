package com.hejx_javaCore.jichu.basics;

import java.util.Scanner;

/*
* java.util.Scanner
*  注意String类
*
* */
public class ScannerTest {
    public  static  void main(String[] args){
        String n;
        char ch;
        Scanner scanner=new Scanner(System.in);
        n= scanner.next();
        //scanner.nextLine();
       // System.out.println(scanner.hasNext());
        //获取字符
        ch=n.charAt(0);
        System.out.println(n);
        System.out.println(ch);
    }
}
