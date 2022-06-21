package cn.frank.finance.test;

/**
 * @author 87507
 * @Description TODO
 * @date 2022/6/21 23:20
 */
public class Test {

    public static void main(String[] args) {

        int i = 128;
        Integer i2 = 128;
        Integer i3 = 128;
        Integer i4 = 127;
        Integer i5 = 127;
        //true 因为会进行自动拆箱
        System.out.println(i == i2);
        //false 整型字面量的值在-128 到 127 之间，那么不会 new 新的 Integer 对象，而是直接引用常量池中的 Integer 对象
        System.out.println(i2 == i3);
        //true
        System.out.println(i4 == i5);
        //true Integr的equals方法被重写，包装类会自动拆箱
        System.out.println(i2.equals(i3));

        String a = "a";
        String b = new String("a");
        //false
        System.out.println(a == b);

    }
}
