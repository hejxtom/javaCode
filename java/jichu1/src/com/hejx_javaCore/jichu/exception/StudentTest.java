package com.hejx_javaCore.jichu.exception;
/**
 *关于异常的产生：
 *    1.系统自动生成异常类对象
 *    2.手动生成一个异常类对象，并抛出(throw)
 *
 *
 *
 *
 */
public class StudentTest {

    public static void main(String[] args){
        Student student=new Student();
        student.regist(-1001);

    }

}
class Student{
    private int id;
    public void regist(int id){
         if(id>0)
             this.id=id;
         else
             //手动抛出异常对象
             throw new MyException("输入的数据非法！");
    }

    @Override
    public String toString() {
        return "Student[" +
                "id=" + id +
                ']';
    }
}