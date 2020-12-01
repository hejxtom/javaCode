package com.hejx_javaCore.senior.collectionpakage.set;

import org.junit.Test;

import java.util.*;

/**
 * @Classname SetTest
 * @Description TODO
 * @Date 2020/11/22 19:32
 * @Created by hejx
 *
 *  |----Collection接口: 单列集合，用来存储一个一个对象
 *      |----Set接口：存储无序的，不可重复的数据  -->高中讲的"集合"
 *         |---- HashSet: 作为Set接口的主要实现类;线程不安全的；可以存储null值
 *            |---- LinkedSet: 作为HashSet的子类，遍历其内部数据时，可以按照添加的数据去遍历
 *         |---- TreeSet: 可以按照添加对象的指定属性，进行排序
 *
 *
 * 1.Set接口中没有额外定义新的方法，使用的都是Collection中声明的方法
 *
 * 2.要求：向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
 *         重写的hashCode()和equals()方法尽可能保持一致：相等的对象必须具有相等的散列码
 *         重写两个方法小技巧：对象中用作equals()方法比较的Field,都应该用来计算hashCode值
 *
 *
 */
public class SetTest {
    /**
     * 一、Set: 存储无序的，不可重复的数据
     *    以HashSet为例说明：
     *      1.无序性:不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值排序的
     *
     *      2.不可重复性: 保证添加的元素按照equals()判断时，不能返回true.即：相同的元素只能添加一个
     * 二、添加元素的过程:
     *    以HashSet为例说明:
     *    我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
     *    此哈希值接着通过某种算法计算出HashSet底层数组中的存放位置(既为：索引位置)，
     *    判断数组此位置上是否已经有元素：
     *      如果此位置上没有其他元素，则元素a添加成功。 --->情况1
     *      如果此位置上有其他元素b(或以链表形式存在的多个元素)，则比较元素a与元素b的Hash值：
     *         如果Hash值不相同，则元素a添加成功。     ---->情况2
     *         如果hash值相同，进而需要调用元素a所在类的equlas()方法：
     *            equals()返回true,元素a添加失败
     *            equals()返回false,则元素a添加成功   -----> 情况3
     *
     *   对于添加成功的情况2和情况3而言：元素a与已经存在指定索引位置上数据以链表的方式存储:
     *   jdk 7：元素a放到数组中，指向原来的元素。
     *   jdk 8：原来的元素在数组中，指向元素a
     *   总结：七上八下
     *   HashSet底层：数组+链表的结构
     *
     *
     *
     */

    @Test
    public void test1(){
        Set set=new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",22));
        set.add(new User("Tom",22));
        set.add(129);
        set.add("abc");
        set.add("abc");

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

/**
 * LinkedHashSet的使用：
 *   LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据
 * 优点：
 *   对于频繁的遍历操作，LinkedHashSet效率要高于HashSet
 *
 */
    @Test
    public void test2(){
        Set set=new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",22));
        set.add(new User("Tom",22));
        set.add(129);
        set.add("abc");
        set.add("abc");

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    /**
     * 1.向TreeSet中添加的数据，要求是相同类的对象
     * 2.两种排序方式：自然排序 和 定制排序  -->更严格
     * 3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals().
     * 4.定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals().
     *
     *
     *
     */
    @Test
    public void test3(){
    Set set =new TreeSet();
    //不能添加不同类的对象
     /*   set.add(456);
        set.add(123);
        set.add("AA");
        set.add(new User("Tom",22));*/

     //举例一：
       /* set.add(34);
        set.add(-34);
        set.add(43);
        set.add(11);
        set.add(8);*/

        set.add(new User("Tom",22));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",12));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",55));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


    @Test
    public void test4(){
        //定制排序：
        Comparator comparator = new Comparator() {
            //按照年龄从小到大排序
            @Override
            public int compare(Object o1, Object o2) {
               if(o1 instanceof User && o2 instanceof User){
                   User u1=(User)o1;
                   User u2=(User)o2;
                   return Integer.compare(u1.getAge(),u2.getAge());
               }else {
                   throw new RuntimeException("输入的类型不匹配");
               }
            }
        };

        TreeSet set = new TreeSet(comparator);

        set.add(new User("Tom", 22));
        set.add(new User("Jerry", 33));
        set.add(new User("Jim", 12));
        set.add(new User("Mike", 65));
        set.add(new User("Jack", 33));
        set.add(new User("Jack", 55));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }



}
