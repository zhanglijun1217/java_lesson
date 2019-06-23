package 函数式设计.函数式接口Demo;

import java.util.function.Predicate;

/**
 * Created by zlj on 2019/6/23.
 */
public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<Long> predicate = PredicateDemo::compare;

        System.out.println(predicate.test(3L));


        System.out.println(predicate.and(PredicateDemo::compare2).test(15L));

        System.out.println(predicate.and(PredicateDemo::compare).negate().test(15L));

    }

    static boolean compare(Long x) {
        return x > 5L;
    }

    static boolean compare2(Long x) {
        return x < 20L;
    }
}
