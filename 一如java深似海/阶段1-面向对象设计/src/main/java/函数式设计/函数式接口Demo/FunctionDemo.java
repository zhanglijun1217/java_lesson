package 函数式设计.函数式接口Demo;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by zlj on 2019/6/23.
 */
public class FunctionDemo {

    public static void main(String[] args) {
        Function<String, Long> stringLongFunction = Long::valueOf;

        Function<Long, String> longStringFunction = String::valueOf;

        Consumer<Long> consumer= FunctionDemo::print;
        consumer.accept((stringLongFunction.apply("2")));

        // 说明Function接口的compose方法和andThen方法 都是支持链式操作的一种
        // compose是调用的Function对象之前操作的 这个过程是 1L -> "1" -> 1L
        Long apply = stringLongFunction.compose(longStringFunction).apply(1L);
        System.out.println("compose的结果类是："+ apply.getClass() + "值是：" + apply);

        // andThen是调用Function对象 之后链式操作的 这个过程是 "1" -> 1L -> "1"
        String apply1 = stringLongFunction.andThen(longStringFunction).apply("1");
        System.out.println("andThen的结果类：:"+ apply1.getClass() + "值是：" + apply1);

    }

    private static void print(Long value) {
        System.out.println(value);
    }
}
