package cn.frank.finance.state;

import cn.frank.finance.thread.TestMultiThread;

/**
 * @author zhangfan
 * @date 2022/6/9 16:22
 */
public class TestSleep implements Runnable {

    private int ticketNums = 10;

    @Override
    public void run() {

        while (ticketNums > 0) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "票");
        }

    }

    public static void main(String[] args) {

        TestMultiThread testMultiThread = new TestMultiThread();

        new Thread(testMultiThread).start();
        new Thread(testMultiThread).start();
        new Thread(testMultiThread).start();
    }
}
