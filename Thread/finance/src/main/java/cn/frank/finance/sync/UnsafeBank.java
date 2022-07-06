package cn.frank.finance.sync;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author 87507
 * @Description TODO
 * @date 2022/7/3 21:11
 */
//不安全的取钱
public class UnsafeBank {

    public static void main(String[] args) {

        Account account = new Account(100, "结婚基金");

        synchronized (account) {

            Drawing you = new Drawing(account, 50, "你");
            Drawing gf = new Drawing(account, 100, "女朋友");

            you.start();
            gf.start();
        }

    }
}
@Data
class Account {

    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {

    //账户
    Account account;
    //取了多少钱
    int drawingMoney;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {

        if (account.getMoney() - drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "没钱了");
            return;
        }

        //sleep可以放大问题的发生性
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        account.setMoney(account.getMoney() - drawingMoney);
        nowMoney = nowMoney + drawingMoney;

        System.out.println(Thread.currentThread().getName() + "取了" + drawingMoney + "钱,现在手里有" + nowMoney + "，剩余" + account.getMoney());
//        System.out.println(super.getName() + "手里的钱：" + nowMoney);
    }
}
