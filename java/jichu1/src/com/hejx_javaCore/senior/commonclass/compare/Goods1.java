package com.hejx_javaCore.senior.commonclass.compare;

/**
 * @Classname Goods1
 * @Description TODO
 * @Date 2020/10/4 21:56
 * @Created by hejx
 */
public class Goods1 {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Goods1(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
