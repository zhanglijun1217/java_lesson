package 上;

import lombok.SneakyThrows;

import java.util.*;

/**
 * 描述 不可变 集合的一个用处
 * 其实就是 将这个视图返回给用的人 这是一个不可变的集合对象
 * 比如Map.keySet()方法 就是返回一个不能进行 add remove操作的key的集合
 *
 * 不可变可以保证线程安全  其实比如HashMap不是线程安全的在只读的场景下 这个观点是错误，读是不会发生线程不安全的问题
 * Created by zlj on 2019/6/11.
 */
public class UnmodifiableCollectionDemo {

    @SneakyThrows
    public static void main(String[] args) {
        List<Integer> of = of(1, 2, 4, 5, 6);

        of.add(6);
        System.out.println("可变对象：" + of);

        // 不可变去抛出异常
        List<Integer> unmodifiable = unmodifiable(1, 2, 4, 5, 6);

        unmodifiable.add(7);

    }

    static List<Integer> of(Integer ... arrays) {
        // 注意 Arrays.asList返回的也是不可操作的集合
        return new ArrayList<Integer>(Arrays.asList(arrays));
    }

    static List<Integer> unmodifiable(Integer ... arrays) {
        return Collections.unmodifiableList(Arrays.asList(arrays));
    }
}
