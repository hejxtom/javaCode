package com.hejx_javaCore.jichu.exception;

import org.junit.Test;

/**
 *  一、异常的体系结构
 *  java.lang.Throwable
 *       |------java.lang.Error :一般不编写针对性的代码进行处理
 *       |------java.lang.Exception ：可以进行异常的处理
 *          |------编译时异常(checked)
 *          |------运行时异常(unchecked)
 *
 *异常处理方式一：
 *  1.try-catch-finally
 *    1.1 使用try将可能出现异常代码包装起来，在执行过程中，
 *        一旦出现异常，就会生成一个对应的异常类对象，根据此对象，去catch中处理
 *
 *    1.2 一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常处理，
 *        一旦处理完成，就跳出当前try-catch结构，继续执行其后的代码
 *
 *    1.3  catch中的异常结构如果没有子父类关系，则无需考虑顺序
 *         catch中的异常结构如果满足子父类关系，则要求子类一定声明在父类的上面，否则报错
 *
 *    1.4 在try中定义的变量属于局部变量，属于try
 *
 *    1.5 finally中的信息一定会被执行
 *
 *
 *
 *
 *
 */
public class ExceptionTest {

    @Test
    public void test1(){
        String str = "123";
        str = "abc";
        int num;
        try {
            //系统自动生成异常类对象
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {//NumberFormatException:数值转换异常
            //打印错误1：
            System.out.println(e.getMessage());
            //打印错误2(常用)：
            // e.printStackTrace();
        }catch (Exception e){

        }finally {
            //一定会执行
            System.out.print("finally....");
        }
    }

    
    //面试题：return的考察
    @Test
    public void testMethod(){
          System.out.println(method());
    }

    public  int method(){
         try{
             int arr[]=new int[10];
             System.out.println(arr[10]);
             return 1;
         }catch (Exception e){
            e.printStackTrace();
             return 2;
         }finally {
             System.out.println("我一定会被执行");
             return 3;
         }
    }


}
