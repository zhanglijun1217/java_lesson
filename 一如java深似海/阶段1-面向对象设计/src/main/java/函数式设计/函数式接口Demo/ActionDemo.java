package 函数式设计.函数式接口Demo;

/**
 * Created by zlj on 2019/6/23.
 */
public class ActionDemo {

    public static void main(String[] args) {
        /**
         * 比较匿名内部类和lambda的一个方式
         */

        // 通过编译之后的字节码文件可以看到是创建了一个内部类 匿名内部类 ActionDemo$1.class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("111111");
            }
        };
        // 通过编译之后的class文件 可以看到lambda并没有像匿名内部类那样创建一个新的类
        // 而是使用了 InvokeDynamic 指令 通过字节码提升实现了lambda

        // 具体的可以见  java.lang.invoke.MethodHandle  java.lang.invoke.InvokeDynamic
        Runnable r2 = () -> System.out.println("22222");
    }
}
