package com.hejx_javaCore.jichu.exception;
/**
 * 如何自定义异常类？
 *   1.继承现有的异常结构
 *   2.提供全局常量serialVersionUID序列号
 *   3.提供重载构造器
 *
 */
public class MyException extends RuntimeException {
    static final long serialVersionUID = -8034897190745766939L;

    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }
}
