package com.hejx_javaCore.senior.generic.generic1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Classname GenericTest
 * @Description TODO
 * @Date 11:05 2021/1/27
 * @Created by hejx
 *
 *
 * 1.泛型在继承方面的体现
 *
 *
 * 2.通配符
 *
 *
 *
 */

public class GenericTest {
/**
 * 1.泛型在继承方面的体现
 *  类A是类B的父类，G<A>和G<B>二者不具有子父类关系，二者是并列的关系
 *  补充：类A是类B的父类，A<G>和B<G>二者具有子父类关系
 *
 */
@Test
public void test1(){
    List<Object> list1=null;
    List<String> list2= new ArrayList<>();
    //此时的list1与list2的类型不具有子父类关系
    //list1=list2; //编译错误

    /**
     *
     *  反证法：
     *  假设：list1=list2; 成立
     *  list1.add(123)成立；导致混入非String类型数据。-->出错
     *
     *
     */

}

    public void test2() {
        List<String> list1 = null;
        ArrayList<String> list2 = null;
       //此时的list1与list2的类型具有子父类关系
        list1 = list2;


    }

    /** 2.通配符
     * 通配符：?
     *
     *
     *
     *
     */
    @Test
    public void test3(){
        List<Object> list1=null;
        List<String> list2= new ArrayList<>();

        //类A是类B的父类，G<A>和G<B>二者不具有子父类关系，二者是并列的关系.二者共同的父类是：G<?>
        List<?> list=null;
        list=list1;
        list=list2;

        List<String> list3 = new ArrayList<>();
        list3.add("AAA");
        list3.add("BBB");
        list3.add("CCC");
        list3.add("DDD");
        list = list3;
        //添加：对于List<?>就不能向其内部添加数据，除了添加null
        //list.add("AAA");    //编译错误
        list.add(null);

        //获取
        Object o = list.get(0);
        System.out.println(o);
    }

    public void printf(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();

        }
    }

    /**3.有限制条件的通配符的使用
     *   ? extends A:
     *            G<? extends A> 可以作为G<A>和G<B>的父类的，其中B是A的子类
     *    ? super A:
     *            G<? super A> 可以作为G<A>和G<B>子类的，其中B是A的父类
     *
     *
     *
     *
     */

    public void test4(){

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();


        list1 = list3;
        list1 = list4;
        // list1=list5;

        list2 = list4;
        list2 = list5;
        //list2=list3;

        //读数据
        list1=list3;
        Person person = list1.get(0);

        list2=list4;
        Object object = list2.get(0);

        //写数据

        //list1.add(new Student()); //编译错误

        //运行通过
        list2.add(new Person());
        list2.add(new Student());


    }


}
