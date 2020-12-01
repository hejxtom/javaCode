package com.hejx_javaCore.senior.enum1;

/**
 * @Classname SeasonTest
 * @Description TODO
 * @Date 2020/10/8 17:32
 * @Created by hejx
 *
 * 一、枚举类的使用
 * 1.枚举类的理解： 类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类只有一个对象，则可以作为单例模式的实现
 *
 * 二、如何定义枚举类
 *  方式一：jdk5.0之前，自定义枚举类
 *  方式二：jdk5.0,可以使用enum关键字定义枚举类
 *
 *
 * 三、 Enum类中的常用方法：
 *     values()方法： 返回枚举类型的对象数组。该方法可以很方便的遍历所有的枚举值
 *     valueof(String str): 可以把一个字符串转化为对应的枚举类对象。
 *
 *
 * 四、 使用enum关键字定义的枚举类实现接口的情况
 *    情况一： 实现接口，在enum类中实现抽象方法
 *    情况二： 让枚举类的对象分别实现接口中的抽象方法
 */
public class SeasonTest {
    public static void main(String[] args) {
        //jdk5.0之前，自定义枚举类
        System.out.println(Season.SPRING.getSeasonName());

       //jdk5.0,可以使用enum关键字定义枚举类
        System.out.println(Season_Enum.SUMMER.getSeasonDesc());

       //***********************
       //values()方法：
        Season_Enum[] values = Season_Enum.values();
        for (Season_Enum season_enum:values) {
            System.out.println(season_enum);
        }
        //valueof(tring objName)方法：根据objName,返回枚举类中对象名是objName的对象
        Season_Enum winter = Season_Enum.valueOf("WINTER");
        System.out.println(winter.getSeasonName());

        winter.show();


    }

}

interface Info{
    void show();
}


//jdk5.0之前，自定义枚举类
class Season{
    //2.声明Season对象的属性
   private final String seasonName;
   private final String seasonDesc;

    //1.私有化类的构造器
    private Season(String seasonName,String seasonDesc){
       this.seasonName=seasonName;
       this.seasonDesc=seasonDesc;
    }

    //3.提供当前枚举类的多个对象
    public static final Season SPRING=new Season("春天","春暖花开");
    public static final Season SUMMER=new Season("夏天","夏日炎炎");
    public static final Season AUTUMN=new Season("秋天","秋高气爽");
    public static final Season WINTER=new Season("冬天","冰天雪地");

    //其他诉求1： 获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //其他诉求2：获取枚举类对象的属性

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

//jdk5.0,可以使用enum关键字定义枚举类
enum Season_Enum implements Info{

    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天,春暖花开");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天,夏日炎炎");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天,秋高气爽");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天,冰天雪地");
        }
    };


  /*  @Override
    public void show() {
        System.out.println("这是一个季节");
    }*/

    @Override
    public String toString() {
        return "Season_Enum{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    private Season_Enum(String seasonName, String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }

    private final String seasonName;
    private final String seasonDesc;

}