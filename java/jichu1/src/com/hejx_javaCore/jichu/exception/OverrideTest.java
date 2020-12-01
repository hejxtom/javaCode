package com.hejx_javaCore.jichu.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 方法重写对异常类型的要求：
 *     1.子类重写的方法抛出的异常类型不大于父类被重写方法抛出的异常类型
 *
 */
public class OverrideTest {

    public static void main(String[] args){
        OverrideTest overrideTest=new OverrideTest();
        overrideTest.dispaly(new SubClass());
    }


    public void dispaly(SuperClass s){

        try {
            s.method();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

class SuperClass{
     public void method()throws IOException{

     }

}

class SubClass extends SuperClass{

    public void method()throws FileNotFoundException {

    }

}