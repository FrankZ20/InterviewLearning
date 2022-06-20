package cn.frank.finance.state;

import java.lang.Thread;

/**
 * @author zhangfan
 * @date 2022/6/20 11:05
 */
public class TestState {

    public static void main(String[] args) {

        Thread localThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("/////////");
            }
        });

        //观察状态
        Thread.State state = localThread.getState();
        System.out.println(state);//new

        //观察启动后的状态
        localThread.start();
        state = localThread.getState();
        System.out.println(state);//runnable

        while(state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            state = localThread.getState();
            System.out.println(state);
        }
    }
}
