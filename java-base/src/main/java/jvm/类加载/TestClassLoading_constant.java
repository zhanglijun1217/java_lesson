package jvm.类加载;

import java.util.UUID;

/**
 * ## 常量
 * 知识点：
 * （1）编译期常量在编译阶段会存入直接调用这个常量的类的常量池中，本质上并没有引用（主动使用）到定义常量的类，不会导致定义常量的类的初始化。
 * （2）一些助记符 详见注释
 * （3） 运行时常量会导致类的初始化 这个常量不会加入常量池
 */
public class TestClassLoading_constant {

    public static void main(String[] args) {

        // 调用常量
        System.out.println(MyConstant.str); // 并没有初始化类MyConstant
        System.out.println(MyConstant.sht); // 并没有初始化类MyConstant
        System.out.println(MyConstant.int_128); // 并没有初始化类MyConstant
        System.out.println(MyConstant.int2); // 并没有初始化类MyConstant
        System.out.println(MyConstant.int_1);

        System.out.println(MyConstant.rom);// 初始化类MyConstant

    }

}
class MyConstant {
    static final String str = "hello world"; // 对应ldc助记符 ： int、float、或者string类型的常量推到栈顶
    static final int int_1 = 1;// 对应iconst_1助记符 数字0到5都是这种 特殊的助记符。-1是iconst_m1
    static final short sht = 12;// 对应字节码助记符是bipush 单字节长度的常量值(-127~128)推到栈顶
    static final int int_128 = 128; // 对应字节码助记符是sipush 短整型长度的常量值（-32768~32767） 推到栈顶
    static final int int2 = 40000; // 对应ldc助记符

    static final String rom = UUID.randomUUID().toString(); // 运行时常量是特殊的 不会加入到对应类的常量池中 会主动调用常量所在的类 导致类初始化 对应的助记符也是getstatic助记符

    static {
        System.out.println("MyConstant 初始化。。。。");
    }
}
