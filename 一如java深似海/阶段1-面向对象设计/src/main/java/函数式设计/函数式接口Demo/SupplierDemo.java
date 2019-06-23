package 函数式设计.函数式接口Demo;

import java.util.function.Supplier;

/**
 * Created by zlj on 2019/6/23.
 */
public class SupplierDemo {
    public static void main(String[] args) {


        Supplier<String> supplier = () -> "aaa";

        System.out.println(supplier.get());

        System.out.println(getTime().get());
    }

    public static Supplier<Long> getTime() {
        return System::currentTimeMillis;
    }
}
