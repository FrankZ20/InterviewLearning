package cn.frank.finance.sync;

/**
 * @author 87507
 * @Description TODO
 * @date 2022/7/3 15:45
 */
//线程不安全
public class UnsafeBuyTicket {

    public static void main(String[] args) {

        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "1").start();
        new Thread(buyTicket, "2").start();
        new Thread(buyTicket, "3").start();
    }
}

class BuyTicket implements Runnable {

    //票
    private int ticket = 10;
    boolean flag = true;

    @Override
    public void run() {

        while (flag) {

            buy();
        }
    }

    private void buy() {

        if (ticket <= 0) {

            System.out.println("没票了");
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到" + ticket--);
    }
}
