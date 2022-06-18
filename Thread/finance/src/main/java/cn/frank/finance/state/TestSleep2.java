package cn.frank.finance.state;

import java.util.Date;

/**
 * 模拟时间
 *
 * @author zhangfan
 * @date 2022/6/10 19:46
 */
public class TestSleep2 {

    public static void main(String[] args) throws InterruptedException {

        Date date = new Date();
        while (true) {
            Thread.sleep(1000);
            System.out.println(date);
            date = new Date();
        }
    }
    //模拟倒计时
    private static void tenDown() throws InterruptedException {

        int num = 10;
        while (true) {

            Thread.sleep(1000);
            System.out.println(num--);
            if(num <= 0) {
                break;
            }
        }
    }
}
