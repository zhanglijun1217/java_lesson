package 集合基础.基础总览;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zlj on 2019/9/8.
 */
public class HashSetDemo {
    public static void main(String[] args) {

        /**
         * 看上去 hashSet就是有序的
         * 这是因为在存储字符时， String的hashcode算法也是按照ASCII码递增的，这里看起来就像是有序的一样，但其实hashSet是无法保证顺序的
         */
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        System.out.println(set);

        set.clear();
        set.add("1");
        set.add("2");
        set.add("3");
        System.out.println(set);



    }
}
