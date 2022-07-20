package cn.frank.finance.opration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangfan
 * @date 2022/7/19 20:54
 */
public class TestPool {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.shutdown();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            System.out.println(Thread.currentThread().getName() + "------" + i);
        }
    }
}
