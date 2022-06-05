package cn.frank.finance.thread;

/**
 * @author 87507
 */
public class TestThread extends Thread {

    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 10; i++) {

            System.out.println("线程方法第" + i + "个");
        }
        super.run();
    }

    public static void main(String[] args) {

        //创建线程
        TestThread testThread = new TestThread();

        //调用start方法开启线程
        testThread.start();

        for (int i = 0; i < 10; i++) {

            System.out.println("主方法第" + i + "个");
        }
    }
}
