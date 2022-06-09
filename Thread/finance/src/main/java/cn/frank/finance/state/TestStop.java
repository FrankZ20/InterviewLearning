package cn.frank.finance.state;

/**
 * @author zhangfan
 * @date 2022/6/9 14:54
 */
//测试stop
//1.建议线程正常停止---->利用次数，不建议死循环
//2.建议使用标志位--->设置一个标记位
//3.不要使用stop或者destroy等过时或者jdk不建议使用的方法
public class TestStop implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {

        int i = 0;
        while (flag) {
            System.out.println("线程正在运行" + i++);
        }
        System.out.println("线程已经停止");
    }

    private void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {

        TestStop testStop = new TestStop();
        Thread thread = new Thread(testStop);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);

            if(i==900) {

                testStop.stop();
                break;
            }
        }
    }
}
