package cn.frank.finance.state;

/**
 * @author zhangfan
 * @date 2022/6/30 21:09
 */

//测试守护线程
//上帝守护你
public class TestDaemon {

    public static void main(String[] args) {

        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认是false，如果设置为true，则线程会被守护，即使程序结束，线程也不会被回收，而是等待线程结束后才会被回收。
        thread.start(); //上帝线程启动

        new Thread(you).start(); //用户线程启动
    }
}

//上帝
class God implements Runnable {

    @Override
    public void run() {

        while (true) {

            System.out.println("上帝守护你");
        }
    }
}

//你
class You implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 36500; i++) {

            System.out.println("这是你的第" + i + "天，你今天很快乐");
        }
        System.out.println("========你已经死了=========");
    }
}
