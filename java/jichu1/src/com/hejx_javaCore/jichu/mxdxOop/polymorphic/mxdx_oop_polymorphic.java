package com.hejx_javaCore.jichu.mxdxOop.polymorphic;
/**
 * 多态：一种事物的多种形态
 *   何为多态性：
 *       父类的引用指向子类的对象（或：子类的对象赋给父类的引用）
 *
 *多态的使用：虚拟方法调用
 *   有了对象的多态性，编译阶段，只能调用父类的结构;运行期间，我们实际执行的是子类的结构
 *
 *多态性使用的前提: 1.继承;2.要有方法的重写
 *
 * 对象的多态性，只适用于方法，不适用于属性（编译运行都看左边）
 *
 *
 */
public class mxdx_oop_polymorphic {

     public static void main(String[] args){
         System.out.println("******多态******");
         //对象的多态性
         Person5 person5=new Man();
         person5.mony();
         Person5 person51=new Woman();
         person51.mony();

         System.out.println("******多态应用******");
         func(new Man());

         System.out.println("******不适用于属性******");
        System.out.println(person5.age);

         System.out.println("******instanceof******");
         func1(person5);

     }

     public static void func(Person5 person5){
         person5.mony();
     }

    /**问题：
     * 有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法，但是由于变量声明的是父类类型
     * 导致，只能调用父类的结构（属性和方法），如何调用子类特有的结构呢？
     */
    /**
     * instanceof
     * 使用：
     *    a instanceof A:判断对象a是否是类A的实例。如果是，返回true;如果不是，返回false。
     * 使用情景：
     *    为了避免在向下转型时使用强制转换，出现ClassCastException异常，使用instanceof判断
     *
     */
    public static void func1(Person5 person5){

        if(person5 instanceof Man){
            Man m=(Man)person5;
            m.study();
            m.isMan=true;
            System.out.println(m.isMan);
        }
       //若 a instanceof A为true,a instanceof B为true，则B类是A类的父类
        if(person5 instanceof Person5)
            System.out.println("person5 instanceof Person5->true");
    }
    
}



class Person5{
    String name;
    int age=20;
    public void eat(){
        System.out.println("人可以吃饭");
    }


    public void mony(){
        System.out.println("人可以赚钱");
    }

  }

  class  Man extends  Person5{
      int age=21;
      boolean isMan;
    public void mony(){
      System.out.println("男人负责挣钱养家！");
    }
      public void study(){
          System.out.println("人可以学习");
      }
  }

class  Woman extends  Person5{

    public void mony(){
        System.out.println("女人负责貌美如花！");
    }
    public void study(){
        System.out.println("人可以学习");
    }
}

