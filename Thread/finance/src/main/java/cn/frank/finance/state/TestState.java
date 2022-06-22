package cn.frank.finance.state;


import java.util.*;
import java.util.stream.Stream;

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

        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            state = localThread.getState();
            System.out.println(state);
        }

        //玩花的
        System.out.println("--------------------------");
        System.out.println(Thread.currentThread().getState());
        Stream.of("a", "b", "c").forEach(n -> new Thread(n) {
            @Override
            public void run() {
                System.out.println(getName());
            }
        }.start());
    }
}
