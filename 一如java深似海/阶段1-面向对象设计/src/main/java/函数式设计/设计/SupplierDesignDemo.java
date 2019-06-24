package 函数式设计.设计;

import lombok.SneakyThrows;

import java.util.function.Supplier;

/**
 * Created by zlj on 2019/6/24.
 */
public class SupplierDesignDemo {

    public static void main(String[] args) {

        /**
         * supplier作为方法参数时的灵活性
         */
        echo("Hello, world");

        // supplier可以做一个延迟的操作 更加灵活
        echo(() -> {
            sleep();
            return "hello, World";
        });


        /**
         * supplier作为方法返回值的灵活性
         */
        System.out.println(getMessage()); // 这里是及时返回了并执行了操作

        // 这里只是将待执行数据返回过来 但是并没有做里面的操作
        Supplier<String> supplier = getSupplierMessage();
        // 这里可以是一些业务操作
        // 之后才真正的执行数据流
        System.out.println("在业务操作之后执行的："  + supplier.get());

    }

    @SneakyThrows
    private static void sleep() {
        Thread.sleep(1000);
    }

    /**
     * supplier 作为方法参数 来说明一个拉和推的模式
     * supplier作为参数 更加灵活
     */
    private static void echo(String message) {
        System.out.println(message); // 类似于拉的模式
    }

    private static void echo(Supplier<String> message) {
        System.out.println(message.get());  // 类似于推的模式
    }


    /**
     * supplier作为方法返回值 可以达到延迟操作的效果  而不是及时返回数据流
     */
    private static Supplier<String> getSupplierMessage() {
        return SupplierDesignDemo::getMessage;
    }

    private static String getMessage() {
        sleep();
        return "aaaaa";
    }

}
