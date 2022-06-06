package cn.frank.finance.thread;

import org.springframework.util.StringUtils;

/**
 * 龟兔赛跑
 *
 * @author zhangfan
 * @date 2022/6/6 15:13
 */
public class TortoiseAndHare implements Runnable {

    private final int len = 100;

    private String winner;

    @Override
    public void run() {

        for (int i = 0; i <= len; i++) {

            if("兔子".equals(Thread.currentThread().getName()) && 1%50 == 0) {

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(gameOver(i)) {

                break;
            }

            System.out.println(Thread.currentThread().getName() + "-->跑了" + i + "步");
        }
    }

    public static void main(String[] args) {

        TortoiseAndHare tortoiseAndHare = new TortoiseAndHare();
        new Thread(tortoiseAndHare, "兔子").start();
        new Thread(tortoiseAndHare, "乌龟").start();
    }

    private boolean gameOver(int steps) {

        if (StringUtils.hasText(winner)) {

            return true;
        }
        if(steps >= len) {

            winner = Thread.currentThread().getName();

            System.out.println("winner is: " + winner);

            return true;
        }
        return false;
    }
}
