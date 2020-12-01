package com.hejx_javaCore.senior.collectionpakage;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Classname IteratorTest
 * @Description TODO
 * @Date 2020/11/11 17:17
 * @Created by hejx
 *
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部方法：hasNext() 和 next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 * 默认游标都在集合的第一个元素之前
 * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素，此方法不同于集合直接remove()
 *
 *
 *
 *
 */
public class IteratorTest {

    @Test
    public void test3(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);


        //利用remove()删除tom数据
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            if("Tom".equals(next)){
                iterator.remove();
            }
        }

        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext())
            System.out.println(iterator1.next());



    }



    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //错误写法一：
      /*  Iterator iterator = coll.iterator();
        while((iterator.next())!=null){
            System.out.println(iterator.next());
        }*/
       //错误写法二：
       /*while(coll.iterator().hasNext()){
           System.out.println(coll.iterator().next()); //死循环
       }*/

    }


    @Test
    public  void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //推荐：
        //hasNext():判断是否还有下一个元素
        while (iterator.hasNext())
            //next():1.指针下移 2.将下移以后集合位置上的元素返回
            System.out.println(iterator.next());

        //不推荐
        /*for(int i=0;i<coll.size();i++)
            System.out.println(iterator.next());*/

    }



}
