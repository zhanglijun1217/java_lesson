package 函数式设计.设计;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by zlj on 2019/6/24.
 */
public class PredicateDesignDemo {

    public static void main(String[] args) {

        // test
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("偶数是" + filter(integers, i -> i % 2 == 0));
        System.out.println("奇数是" + filter(integers, i -> i % 2 != 0));
    }

    /**
     * 实现一个过滤操作 predicate接口带来的便捷性 配合泛型使用
     *
     * @param source
     * @param predicate
     * @param <T>
     * @return
     */
    private static <T> Collection<T> filter(Collection<T> source, Predicate<T> predicate) {
        // 一个小技巧 在不考虑内存开销的情况下 尽量不直接操作原数据

        // 当然这里是潜拷贝
        Collection<T> copy = Lists.newArrayList(source);
        Iterator<T> iterator = copy.iterator();

        // 传统的while迭代器的写法

//        while (iterator.hasNext()) {
//            if (!predicate.test(next)) {
//                iterator.remove();
//            }
//        }

        // 优化成for循环的写法
        for (iterator = copy.iterator(); iterator.hasNext(); ) {
            T next = iterator.next();
            if (!predicate.test(next)) {
                iterator.remove();
            }
        }

        // 小技巧 返回不可变集合
        return Collections.unmodifiableCollection(copy);
    }
}
