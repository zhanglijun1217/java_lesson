package 下.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 泛型作为方法参数 通配符 ？ 的demo
 * Created by zlj on 2019/6/16.
 */
public class GenericWildcardsDemo {

    public static void main(String[] args) {

        List<Number> numbers = new ArrayList<>();

        // 通配符上界
        upperWildCards(numbers);

        // 全通配符 可以逃过编译器的检查
        unBondWildCards(numbers);

        // 下届通配符 使用（一般使用在操作数据 比如add）



    }

    /**
     * 无边界的通配符的使用
     * 注意泛型擦除 不能再定义一个 Iterable<Object>参数的同名方法。
     *
     * 无边界通配符的使用场景：这里numbers可以传入通配符定义的方法，但是Iterable<Object>就不行 所以直接一个 ? 无边界通配符可以逃过编译器的检查
     * @param iterable
     */
    public static void unBondWildCards(Iterable<?> iterable) {
        iterable.forEach(System.out::println);
    }

    // 下边这个方法会编译不通过 因为泛型的擦除， 参数是一样的
//    public static void unBondWildCards(Iterable<Object> iterable) {
//        iterable.forEach(System.out::println);
//    }



    public static void upperWildCards(List<Number> numbers) {
        numbers.add(Byte.valueOf((byte) 1));
        numbers.add(Short.valueOf((short)2));
        numbers.add(Integer.valueOf(3));
        numbers.add(Long.valueOf(4));

        List<Byte> bytes = Arrays.asList((byte) 5);
        List<Short> shorts = Arrays.asList((short) 6);
        List<Integer> integers = Arrays.asList(7);

        numbers.addAll(bytes); //addAll方法 参数是 ? extends Number
        numbers.addAll(shorts);
        numbers.addAll(integers);

        consumeIterable(numbers, System.out::println);
    }


    /**
     * 上界通配符的方法
     * @param iterable
     * @param consumer
     */
    public static void consumeIterable(Iterable<? extends Number> iterable, Consumer<Object> consumer) {
        for (Number number : iterable) {
            consumer.accept(number);
        }
    }

    public static void lowerWildcards(List<? extends Number> extendsIterable, List<? super Number> superIterable) {
        // effective java中的一个通配符使用边界规范：
        //       PECS stands for producer-extends, consumer-super.


        // 读取数据用 extends 可以循环中变量为Number
        for (Number number : extendsIterable) {

        }
        // 如果用的是super通配符 则迭代的是Object对象
//        for (Object o : superIterable) {
//
//        }

        // 操作数据用super
        superIterable.add(Integer.valueOf(22));

//        extendsIterable.add(Integer.valueOf(21)); // 编译会报错

    }

}
