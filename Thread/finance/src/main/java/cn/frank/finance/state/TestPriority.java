package cn.frank.finance.state;

/**
 * @author 87507
 * @Description TODO
 * @date 2022/6/28 21:43
 */
public class TestPriority {

    public static void main(String[] args) {

        //主线程的优先级
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread thread1 = new Thread(myPriority);
        Thread thread2 = new Thread(myPriority);
        Thread thread3 = new Thread(myPriority);
        Thread thread4 = new Thread(myPriority);
        Thread thread5 = new Thread(myPriority);
        Thread thread6 = new Thread(myPriority);

        //先设置优先级再启动
        thread1.start();

        thread2.setPriority(1);
        thread2.start();

        thread3.setPriority(4);
        thread3.start();

        thread4.setPriority(Thread.MAX_PRIORITY);
        thread4.start();

        thread5.setPriority(8);
        thread5.start();

        thread6.setPriority(7);
        thread6.start();
    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority());
    }
}