package cn.frank.finance.thread;

public class TestThread3 implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            System.out.println("runnable方法第" + i + "个");
        }
    }

    public static void main(String[] args) {

        TestThread3 testThread3 = new TestThread3();

        //创建线程对象通过线程对象来开启我们的线程代理
        new Thread(testThread3).start();

        for (int i = 0; i < 10; i++) {

            System.out.println("主方法第" + i + "个");
        }
    }
}
