package jvm.异常分析;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zlj on 2020/6/7.
 * 运行时常量池的OOM演示而在 1.8之后字符串常量池放入了java heap
 *
 * 所以对应的报错为：
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *
 *
 * 而如果在jdk1.6版本下 会出现报错：java.lang.OutOfMemoryError: PermGen Space （如果设置了对应的java permGen space参数大小）
 *
 */
public class StringConstantPoolOOM {

    public static void main(String[] args) {
        // 使用list保持对象的引用 避免因为gc导致的回收常量池
        List<String> list = new ArrayList<>();

        int i = 0 ;

        while (true) {
            System.out.println(list.size());
            list.add(String.valueOf(i++).intern());
        }
    }
}
