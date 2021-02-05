package com.hejx_javaCore.jichu.mxdxOop.interFace;
/**
 *  3.2 JDK8:除了定义全局常量和抽象方法之外,还可以定义静态方法、默认方法
 *
 *
 *
 * */
public class InterfaceTest2 {

    public static void main(String[] args){
        SubClass subClass=new SubClass();

        subClass.myMethod();

        //1.接口中定义的静态方法，只能通过接口来调用
        CompareA.method1();
        //subClass.method1();  //报错
        //2.通过实现类的对象,可以调用接口中的默认方法
        //3.如果子类(或实现类)继承的父类和实现的接口声明了同名同参数的方法，则默认调用父类的方法
        subClass.method2();
        //如果实现类重写了接口中的默认方法，调用时，调用的是重写以后的方法
        subClass.method3();
        /**
         * 4.如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法
         *    那么在实现类没有重写此方法的情况下，会报错，-->接口冲突
         *    此时就需要我们必须在实现类中重写此方法
         *
         */

    }

}

interface CompareA{
    //定义静态方法
    public static void method1(){
        System.out.println("CompareA:北京");
    }
    //定义默认方法
    public default void method2(){
        System.out.println("ComareA:上海");
    }

    default void method3(){
        System.out.println("CompareA:上海");
    }

}

class SupClass{
   public void method2(){
        System.out.println("SupClass:上海");
    }
}


class SubClass extends SupClass implements CompareA{
    public void method3(){
        System.out.println("SubClass:上海");
    }

    public void myMethod(){
        //实现类调用接口的默认方法
        CompareA.super.method2();
        //子类调用父类的方法
        super.method2();

    }

}
