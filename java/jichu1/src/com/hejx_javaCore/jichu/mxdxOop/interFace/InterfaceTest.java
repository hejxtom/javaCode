package com.hejx_javaCore.jichu.mxdxOop.interFace;

/**
 * 接口的使用：
 *    1.接口使用interface定义
 *
 *    2.java中，接口和类是并列的结构
 *
 *    3.定义接口中的成员
 *       3.1 JDK7及以前：只能定义全局常量和抽象方法
 *           >全局常量：public static final的
 *           >抽象方法：public abstract的
 *
 *       3.2 JDK8:除了定义全局常量和抽象方法之外,还可以定义静态方法、默认方法(参见：InterfaceTest2.java)
 *
 *    4.接口不能定义构造器，意味着接口不可以实例化
 *
 *    5.Java开发中，接口通过让类去实现(implements)的方式来使用
 *      如果实现类覆盖了接口的所有抽象方法，则此类可以被实例化
 *      如果实现类没有覆盖接口的所有抽象方法，则此类(是个抽象类)不能被实例化
 *
 *    6.Java类可以实现多个接口  -->弥补了Java单继承性的局限性
 *
 *    7.接口与接口之间可以多继承
 *
 *    8.接口其实是定义了一种规范
 *
 * 面试题：抽象类与接口有哪些异同？
 *
 */
public class InterfaceTest {
  public static void main(String[] args){
      System.out.println(Flyable.MAX_SPEED);//接口名.常量名
      //接口的多态性
      Flyable flyable = new Plane();
      flyable.fly();
      flyable.stop();

      System.out.println("*****匿名实现类******");
      //匿名实现类,非匿名对象
      Flyable flyable1=new Flyable() {
          @Override
          public void fly() {
              System.out.println("通过引擎正推");
          }

          @Override
          public void stop() {
              System.out.println("通过引擎反推");
          }
      };

      Plane1.USB(flyable1);

  }

}


interface Flyable{
    //全局常量
    public static final int MAX_SPEED = 7900;
    int i = 0; //默认省略 public static final

    //抽象方法
    public abstract void fly();
    void stop(); //默认省略 public abstract
}

interface Attackable{
    void attack();
}


class Plane implements Flyable{

    @Override
    public void fly() {
         System.out.println("通过引擎");
    }

    @Override
    public void stop() {
         System.out.println("驾驶员减速停止");
    }
}

class Bullet implements Flyable,Attackable{

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }
}

class  Plane1{

    public static void USB(Flyable flyable){
        flyable.fly();
        flyable.stop();
    }

}






