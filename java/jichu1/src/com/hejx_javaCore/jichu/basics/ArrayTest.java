package com.hejx_javaCore.jichu.basics;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数组的特点：
 * 数组是有序排列的
 * 数组属于引用数据类型(类,接口,数组)的变量  (引用类型在堆里，基本类型在栈里。)
 * 数组元素属于可以是基本数据类型，也可以是引用数据类型
 */
public class ArrayTest {
    /**
     * 一维数组
     * 初始化值：
     * 整型：0
     * 浮点型：0.0
     * 字符型：'\0'的uncoid值
     * boolean:false
     * 引用数据类型（类、数组、接口）:null
     */
    public static void main1(String[] args) {
        String[] str = {"hejx", "sjq"};
        String[] str1 = new String[5];
        char ch = str[1].charAt(1);
        /*静态初始化*/
        //声明初始化1
        int[] a = {1, 2, 3, 4, 5};
        //声明初始化2
        int[] w;
        w = new int[]{1, 2, 3, 4, 5};

        /*动态初始化*/
        //声明初始化3
        int[] q1 = new int[5];

        //声明初始化4
        int n = 5;
        int[] q = new int[n];
        for (int i = 0; i < 5; i++) q[i] = i + 1;

        for (int i = 0; i < 5; i++) System.out.print(q[i] + ",");
        System.out.print("\n");
        System.out.println(str.length);
        System.out.println(q.length);
        //  System.out.println(str);
        System.out.println(str + ",toString:" + str.toString() + ",hashCode:" + str.hashCode());
        System.out.println(ch);
        System.out.println(str1[4]);
        /**
         * 数组一旦初始化完成，其长度就确定了
         *
         */

        float fl = 1.2f;
        double db = 1.2;
        long lo = 100;
        char ca = '\0';
        System.out.println(ca);
        System.out.println(fl);
    }

    /**
     * 二维数组
     * 二维数组 int[][] a=new int[3][3]:
     * a[0]存的是对一维数组引用的首地址
     */
    public static void main2(String[] args) {
        //String[] st={"1","2","3"};
        String[][] a = new String[][]{{"hejx", "20"}, {"sql", "22"}};
        System.out.print(a[0][0] + "," + a[0][1] + "\n");

        System.out.println("*****************");
        //静态初始化1
        int[][] _int = new int[][]{{1, 2}, {3, 4, 5}, {6, 7, 8, 9, 10}};
        //静态初始化2
        int[][] f_int = {{1, 2}, {3, 4, 5}};
        for (int i = 0; i < _int.length; i++) {
            for (int j = 0; j < _int[i].length; j++)
                System.out.print(_int[i][j] + " ");
            System.out.print("\n");
        }
        System.out.println("*****************");
        //动态初始化1
        int[][] q = new int[2][3];
        for (int i = 0; i < q.length; i++)
            for (int j = 0; j < q[i].length; j++)
                q[i][j] = i + j;
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < q[i].length; j++)
                System.out.print(q[i][j] + " ");
            System.out.print("\n");
        }
        //动态初始化2
        System.out.println("*****************");
        int[][] q1 = new int[2][];
         /*int[] p0 = {1, 2, 3};
        int[] p1 = {4, 5, 6, 7, 8, 9};
        q1[0] = p0;
        q1[1] = p1;*/
        q1[0] = new int[]{1, 2, 3};
        q1[1] = new int[]{4, 5, 6, 7, 8, 9};
        for (int i = 0; i < q1.length; i++) {
            for (int j = 0; j < q1[i].length; j++)
                System.out.print(q1[i][j] + " ");
            System.out.print("\n");
        }
        System.out.println("*****************");

        /*
         * 默认初始化值
         * int[][] a=new int[3][3];
         * a[1]:地址值
         * a[1][1]=0
         *
         */
        int[][] q2 = new int[2][3];
        System.out.println(q2);
        for (int i = 0; i < q2.length; i++) {
            System.out.print(q2[i] + "," + q2[i].hashCode() + "," + q2[i].toString() + " ");
            for (int j = 0; j < q2[i].length; j++)
                System.out.print(q2[i][j] + " ");
            System.out.print("\n");
        }
    }

    /**
     * 数据结构：
     * 1.数据与数据之间的逻辑关系：集合、一对一、一对多、多对多
     * 2.数据的存储结构：
     * 线性表：顺序表（比如：数组）、链表、栈、队列   一对一
     * 树形结构：二叉树
     * 图形结构：
     * <p>
     * 算法：
     * 排序算法：
     * 搜索算法：
     */
    @Test
    public  void main3() {
        //杨辉三角
        int i, j, n = 20;
        int[][] a = new int[n][n];
        for (i = 0; i < n; i++) {
            a[i][i] = 1;
            a[i][0] = 1;
        }

        for (i = 2; i < n; i++)
            for (j = 1; j < i; j++)
                a[i][j] = a[i - 1][j] + a[i - 1][j - 1];

        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    public static void main4(String[] args) {
/**
 *  创建一个长度为6的int型数组，要求取值为1-30，同时元素值各不相同
 */
        int[] a = new int[6];
        int i, j;

        for (i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 30) + 1;
            for (j = 0; j < i; j++)
                if (a[i] == a[j]) break;

            if (j < i) i--;
        }

        for (i = 0; i < a.length; i++) System.out.print(a[i] + ",");
    }

    public static void main5(String[] args) {
        int n = 7;
        int[][] arr = new int[n][n];

        int count = 0; // 要显示的数据
        int maxX = n - 1; // x轴的最大下标
        int maxY = n - 1; // Y轴的最大下标
        int minX = 0; // x轴的最小下标
        int minY = 0; // Y轴的最小下标
        while (minX <= maxX) {
            for (int x = minX; x <= maxX; x++) {
                arr[minY][x] = ++count;
            }
            minY++;
            for (int y = minY; y <= maxY; y++) {
                arr[y][maxX] = ++count;
            }
            maxX--;
            for (int x = maxX; x >= minX; x--) {
                arr[maxY][x] = ++count;
            }
            maxY--;
            for (int y = maxY; y >= minY; y--) {
                arr[y][minX] = ++count;
            }
            minX++;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                String space = (arr[i][j] + "").length() == 1 ? "0" : "";
                System.out.print(space + arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //查找
    @Test
    public void main6() {
        //线性查找
        String[] str = {"AA", "BB", "CC", "DD", "MM", "NN"};
        Boolean isDest = true;
        String dest = "MM";
        for (int i = 0; i < str.length; i++) {
            if (dest.equals(str[i])) {
                isDest = false;
                System.out.println("位置下标：" + i);
                break;
            }
        }
        if (isDest) System.out.println("无此元素");


        //二分法查找(前提，数组有序)
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int leftIndex = 0, rightIndex = a.length, midIndex, find = 10;
        boolean isFind = true;
        while (leftIndex <= rightIndex) {
            midIndex = (leftIndex + rightIndex) / 2;
            if (find < a[midIndex]) {
                rightIndex = midIndex - 1;
            } else if (find > a[midIndex]) {
                leftIndex = midIndex + 1;
            } else if (find == a[midIndex]) {
                System.out.println("下标：" + midIndex);
                isFind = false;
                break;
            }
        }

        if (isFind) System.out.println("无此元素");
    }

    //排序
    @Test
    public  void main7() {
        //冒泡排序
        int[] a = {1, 3, 2, 4, 6, 5, 7, 9, 8, 0};
        int i, j, temp;
        /*for (i = 0; i < a.length - 1; i++)
            for (j = i + 1; j < a.length; j++)
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }*/
        for(i=0;i<a.length-1;i++)
        {
            for(j=0;j<a.length-1-i;j++)
            {
                if(a[j]>a[j+1])
                {
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for (i = 0; i < a.length; i++) System.out.print(a[i] + ",");

        //快速排序(见com.hejx_javaCore.suanfa.kuaisupaixu)
    }

    /**
     * 注意：Arrays类
     */
    public static void main(String[] args) {
        int[] a = {1, 3, 12, 4, 6, 5, 7, 9, 8, 10};
        Arrays.sort(a);
        System.out.println(Arrays.binarySearch(a,1));

        System.out.println("********************");
        int[] b=Arrays.copyOf(a,11);
        for (int i = 0; i <b.length ; i++) {
            System.out.println(b[i]);
        }
        System.out.println("***********************");
        int[] c=Arrays.copyOfRange(a,1,3);
        for (int i = 0; i <c.length ; i++) {
            System.out.println(c[i]);
        }
        System.out.println("***********************");

        System.out.println("********************");
        System.out.print(Arrays.toString(a));


    }

}
