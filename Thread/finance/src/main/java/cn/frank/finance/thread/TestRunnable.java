package cn.frank.finance.thread;

public class TestRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            System.out.println("runnable方法第" + i + "个");
        }
    }

    public static void main(String[] args) {

        TestRunnable testRunnable = new TestRunnable();

        //创建线程对象通过线程对象来开启我们的线程代理
        new Thread(testRunnable).start();

        for (int i = 0; i < 10; i++) {

            System.out.println("主方法第" + i + "个");
        }
    }
}
