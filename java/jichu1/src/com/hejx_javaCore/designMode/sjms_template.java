package com.hejx_javaCore.designMode;
/**
 * 模板方法设计模式
 *
 *
 */
public class sjms_template {
    public static void main(String[] args) {
        Template template = new SubTemplate();
        template.spendTime();
    }
}

abstract class Template{
      public final void spendTime() {//使得子类不可重写
        long start = System.currentTimeMillis();
        this.code();
        long end = System.currentTimeMillis();
        System.out.println("花费的时间：" + (end - start));
    }

    public abstract void code();
}

class SubTemplate extends Template { //求素数

    @Override
    public void code() {
        int i, j, k, count = 0;
        for (i = 2; i <= 1000; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            k = (int) (Math.sqrt(i));
            for (j = 2; j <= k; j++)
                if (i % j == 0) break;
            if (j >= k + 1) {
                System.out.println(i);
                count++;
            }
        }
        System.out.print("有" + count + "个");
    }
}
