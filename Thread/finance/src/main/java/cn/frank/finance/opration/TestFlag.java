package cn.frank.finance.opration;

/**
 * @author zhangfan
 * @date 2022/7/19 15:01
 */
public class TestFlag {

    public static void main(String[] args) {

        TV tv = new TV();
        new Player(tv).start();
        new Audience(tv).start();
    }
}

//生产者-->演员
class Player extends Thread {

    private final TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            if (i % 2 == 0) {

                this.tv.play("==节目==");
            } else {

                this.tv.play("广告");
            }
        }
    }
}

//消费者-->观众
class Audience extends Thread {

    private final TV tv;

    public Audience(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            tv.watch();
        }
    }
}

class TV {

    //演员表演，观众等待
    //观众观看，演员等待

    //节目
    String voice;

    boolean flag = true;

    //表演
    public synchronized void play(String voice) {

        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.voice = voice;
        flag = false;
        System.out.println("演员表演：" + voice);
        notifyAll();
    }

    public synchronized void watch() {

        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        flag = true;
        System.out.println("观众观看：" + voice);
        notifyAll();
    }
}
