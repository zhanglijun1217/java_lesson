package 函数式设计.函数式接口Demo;

/**
 * Created by zlj on 2019/6/23.
 */
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

        Function1 function1 = () -> {};

        // 即使没有加上@FunctionalInterface 也可以lambda初始化
        Function2 function2 = () -> {};
    }

    @FunctionalInterface
    public interface Function1{
        // 只能有一个抽象方法  除了default方法和Object中的public方法
        void execute();

        default String getDesc() {
            return String.valueOf(this);
        }
    }

    // 即使不加上@FunctionalInterface 因为符合函数式接口的条件 也可以被认为是函数式的实现
    public interface Function2 {
        void execute();
    }

//    @FunctionalInterface 这里会通不过 函数式接口的检查
    public interface Function3 {
        void execute();

        void execute2();
    }
}
