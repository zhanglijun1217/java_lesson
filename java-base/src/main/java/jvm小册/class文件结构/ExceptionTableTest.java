package jvm小册.class文件结构;

import java.io.IOException;

public class ExceptionTableTest {

    public ExceptionTableTest() {

    }

    static final String fb = "fb";
    public static void main(String[] args) {
        try {
            foo(fb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Deprecated
    static void foo(String a) throws IOException {

    }

}
