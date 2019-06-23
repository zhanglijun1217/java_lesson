package 函数式设计.函数式接口Demo;

import java.util.function.Consumer;

/**
 * Created by zlj on 2019/6/23.
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer consumer = System.out::println;

        consumer.accept("aaaa");

        // 这里可以直接是方法引用 来新建一个consumer
        Consumer<String> consumer1 = ConsumerDemo::echo;

        // consumer 支持链式的处理 注册多个consumer  Fluent API
        consumer.andThen(consumer1).accept("bbbb");
    }

    public static void echo(String message) {

        System.out.println("echo" + message);
    }


}
