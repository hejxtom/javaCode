package com.hejx_javaCore.senior.commonclass.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname CompareTest
 * @Description TODO
 * @Date 2020/9/29 19:07
 * @Created by hejx
 *
 * 一、说明：Java中的对象，正常情况下，只能进行比较： == 或 ！=。不能使用 > 或 < 的
 *     如何实现对java对象的排序？使用两个接口中的任何一个：Comparable 或 Comparator
 *
 */
public class CompareTest {
    /**
     *
     * Comparable接口的使用举例
     * 1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小
     * 2.像String、包装类重写compareTo(obj)方法以后，进行了从小到大排列
     * 3.重写compareTo(obj)的规则：
     *      如果当前对象this大于形参对象obj,则返回正整数；
     *      如果当前对象this小于形参对象obj,则返回负数；
     *      如果当前对象this等于形参对象obj,则返回零
     *4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法，在compareTo(obj)方法中指明如何排序
     *
     *
     */
    @Test
    public void test1(){
        String[]  arr=new String[]{"AA","CC","MM","GG","JJ","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //实现Comparable接口,重写compareTo(obj)的规则
    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 34);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Comparator接口的使用：定制排序
    @Test
    public void test3(){
        String[]  arr=new String[]{"AA","CC","MM","GG","JJ","DD"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                 String s1= (String) o1;
                 String s2= (String) o2;
                 //按照字符串从大到小排序
                 return -s1.compareTo(s2);
                }
                throw  new RuntimeException("传入的数据类型不一致！");
                //return 0;
            }
        });

        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test4(){
        Goods1[] arr = new Goods1[5];
        arr[0] = new Goods1("lenovoMouse", 34);
        arr[1] = new Goods1("dellMouse", 34);
        arr[2] = new Goods1("xiaomiMouse", 12);
        arr[3] = new Goods1("huaweiMouse", 65);
        arr[4] = new Goods1("huaweiMouse", 35);
        Arrays.sort(arr, new Comparator() {
            //指明商品比较大小的方式：按照按照产品名称从低到高排序，再价格从低到高排序
            @Override
            public int compare(Object o1, Object o2) {
              if(o1 instanceof Goods1 && o2 instanceof Goods1) {
                  Goods1 g1= (Goods1) o1;
                  Goods1 g2= (Goods1) o2;
                  if(g1.getName().equals(g2.getName())){
                      return Double.compare(g1.getPrice(),g2.getPrice());
                  }else{
                      return g1.getName().compareTo(g2.getName());
                  }

              }
               // return 0;
                throw  new RuntimeException("传入的数据类型不一致！");
            }
        });

        System.out.println(Arrays.toString(arr));
    }


}
