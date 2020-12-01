package com.hejx_javaCore.jichu.mxdxOop.jurisdiction;
/**
 * 封装性
 * 权限修饰符(从小到大)：private\缺省（default）\protected\public
 * 注意：
 *     1. 4种权限修饰符可以用来修饰：属性、方法、构造器、内部类
 *        1.1 修饰外部类只能用缺省、public
 */
 class mxdx_oop_jurisdiction {
    public static void main(String[] args){
      Student student=new Student("Tom",20);
      student.setName("Marry");
      System.out.println("name:"+student.getName()+",age:"+student.getAge());
    }

}
/**
 * 构造器
 *作用：
 *   1.创建对象
 *   2.初始化对象的信息（行为（方法）、属性）
 *注意：
 *   1.如果没有显式的定义类的构造器的话，系统默认提供一个无参构造器,默认构造器的修饰符与所属类的修饰符一致
 *   2.一个类中定义的多个构造器，彼此构成重载
 *   3.一旦显式定义构造器，系统不再提供空参构造器
 */
class Student{
    private String name;
    private int age;

    //无参构造器
    public Student(){}
    //有参构造器
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

     private class A{}

}


/**
 * 代码块:
 *   1.代码块如果有修饰的话，只能用static
 *
 *分类：
 *    1.静态代码块
 *       1.1 内部可以有输出语句
 *       1.2 随着类的加载而执行，只会执行一次
 *       1.3 作用：可以在类的加载时，对静态变量进行初始化
 *
 *    2.非静态代码块
 *       1.1 内部可以有输出语句
 *       1.2 随着类的对象的创建而执行，每创建一个对象就执行一次
 *       1.3 作用：可以创建对象时，对对象的属性进行初始化
 *
 * 对属性可以赋值的位置：
 *     1.默认初始化
 *     2.显式初始化
 *     3.构造器初始化
 *     4.有了对象，可以通过"对象.方法"或"对象.方法"的方式,进行赋值
 *     5.在代码块中赋值
 *  执行的先后顺序：1->2/5->3->4
 *
 *
 */
class CodeBlockTest{
    public static void main(String[] args) {
        Chinese1 chinese1=new Chinese1();
        System.out.println(Chinese1.desc);
       System.out.println(chinese1.age);
    }
}

class Chinese1{
    String name;
    int age;
    static String desc="我是一个中国人";

    public Chinese1() {
    }

    public Chinese1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //方法
    public void eat(){
        System.out.println("中国人吃中餐");
    }

    //代码块
    static {
        desc="我是一个爱学习的中国人";
        System.out.println("hello static block!");
    }

    {
        age=20;
        System.out.println("hello block!");
    }

    @Override
    public String toString() {
        return "Chinese1 [" +
                "name='" + name + '\'' +
                ", age=" + age +
                ']';
    }
}