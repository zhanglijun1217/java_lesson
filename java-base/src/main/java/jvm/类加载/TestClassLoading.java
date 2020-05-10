package jvm.类加载;

/**
 * Created by zlj on 2020/4/13.
 * 只有类被主动使用时 才能初始化这个类
 *
 * 可以使用 -XX:+TraceClassLoading启动参数 来查看类加载情况
 */
public class TestClassLoading {

    public static void main(String[] args) {

        // （1）并不会初始化类 Children 因为没有主动使用 Children；会初始化Parent 因为访问了str1
        System.out.println(Children.str1);

        System.out.println("===========================");

        // 会初始化Parent 也会初始化Children。因为访问了str2，要初始化Children，又因为子类被初始化，所以父类也被主动使用，进行初始化
//        System.out.println(Children.str2);
    }

    static class Parent {
        static String str1 = "hello";

        static {
            System.out.println("Parent初始化。。。。");
        }
    }

    static class Children extends Parent {
        static String str2 = "world";

        static {
            System.out.println("Children初始化。。。。");
        }
    }


}
