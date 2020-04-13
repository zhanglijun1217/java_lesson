package segfault.javaBase.lesson1;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 泛型的一个描述demo
 * Created by zlj on 2019/5/27.
 */
public class GenericTypeDemo {
    /**
     * 泛型编译时不擦除。
     * 可以javap -v 看到class文件中还是有对应的泛型参数 S T
     * 只不过是在运行时擦除
     * @param <S>
     * @param <T>
     */
    public interface Converter<S, T extends Serializable> {
        T convert(S source);
    }

    /**
     * 泛型T 具有 继承性
     */
    public interface StringConverter<T extends Serializable> extends Converter<String, T> {}

    public static void main(String[] args) {

        /**
         * 泛型是通用类型的一个约束 运行时要擦除
         */
        Converter<Integer, String> stringConverter = new Converter<Integer, String>() {
            @Override
            public String convert(Integer source) {
                return Objects.toString(source);
            }
        };

        Converter<String, Integer> integerConverter = new Converter<String, Integer>() {
            @Override
            public Integer convert(String source) {
                return Integer.valueOf(source);
            }
        };

    }


    /**
     * 一个有意思的“重载” 这里会编译报错， 因为 规定可以不定义泛型的List接口参数赋值给 List<String>的参数，所以这里认为是 相同的参数 所以这里不算重载
     * 包括定义两个参数 一个List<String>  一个List<Integer> 也是编译不通过 不算重载
     */
//    private static void convert(List<String> value) {
//
//    }
//
//    private static void convert(List value) {
//
//    }
}
