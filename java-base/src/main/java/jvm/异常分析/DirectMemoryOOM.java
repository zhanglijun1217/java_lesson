package jvm.异常分析;

import lombok.SneakyThrows;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存OOM （NIO中会使用）
 * vmargs: -XX:MaxDirectMemorySize指定最大的直接内存 默认会和堆最大值一致 即-Xmx
 * 这里设置的是10m
 *
 * 对应的异常：
 * Exception in thread "main" java.lang.OutOfMemoryError
 */
public class DirectMemoryOOM {

    static final int _1MB = 1024 * 1024;

    @SneakyThrows
    public static void main(String[] args) {
        // 利用反射获取unsafe
        // 直接获取的话 有getUnsafe方法限制了引导类加载器才能返回实例
        Field field = Unsafe.class.getDeclaredFields()[0];

        field.setAccessible(true);

        Unsafe unsafe = (Unsafe) field.get(null);

        while (true) {
            // 申请直接内存
            unsafe.allocateMemory(_1MB);
        }

    }
}
