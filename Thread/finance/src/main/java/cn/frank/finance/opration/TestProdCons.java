package cn.frank.finance.opration;

import lombok.Data;

/**
 * @author zhangfan
 * @date 2022/7/18 14:17
 */
//测试：生产者消费者模型-->利用缓冲区解决：管程法
public class TestProdCons {

    public static void main(String[] args) {

        SynContainer synContainer = new SynContainer();
        new Producer(synContainer).start();
        new Consumer(synContainer).start();
    }
}

//生产者
class Producer extends Thread {

    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "生产者生产了：" + i);
            container.put(new Product(i));
        }
    }

}

//缓冲区
class SynContainer {

    private static final int DEFAULT_SIZE = 100;

    private int count = 0;

    private static final Product[] chickens;

    static {

        chickens = new Product[DEFAULT_SIZE];
    }

    //生产者放入产品
    public synchronized void put(Product chicken) {

        while (count == chickens.length) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //放入产品
        chickens[count] = chicken;
        count++;
        //通知消费者消费
        this.notify();
    }

    public synchronized Product pop() {

        //判断能否消费
        while (count == 0) {

            //通知生产者生产，等待消费
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果可以消费
        count--;
        Product product = chickens[count];
        //吃完了通知生产者生产
        notify();

        return product;
    }
}

//消费者
class Consumer extends Thread {

    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            System.out.println(Thread.currentThread().getName() + "消费者消费了：" + container.pop().getId());
        }
    }
}

//产品
@Data
class Product {

    int id;

    public Product(int id) {
        this.id = id;
    }
}
