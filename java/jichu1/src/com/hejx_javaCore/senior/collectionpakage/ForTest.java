package com.hejx_javaCore.senior.collectionpakage;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Classname ForTest
 * @Description TODO
 * @Date 2020/11/13 20:32
 * @Created by hejx
 */
public class ForTest {
    public static void main(String[] args) {
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合元素的类型 局部变量：集合对象)
        //内部仍然调用了Iterator迭代器
        for(Object obj :coll)
            System.out.println(obj);
        

    }




}
