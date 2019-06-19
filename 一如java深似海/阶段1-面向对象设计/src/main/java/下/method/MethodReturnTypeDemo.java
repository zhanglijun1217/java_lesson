package 下.method;

import java.util.*;

public class MethodReturnTypeDemo {
    // 面向对象 --> 多态、封装、基础和那个


    /**
     * 方法返回值（多态、封装）
     *     // 原则一：返回类型需要抽象（强类型），但是这里说的不是Object
     *     // 抽象返回类型的意义 调用方容易处理
     */
    // 返回一个有序的，去重的字符串  // 错误示例
    public TreeSet<String> getValues() {
        return new TreeSet<>();
    }

    public SortedSet<String> getSortedValues() { // 正确范例
        return new TreeSet<>();
    }

    // 如果返回的类型是集合的话，Collection优于List 或 Set
    // 如果不考虑写操作，Iterable 优于 Collection

    /**
     *  原则二：尽可能的放回java集合框架中的接口，尽量避免数组
     *  避免数组的原因有二：
     *  （1）Collection 比较 [] 而言，拥有更多的操作方法， 比如add
     *  （2）Collection返回时，可以限制只读，而[]不行
     *
     *  原则三：确保集合返回接口只读，如果要返回非只读集合的话，要确保返回快照
     */
    public static List<Integer> getNumbersOnlyRead() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        // 这里虽然Arrays.asList方法返回的内部类ArrayList是不支持add方法，但是有set方法可以修改list，所以并非完全不可变的
        // 所以这里用Collections.unmodifiableList即可
        return Collections.unmodifiableList(numbers);
    }

    public static List<Integer> getNumberNotOnlyRead() {
        List<Integer> numbers = Arrays.asList(1, 2,3,4);
        // 非只读的集合，要快照
        return new ArrayList<>(numbers);
    }




    public static void main(String[] args) {
        /**
         * test Arrays.asList返回值真的是不可变吗
         */
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
//        integers.add(1); // add操作会抛异常
        // 但是set方法是可以操作的
        integers.set(2, 0);

        println(integers); // 可以看到这里是修改了的 返回值 1 2 0 4
        List<Integer> numbersOnlyRead = getNumbersOnlyRead();
//        numbersOnlyRead.set(1, 2); 因为是返回的只读的 这里set也会报错
        println(numbersOnlyRead);

        List<Integer> numberNotOnlyRead = getNumberNotOnlyRead();
        // 返回非只读的 可以修改
        numberNotOnlyRead.add(5);
        println(numberNotOnlyRead);


    }

    public static void println(List<Integer> numbers) {
        numbers.forEach(System.out::println);
    }
}
