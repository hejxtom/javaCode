package com.hejx_javaCore.jichu.basics;


/**
 * java.lang.Object类
 * 1.Object类是所有Java类的根父类
 * 2.如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类
 *
 *
 *
 */
public class ObjectTest {
    public static void main(String[] args) {
        Order order = new Order();
        //.getClass().getSuperclass() 获取父类
        System.out.println(order.getClass().getSuperclass());
    }

}


class Order{
    private int id;
    private String name;

    public Order() {
    }

    public Order(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //重写equals()方法：比较实体内容是否相等
   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (o instanceof Order) {
            Order order = (Order) o;
             return this.name.equals(order.name) && this.id == order.id;
        }
        return false;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return this.getId() == order.getId() &&
                this.getName().equals(order.getName());
    }

    @Override
    public String toString() {
        return "Order[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ']';
    }
}

/**
 *== 和 equals() 的区别
 *==运算符的使用：
 *   1.可以使用在基本数据类型变量和引用数据类型变量中
 *   2.如果比较的是基本数据类型：比较两个变量保存的数据是否相等(不一定要类型相同)
 *     如果比较的是引用数据类型：比较两个对象的地址值是否相同,即两个引用是否指向同一个对象实体
 *
 * equals()方法的使用：
 *   1.只能适用于引用数据类型
 *   2.Object类中equals()方法的定义：比较两个对象的地址值是否相同,即两个引用是否指向同一个对象实体
 *   3.像String\Date\File\包装类等都重写了Object类中equals()方法,比较的是实体内容是否相等
 *
 */
class EqualsTest{
    public static void main(String[] args) {
        System.out.println("********==运算符*******");
        System.out.println("******基本数据类型*****");
        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j);
        System.out.println(i == d);

        System.out.println("******引用数据类型*****");
        Order order = new Order(22, "Tom");
        Order order1 = new Order(22, "Tom");
        Order order2 = order;
        System.out.println(order == order1);  //false
        System.out.println(order == order2);  //true

        System.out.println("*******equals()方法********");
        System.out.println(order.equals(order1));
        System.out.println(order.equals(order2));

        System.out.println("***String\\Date\\File\\包装类等都重写了Object类中equals()方法***");
        String str = new String("abc");
        String str2 = new String("abc");
        System.out.println(str==str2);
        System.out.println(str.equals(str2));
    }

}

/**
 * toString()方法：返回地址值
 *  像String\Date\File\包装类等都重写了Object类中toString()方法，返回的是实体内容
 *
 *
 */
class ToStringTest{
    public static void main(String[] args) {

        Order order= new Order(22, "Tom");
      /* System.out.println(order+"\norder.toString():"+ order.toString()+
                                 "\norder.hashCode():"+order.hashCode()+
                                  "\norder.getClass():"+order.getClass());*/

        System.out.println(order.toString());
    }



}