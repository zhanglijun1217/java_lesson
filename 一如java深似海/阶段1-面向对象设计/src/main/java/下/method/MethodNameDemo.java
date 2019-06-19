package 下.method;

import lombok.SneakyThrows;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class MethodNameDemo {

    @SneakyThrows
    public static void main(String[] args) {

        // 方法表示执行动作
        // Runable # run()
        // Callable # call()
        // Action # execute()

        // 动词 + 形容词
        Stream.of(1, 2,3).forEachOrdered(System.out::println);

        // 动词 + 副词
        Lock lock = new ReentrantLock();
        try {
            lock.lockInterruptibly();
        } finally {
            lock.unlock();
        }

        //

    }

    // 动词 + 名词 或 动词+名词+副词
    public List<String> getValues() {
        return Collections.emptyList();
    }

    public List<String> getValusSynchronously() {
        return Collections.emptyList();
    }
}
