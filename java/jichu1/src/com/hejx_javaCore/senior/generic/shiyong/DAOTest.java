package com.hejx_javaCore.senior.generic.shiyong;

import org.junit.Test;

/**
 * @Classname DAOTest
 * @Description TODO
 * @Date 14:26 2021/1/26
 * @Created by hejx
 */

public class DAOTest {

    @Test
    public void test(){
        CustomerDAO dao1=new CustomerDAO();
        dao1.add(new Customer());

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.add(new Student());


    }


}
