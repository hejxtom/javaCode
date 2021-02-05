package com.hejx_javaCore.jichu.mxdxOop.keyword;
/**
 *
 * 关键字
 *
 */
public class mxdx_oop_keyword {
    public static void main(String[] args){
       System.out.println("******this关键字*********");
       System.out.println("******修饰属性******");
       Person1 person1=new Person1();
       person1.setAge(20);
       System.out.println(person1.getAge());
       System.out.println("******修饰方法******");
       person1.setName("Marry");
       person1.study();
       System.out.println("******修饰构造器******");
       Person1 person2=new Person1("Tom",2);
       Person1 person3=new Person1("Tom");

        System.out.println("******super关键字*********");
        Student3 student3=new Student3();
        student3.setName("Hejx");
        student3.show();
        System.out.println(student3.getName());
        System.out.println("***************");
        Student3 student=new Student3("Jorn",20,"M");
        System.out.println("通过super()调用父类构造器,给父类元素赋值："+student.getAge()+","+student.getName());

    }
}
/**
 *
 * this关键字
 *     1.可以用来修饰：属性、方法、构造器
 *     2.this修饰属性和方法：
 *       this理解为：当前对象
 *     3.this修饰构造器：
 *       3.1 我们可以在类的构造器中，可以显式的使用"this(形参列表);",调用本类中其他构造器
 *       3.2 构造器中不能通过"this(形参列表);"调用自己（不能递归回调）
 *       3.3 "this(形参列表);"必须放在方法内首行
 *
 */

class Person1{
     private String name;
     private int age;

     public Person1(){}
     //this修饰构造器
     public Person1(String name){
         this.name = name;
         this.eat();
     }

     public Person1(String name,int age){
         //必须放在方法内首行
         this(name);
         this.name=name;
         this.age=age;

     }


    public String getName() {
        return name;
    }
    //this修饰成员变量
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //this修饰方法
    //方法里面可以"this.成员变量名"和"this.方法名"
    void eat(){
        System.out.println(this.name+"可以吃饭");
    }
   void study(){
       System.out.println("人可以学习");
        this.eat();
   }
/**
 * package关键字
 *    同一个包下，不能命名同名的接口、类
 *
 *
 *
 */

}

/**
 * super关键字
 *      super可以用来调用：属性、方法、构造器
 *
 *注意：
 *   1.当子类和父类定义了同名的属性或者相同的方法，必须显示"super."
 *   2.在构造器的首行，没有显式的声明"this(形参列表)"或"super(形参列表)"，则默认调用的是父类中的空参构造器：super()
 *   3."super(形参列表)"的使用，必须声明在子类构造器的首行！
 *   4.在类构造器中，针对"this(形参列表)"或"super(形参列表)"只能二选一，不能同时出现
 *   5.在类的构造器中，至少有一个类的构造器中使用"super(形参列表)"，调用父类的构造器
 */


class Person4{
    private String name="Marry";
    private int age;

    public Person4(){}
    //this修饰构造器
    public Person4(String name){
        this.name=name;
        this.eat();
    }
    public Person4(int age){
     this.age=age;
}

    public Person4(String name,int age){
        //调用本类的其他构造器
       // this(name);
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

    void eat(){
        System.out.println(this.name+"可以吃饭");
    }
    void study(){
        System.out.println("人可以学习");
        this.eat();
    }
}

class Student3 extends Person4{

    private String name="Tom";

    String major;

    public   Student3(){}

    //super修饰构造器
    public Student3(String name,int age,String major){
        //调用父类的构造器
              super(name, age);
               this.name=name;
              this.major=major;

    }

    /*public String getName() {
        return name;
    }*/

    /*public void setName(String name) {
        this.name = name;
    }*/

    void eat(){
        System.out.println("人可以吃饭!");
    }
    void study(){
        System.out.println("人可以学习!");
    }

    public void show(){
        //super修饰属性
        System.out.println("this.name:"+this.getName()+","+"super.name:"+super.getName());
        //super修饰方法
       this.eat();
       super.eat();

    }
}

/**
 *static 关键字
 * 使用：
 *     static可以修饰:属性、方法、代码块、内部类
 * static可以修饰属性,注意：
 *   1.静态变量随着类的加载而加载
 *   2.静态变量的加载要早于对象的创建
 *   3.由于类只会加载一次，则静态变量在内存中也只会存在一份，存在方法区的静态域中
 *
 * static可以修饰方法,注意：
 *   1.静态方法随着类的加载而加载
 *   2.静态方法中，只能调用静态的方法和属性
 *     非静态方法中,既可以调用非静态的方法或属性，也可以调用静态的方法和属性
 *   3.在静态方法内，不能使用this关键字、super关键字
 *
 *开发中，如何确定一个属性是否要声明为static的？
 *   1.属性是可以被多个对象所共享的，不会随着对象的不同而不同
 *
 *开发中，如何确定一个方法是否要声明为static的？
 *   1.操作静态属性的方法,通常设为static
 *   2.工具类中的方法习惯声明为static
 *
 *
 *
 *
 */
class mxdx_oop_keyword_static{

   public static void main(String[] args){
       Chinese chinese = new Chinese();
       //非静态变量(实例变量)调用：对象.变量名
       chinese.age = 20;
       chinese.name = "Tom";
       //静态变量(类变量)调用：类.变量名 或 对象.变量名
       Chinese.isChinese = true;
       chinese.isChinese = false;
       System.out.println(Chinese.isChinese);


       //非静态方法的调用：对象.方法名
       chinese.eat();
       //静态方法的调用：类.方法名 或 对象.方法名
       chinese.speak();
       Chinese.speak();
   }


}

class Chinese{

    String name;
    int age;
    static boolean isChinese;

    public void eat(){
        System.out.println("中国人吃中餐");
        speak();
    }


    public static void speak(){
        System.out.println("中国人说普通话");

    }


}

/**
 * final(最终的)关键字
 * 1.final关键字可以修饰：类、方法、变量
 *   1.1 用来修饰类:此类就不能被其他类所继承，例如：String类、System类、StringBuffer类
 *   1.2 用来修饰方法：表明此方法不可以被重写，例如：Object类中getClass();
 *   1.3 用来修饰变量：此时的"变量"就是常量
 *       修饰属性,可以考虑的赋值位置（或方式）：显式初始化、代码块中赋值、构造器中初始化
 *       修饰局部变量:
 *         final修饰形参时,表明此形参是一个常量。
 *         当我们调用此方式，给常量形参赋值以后，就只能在方法体内使用，但不能重新赋值
 *
 *
 * static final: 用来修饰属性：全局常量
 *               用来修饰方法
 *
 */
class keyword_final {
    public static void main(String[] args) {
        char[] arr = new char[] { 'a', 'b', 'c' };
        System.out.println(arr);

        int[] arr1 = new int[] { 1, 2, 3 };
        System.out.println(arr1);

        double[] arr2 = new double[] { 1.1, 2.2, 3.3 };
        System.out.println(arr2.toString()+" "+arr2.hashCode());
    }
}

final  class FinalA {

}


/**
 * abstract(抽象的)：
 *      abstract可以用来修饰的结构：类、方法
 *
 *abstract修饰类：抽象类
 *     1.此类不能被实例化
 *     2.此类一定有构造器
 *
 *abstract修饰方法：抽象方法
 *     1.抽象方法只有方法的声明，没有方法体
 *     2.若子类重写了父类的所有抽象方法以后，此子类方可实例化
 *       若子类没有重写父类的所有抽象方法，则此子类也是抽象类
 *
 *注意：
 *   1.抽象类不一定含有抽象方法，有抽象方法的类一定是抽象类
 *   2.abstract不能修饰：变量、属性、构造器等结构，不能修饰：私有方法、静态方法、final的方法、final的类
 *   3.
 *
 */
class mxdx_oop_abstract{
    public static void main(String[] args) {
        //Student4 student4 = new Student4();
        //多态
        PenSon student4 = new Student4();
        student4.eat();

    }

}
//抽象类
abstract class PenSon{
    String name;
    int age;

    public PenSon() {
    }

    public PenSon(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //抽象方法
    public abstract void eat();

}

class Student4 extends PenSon{
    //继承抽象类，就要实现他的抽象方法
    public Student4(){}
    @Override
    public void eat() {
        System.out.println("人可以吃饭");
    }
}

/**
 * 抽象类的匿名子类
 *
 *
 *
 */
class PenSon1{
  public static void main(String[] args) {
      Student4 student4=new Student4();
      method(student4);   //非匿名的子类，非匿名的对象
      method(new Student4());//非匿名的子类，匿名的对象

      //创建了一个匿名的子类对象：penSon
      PenSon penSon=new PenSon() {
          @Override
          public void eat() {
              System.out.println("人可以吃饭!!!");
          }
      };
      method(penSon);//匿名的子类，非匿名的对象

      method(new PenSon() {
          @Override
          public void eat() {
              System.out.println("人可以吃饭!!");
          }
      });  //匿名的子类，匿名的对象



  }

  public static void method(PenSon penSon){
      penSon.eat();

  }

}
