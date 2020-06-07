package jvm.异常分析;

/**
 * 演示频繁创建线程导致的OOM
 * vmargs 这里设置栈大小为2m 尽快的发生OOM -Xss2m
 *
 * 对应的报错   java.lang.OutOfMemoryError: unable to create new native thread 注意这里的OOM并不是堆上的oom
 * 有的电脑可能会卡死 = =
 *
 */
public class JavaVMStackOOM {

    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {
                while (true) {
//                    System.out.println("当前线程" + Thread.currentThread().getName());
                }
            }).start();
        }



    }
}
