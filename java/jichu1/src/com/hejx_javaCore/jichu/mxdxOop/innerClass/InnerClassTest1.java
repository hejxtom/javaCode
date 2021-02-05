package com.hejx_javaCore.jichu.mxdxOop.innerClass;
/**
 *  2.局部内部类(方法内、代码块内、构造器内)
 *
 *  2.1 只能在声明它的方法或代码块中使用，而且是先声明后使用。除此之外的任何地方
 * 都不能使用该类
 * 2.2 局部内部类可以使用外部方法的局部变量，但是必须是final的
 * 2.3 局部内部类和局部变量地位类似，不能使用public,protected,缺省,private
 * 2.4 局部内部类不能使用static修饰，因此也不能包含静态成员
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

        /**
         *  它的对象可以通过外部方法的返回值返回使用，返回值类型只能是局部内部类
         * 的父类或父接口类型
         *
         *
         */
        return new MyComparable();  //非匿名实现类，匿名对象
    }


}
