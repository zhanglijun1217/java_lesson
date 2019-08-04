package 函数式设计.设计;
// 小马哥每日一问的一个题 https://segmentfault.com/n/1330000019799723
public class Lazy {

    private static boolean initialized = false;

    // static也是由main线程去初始化的
    static {
        println("static模块加载了");

        Thread t = new Thread(
//                 lambda表达式 是通过invokeDynamic指令实现的 这个类的初始化 依赖于这个指令的执行
//                () -> {
//                    initialized = true;
//                }
                // new Runnable 匿名内置类是 通过 Lazy$1.class来实现的
//                    new Runnable() {
//                        @Override
//                        public void run() {
//                            System.out.println("匿名内置类执行");
//                            // 调用 static变量赋值或者static方法就会发生类似于死锁的现象 因为静态变量算这个类的一部分
//                            initialized = true;
////                            println("static方法 打印线程名称执行");
//                        }
//                    }

                // 方法引用也是通过invokeDynamic指令实现的，但是其等待的是System.out也就是java.io.PrintStream这个println方法，而这个方法是BootStrapClassloader加载的
                // 早于Lazy类的初始化（Lazy是使用ApplicationClassloader或者SystemClassloader启动的），所以这个启动不会有毛病。
                System.out::println

        );
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        println("main线程执行了");
        System.out.println(initialized);
    }

    private static void println(Object o) {
        System.out.printf("线程[%s]- %s\n", Thread.currentThread().getName(), o);
    }
}
