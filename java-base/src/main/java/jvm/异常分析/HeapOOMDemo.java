package jvm.异常分析;

import java.util.ArrayList;
import java.util.List;

/**
 * 对应《深入理解jvm》书中的堆溢出demo
 * vmargs -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * 对应报错 java.lang.OutOfMemoryError: Java heap space
 */
public class HeapOOMDemo {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
