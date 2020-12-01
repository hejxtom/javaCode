package com.hejx_javaCore.jichu.mxdxOop;
/**
 *  java面向对象学习的三条主线
 *  1.java类及类的成员：属性、方法、构造器;代码块、内部类
 *  2.面向对象的三大特征：封装性、继承性、多态性（、抽象性）
 *  3.其他关键字:
 *      return:
 *         1.结束方法
 *         2.返回指定的数据
 *         3.return关键字后面不可以声明语句。
 *
 *
 *
*/
public class mxdx_oop {

 public static void main(String[] args){
        //创建类的对象（类的实例化）
         Person person=new Person();
         person.setName("Tom");
         System.out.println("getName:"+person.getName());
         person.eat();
         System.out.println("age默认值："+person.age);


     System.out.println("*****变量调用*****");
        //实例变量的调用：对象.变量名
        person.name="Tom";
        System.out.println(person.name);
        //类变量的调用：类.变量名/对象.变量名
        Person.phone="13872850708";
        System.out.println(Person.phone);

        System.out.println("*****匿名对象*****");
        new Person().play();

        System.out.println("*****方法调用*****");
        person.setName("Tom");
        System.out.println("getName:"+person.getName());


    }

}

class Person{
/**
 * 属性（成员变量：field）：实例变量、类变量
 * 几点注意：
 *     1.可以在声明属性时，指明其权限，使用权限修饰符：private\public\protected\缺省
 *     2.有默认初始化值
 *     3.加载到堆空间（非static）
 */

  String name;
  int age;
  boolean isMale;
  static String phone;

/**
 * 方法（成员方法:method）：方法在栈里面
 *      局部变量：
 *          几点注意：
 *            1.不可以使用权限修饰符
 *            2.没有默认初始化值
 *            3.加载到栈空间
 */

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(){

        System.out.println("人可以吃");
    }

    void play(){
        System.out.println("人可以玩游戏");
    }

    void mony(){
        System.out.println("人可以赚钱");
    }
}
/**
 * 方法的重载:
 *   定义：
 *    在同一个类中，允许存在一个以上的同名方法，只要它们的参数列表（参数类型、参数个数）不同即可
 *判断是否是重载：
 *    跟方法的权限修饰符、返回值类型、形参变量名、方法体都没有关系！
 *
 *
 * 形参个数可变的方法
 * 需要注意：
 *    1.可变的参数可以传0个及0个以上
 *    2.phone(String...strs)与 phone(String[] strs)是一样的参数列表
 *    3.形参个数可变的方法与本类中方法名相同，构成了重载
 *    4.可变个数的形参，必须声明在末尾，且最多只能声明一个可变形参
 *
 * 方法值传递机制
 *    同一方法：
 *        如果变量是基本数据类型，此时赋值是变量所保存的值
 *        如果变量是引用数据类型，此时赋值的是变量所保存的地址值
 *    不同方法（形参）：
 *        如果实参是基本数据类型，此时赋值给形参是实参所保存的值
 *        如果实参是引用数据类型，此时赋值给形参是实参所保存的地址值
 *
 *
 * 递归方法
 */

//形参个数可变的方法
class MethodArgs{

    public static void main(String[] args){
        //可变的参数可以传0个及0个以上
        new MethodArgs().phone(1.2,"hello","hello1","slq","1");
        new MethodArgs().phone(1.2);

        new MethodArgs().phone("hello","hello1","slq","1");
    }
    //jdk1.5以前
    public void phone(int n,String[] strs){}

    //jdk1.5及以后
    //可变个数的形参，必须声明在末尾
    public void phone(double d,String...strs){
        for(int i = 0;i < strs.length;i++)
               System.out.println(strs[i]);
    }

    public void phone(String...strs){
        for(int i = 0;i < strs.length;i++)
            System.out.println(strs[i]);
    }

}

//递归方法
class  recursion{
    public static void main(String[] args){
       recursion recursion=new recursion();
        System.out.println(recursion.JieCheng(10));
        System.out.println(recursion.fun(10));
    }

    public int JieCheng(int n){
        if(n==1)return 1;
        else return n*JieCheng(n-1);
    }

    //斐波那契数列
    public  int fun(int n){
        if(n==0)return 1;
        else if(n==1)return 1;
        else return 2*fun(n-1)+fun(n-2);

    }
}



