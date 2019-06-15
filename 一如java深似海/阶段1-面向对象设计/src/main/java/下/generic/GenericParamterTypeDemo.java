package 下.generic;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

/**
 * 说明泛型参数类型的demo
 * <p>
 * Created by zlj on 2019/6/15.
 */
public class GenericParamterTypeDemo {

    public static void main(String[] args) {

        // 因为有单界限的 所以会编译限制
        // Container<Integer> a; // 编译不通过

        /**
         * 演示泛型一个 会造成写法上的瑕疵
         */
        // StringBuffer 是实现了 CharSequence 但是元素传进去可以是一个String String也是实现CharSequence 这里编译不会报错
        Container<StringBuffer> stringBufferContainer = new Container("HelloWorld"); // 这里不会去编译出错
        System.out.println(stringBufferContainer.getElement()); // 正常输出HelloWorld 但是这里显得有点瑕疵 没有报错是因为泛型运行时的擦写

//        stringBufferContainer.setElement("aaa"); // 这里会编译报错，因为stringBufferContainer是 定义为<StringBuffer>
        // 所以泛型还是起到了作用 在操作元素的时候 有强类型约束
        stringBufferContainer.setElement(new StringBuffer("aaa"));
        System.out.println(stringBufferContainer.getElement()); // 编译通过 输出aaa


        /**
         * 演示方法参数做泛型的一个灵活性
         */
        addElement(new ArrayList<>(),1);
        addElement(new ArrayList<>(), "3333");

//        addElement(new HashSet<>(), stringBufferContainer); //编译报错 因为element限制了上界

        // 循环输出
        foreachConsum(Arrays.asList(1, 2, 3, 4), System.out::println);



    }

    @AllArgsConstructor
    public static class Container<T extends CharSequence> {

        @Getter
        private T element;

        public void setElement(T e) {
            this.element = e;
        }
    }


    /**
     * 说明泛型的多边界限制的语法
     */
    class C {
    }

    interface I1 {
    }

    interface I2 {
    }

    // 这里看到泛型 可以 进行多边界约束设置
    // 设置规则： extends的第一个类型可以是具体类也可也是接口 但是第二个开始往后的参数必须是接口
    public class MutilyGenericLimit<T extends C & I1 & I2> {
    }

    // 泛型在方法参数中的引用 增强了灵活性
    public static <C extends Collection<E>, E extends Serializable> void addElement(C target, E element) {
        target.add(element);
    }

    public static <T extends Iterable<E>, E extends Number> void foreachConsum(T source, Consumer<E> consumer) {
        for (E e : source) {
            consumer.accept(e);
        }
    }

}
