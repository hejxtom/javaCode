package com.hejx_javaCore.senior.collectionpakage.set;

/**
 * @Classname User
 * @Description TODO
 * @Date 2020/11/23 18:59
 * @Created by hejx
 */
public class User implements Comparable{
    private String name;
    private int age;
    public User(){

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        System.out.println("User equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        System.out.println("User hashCode");
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //按照姓名从小到大,按年龄从小到大
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user =(User)o;
            int compare=-this.name.compareTo(user.name);
            if(compare !=0){
                return compare;
            }else {
                return Integer.compare(this.age,user.age);
            }
        }else {
            throw  new RuntimeException("输入的类型不匹配");
        }
    }
}
