package 函数式设计.Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by zlj on 2019/6/24.
 */
public class StreamDemo {


    public static void main(String[] args) {
        // 排序 过程输出线程名称
        parallel(2,9,5,3,1,7,4);
        System.out.println("最终结果");
        parallelSortPrint(2,9,5,3,1,7,4);

        Stream<Integer> parallel = Stream.of(1, 2, 3, 4).parallel();

        System.out.println("流是否为并行的判断方法：" + parallel.isParallel()); // 一般不建议将Stream作为方法的返回，如果作为返回 要判断是否为并行流
        // 转换串行
        parallel.sequential();
        System.out.println("流是否为并行的判断方法：" + parallel.isParallel());
    }

    // 演示一个并行排序的操作
    public static void parallel(Integer ... numbers) {
        Stream<Integer> stream = Arrays.stream(numbers);
                stream.parallel()
                .forEach(StreamDemo::println);
    }

    public static void parallelSortPrint(Integer ... numbers) {
        Stream<Integer> stream = Arrays.stream(numbers);
        stream.parallel().sorted()
                // 如果不用 foreachOrdered 并行排序会输出错误
                .forEachOrdered(System.out::print);
    }

    private static void println(Integer number) {
        System.out.println("当前线程：" + Thread.currentThread().getName() + "  处理的值：" + number);
    }
}
