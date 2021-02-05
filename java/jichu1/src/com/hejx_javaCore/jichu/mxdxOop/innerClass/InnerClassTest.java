package com.hejx_javaCore.jichu.mxdxOop.innerClass;
/**
 * 内部类
 *    1.Java允许将一个类A声明在类B中,则类A叫内部类,类B叫外部类
 *
 *    2.内部类的分类：
 *        1.成员内部类(静态、非静态)
 *            1.1 作为一个类：
 *               1.1.1 可以定义属性、方法、构造器等
 *               1.1.2 可以被final修饰，表示此类不能被继承
 *               1.1.3 可以被abstract修饰
 *            1.2 作为外部类的成员
 *               1.2.1 调用外部类的结构
 *               1.2.2 可以被static修饰
 *               1.2.3 可以被4种不同的权限修饰
 *
 *        2.局部内部类(方法内、代码块内、构造器内)(参见InnerClassTest1.java)
 *
 *
 *   当想要在外部类的静态成员部分使用内部类时，可以考虑内部类声明为静态的
 *
 */
public class InnerClassTest {
     public static void main(String[] args){
         /**
          *外部类访问成员内部类的成员，需要“内部类.成员”或“内部类对象.成员”的方式
          *
          */


         //实例化静态成员内部类的对象
         Person.Dog dog = new Person.Dog();
         dog.show();
         //实例化非静态成员内部类的对象
         Person person = new Person();
         Person.Bird bird = person.new Bird();
         bird.sing();
         System.out.println();
         bird.dispaly("黄鹂");
     }


}


class Person{
    String name="小明";
    static String name1="小明";
    int age;

    public void eat() {
        System.out.println("eat!");

    }

    public static void eat1() {
        System.out.println("eat1!");

    }


    public void method() {
        //局部内部类
        class AA {

        }
    }
     //在代码块里面的局部内部类
    {
        //局部内部类
        class BB {

        }
    }
   //在构造器中的内部类
    public Person() {
        //局部内部类
        class CC {

        }
    }

    //静态成员内部类
    static class Dog {  //只能调用外部类的静态变量和方法
        String name;
        int age;

        public  void show() {
            System.out.println("卡拉是条狗");
            Person.eat1();
            System.out.println(Person.name1);
        }

    }
/**
 *  非static的成员内部类中的成员不能声明为static的，只有在外部类或static的成员
 * 内部类中才可声明static成员
 *
 *
 */
    //非静态成员内部类
    class Bird {
        String name="杜鹃";

        public Bird() {
        }

        public void sing() {
            System.out.println("我是一只小小鸟");
            //调用外部类方法
            Person.this.eat();//省略写法：eat();
        }

        public void dispaly(String name){
            System.out.println(name);
            System.out.println(Person.this.name);//调用外部类成员变量
            System.out.println(this.name);

        }


    }

}