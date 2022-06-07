package cn.frank.finance.thread;

/**
 * @author 87507
 * @date 2022/6/7 23:47
 */
public class LambdaTest {

    //3.静态内部类
    static class Like2 implements ILike {

        @Override
        public void lambda() {
            System.out.println("Lambda2");
        }
    }

    public static void main(String[] args) {

        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //4.局部内部类
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println("Lambda3");
            }
        }

        like = new Like3();
        like.lambda();

        //5.匿名内部类，没有类的名称，必须借助接口过着父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("Lambda4");
            }
        };

        like = () -> System.out.println("Lambda4");
        like.lambda();

        //6.带参数
        WTF wtf = (s, x) -> System.out.println(s + x);
        wtf.lambda("10", 10);
    }
}

//1.一个函数式接口
interface ILike {

    void lambda();
}

interface WTF {

    void lambda(String s, int x);
}

//2.实现类
class Like implements ILike {

    @Override
    public void lambda() {

        System.out.println("Lambda");
    }
}
