package cn.frank.finance.thread;

/**
 * 模拟火车票抢票（多个线程同时操作一个对象）
 *
 * @author zhangfan
 * @date 2022/6/6 10:31
 */
//发下问题，多个线程操作同一个资源的情况下，线程不安全，出现数据紊乱
public class TestMultiThread implements Runnable {


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
