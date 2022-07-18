package cn.frank.finance.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 87507
 * @Description TODO
 * @date 2022/7/16 16:47
 */
public class TestLock {

    public static void main(String[] args) {

        Test test = new Test();
        new Thread(test, "a").start();
        new Thread(test, "b").start();
    }
}

class Test implements Runnable {

    int ticketNums = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        lock.lock();

        try {
            while (ticketNums > 0) {

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + ticketNums--);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {

            lock.unlock();
        }
        lock.unlock();
    }
}
