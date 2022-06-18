package cn.frank.finance.thread;

/**
 * @author zhangfan
 * @date 2022/6/8 14:35
 */
//静态代理模式总结
    //真实对象和代理对象都要实现同一个接口
    //代理对象要代理真实对象
    //好处：
    //代理对象可以做很多真实对象不能做的事情
    //真实对象专注于做一件事情
public class StaticProxy {

    public static void main(String[] args) {

        //这里同理，thread算是runnable的静态代理
        new Thread(() -> System.out.println("我爱你")).start();
        new WeddingCompany(new You()).marry();
        Marry marry = new WeddingCompany(new You());
        marry.marry();
    }
}

@FunctionalInterface
interface Marry {

    void marry();
}

class You implements Marry {

    @Override
    public void marry() {

        System.out.println("Married");
    }
}


//实现Marry接口的代理类
class WeddingCompany implements Marry {

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }
    @Override
    public void marry() {

        before();
        this.target.marry();
        after();
    }

    private void before() {
        System.out.println("婚礼之前准备酒席");
    }
    private void after() {
        System.out.println("婚礼之后交尾款");
    }
}

abstract class Abstract {

    private String name;

    public abstract void marry();

    public void before() {
        System.out.println("婚礼之前准备酒席");
    }
}

class B extends Abstract {

    @Override
    public void marry() {
        System.out.println("Married");
    }
}
