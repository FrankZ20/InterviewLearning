package cn.frank.finance.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author 87507
 * @Description TODO
 * @date 2022/7/9 22:33
 */
//死锁：多个线程相互抱着对方需要的资源，然后形成僵持
public class DeadLock {

    public static void main(String[] args) {

        MakeUp makeUp = new MakeUp(1, "girl1");
        MakeUp makeUp2 = new MakeUp(2, "girl2");
        makeUp.start();
        makeUp2.start();
    }
}

//口红
class LipStick {

}

//镜子
class Mirror {

}

class MakeUp extends Thread {

    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();

    /**
     * 选择
     */
    int choices;

    /**
     * 女孩名字
     */
    String girlName;

    public MakeUp(int choices, String girlName) {
        this.choices = choices;
        this.girlName = girlName;
    }

    @Override
    public void run() {

        try {
            makeUp();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void makeUp() throws InterruptedException {

        switch (choices) {

            case 1:
                //拿口红
                synchronized(lipStick) {

                    System.out.println(girlName + "拿口红");
                    TimeUnit.SECONDS.sleep(1);

                    //拿镜子
                    synchronized (mirror) {
                        System.out.println(girlName + "拿到了口红和镜子");
                    }
                }
                break;
            case 2:
                //拿镜子
                synchronized(mirror) {

                    System.out.println(girlName + "拿镜子");
                    TimeUnit.SECONDS.sleep(1);
                    //拿镜子
                    synchronized (lipStick) {
                        System.out.println(girlName + "拿到了口红和镜子");
                    }
                }
                break;
            default:
                break;
        }
    }
    //解决方法
    private void makeUp() throws InterruptedException {

        switch (choices) {

            case 1:
                //拿口红
                synchronized(lipStick) {

                    System.out.println(girlName + "拿口红");
                    TimeUnit.SECONDS.sleep(1);
                }
                //拿镜子
                synchronized (mirror) {
                    System.out.println(girlName + "拿到了口红和镜子");
                }
                break;
            case 2:
                //拿镜子
                synchronized(mirror) {

                    System.out.println(girlName + "拿镜子");
                    TimeUnit.SECONDS.sleep(1);

                }
                //拿口红
                synchronized (lipStick) {
                    System.out.println(girlName + "拿到了口红和镜子");
                }
                break;
            default:
                break;
        }
    }
}
