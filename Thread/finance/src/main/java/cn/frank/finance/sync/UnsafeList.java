package cn.frank.finance.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 87507
 * @Description TODO
 * @date 2022/7/3 22:45
 */
//线程不安全的集合
public class UnsafeList {

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {

            new Thread(() -> {

                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        //如果不加sleep主线程会提前跑完，导致list还没add完就输出了
        TimeUnit.SECONDS.sleep(1);

        System.out.println(list.size());
    }
}
