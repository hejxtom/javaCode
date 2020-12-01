package com.hejx_javaCore.jichu.mxdxOop.innerClass;
/**
 *  2.局部内部类(方法内、代码块内、构造器内)
 *
 *
 *
 */
public class InnerClassTest1 {

    //返回一个实现Comparable接口类的对象
    public Comparable getComparable() {
        //创建一个实现Comparable接口的类：局部内部类
        class MyComparable implements Comparable {

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        return new MyComparable();  //非匿名实现类，匿名对象
    }


}
