package cn.frank.finance.sync;

import java.util.ArrayList;
import java.util.List;

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

            new Thread(() -> list.add(Thread.currentThread().getName())).start();
        }

        Thread.sleep(3000);

        System.out.println(list.size());
    }
}
