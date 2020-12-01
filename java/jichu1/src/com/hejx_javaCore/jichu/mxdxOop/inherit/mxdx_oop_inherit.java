package com.hejx_javaCore.jichu.mxdxOop.inherit;
/**
 * 继承性
 *  好处：
 *     1.减少代码的冗余，提高了代码的复用性
 *     2.便于功能的扩展
 *     3.为多态性的使用，提供了前提
 *注意：
 *   1.一旦继承了父类，就会获取父类中声明的所有的属性和方法
 *   2.子类继承父类后，还可以定义特有的属性和方法
 *   3.一个类可以被多个子类继承（多态），一个类只能有一个继承
 *             （类与类之间单继承，类与接口之间是多实现，接口与接口之间是多继承）
 *   4.子父类是相对关系的（多层继承）
 *   5.子类直接继承的父类：直接父类；间接继承的父类称为：间接父类。
 *      子类继承父类以后，获取了所有的间接父类和直接父类的所有属性和方法。
 *
 */
public class mxdx_oop_inherit {
  public static void main(String[] args){
     Student1 student1=new Student1();
     student1.eat();
     student1.name="Marry";
     System.out.println(student1.getName());

     System.out.println("*****方法重写******");
     Student2 student2=new Student2();
     student2.setName("Jone");
     student2.mony();
   }
}


class Student1 extends Person3{
    //private  String name;
    //private int age;
    private String major;

    public Student1() {

    }

    public Student1(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void study(){
        System.out.println("人可以学习");
    }

}

class Person3{
    String name;
    int age;
    boolean isMale;
    static String phone;

    public void eat(){

        System.out.println("人可以吃");
    }

    void play(){
        System.out.println("人可以玩游戏");
    }

   public void mony(){
        System.out.println("人可以赚钱");
    }

}
/**
 * 方法的重写
 * 重写以后，当创建子类对象以后，通过子类对象调用子父类中的同名同参数的方法时，实际执行的是子类中的重写方法
 * 注意：
 *     1.子类中的叫重写方法，父类中的叫被重写的方法
 *     2.子类重写方法名与形参列表要与父类被重写方法的法名与形参列表相同
 *     3.子类重写方法的权限修饰符不小于父类被重写方法的权限修饰符
 *     *4.子类不能重写父类中声明为private权限的方法
 *     5.返回值类型：
 *        5.1 父类被重写方法的返回值是void,则子类重写的方法的返回值类型只能是void
 *        5.2 父类被重写的方法返回值类型是A类，则子类重写的方法的返回值类型可以是A类或A类的子类
 *        5.3 父类被重写的方法返回值类型是基本数据类型（如：int）,则子类重写的方法返回值类型也是基本数据类型（如：int）
 *     6.子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
 */
class Student2 extends Person3{
    //private  String name;
    //private int age;
    private String major;

    public Student2() {

    }

    public Student2(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void study(){
        System.out.println("人可以学习");
    }

   public void mony(){
        System.out.println(getName()+"可以赚钱");
    }

}
/**
 * 子类对象实例化的全过程
 * 1.从结果上来看：(继承性)
 *    子类继承父类以后，就获取了父类中声明的属性和方法
 *    创建子类的对象，在堆空间就会加载所有父类声明的以及自身的属性和方法
 *
 * 2.从过程上来看：
 *    当我们通过子类的构造器创建对象时，我们一定会直接或间接的调用其父类的构造器，进而调用父类的父类构造器...
 *    直到调用了java.lang.Object类中空参构造器为止。
 *    正因为加载到了所有父类的结构（属性和方法）,所以才可以看到内存中有父类的结构
 *注意：
 *    1.虽然创建子类对象时，调用了父类的构造器，但是自始至终就创建过一个对象
 *
 *
 */