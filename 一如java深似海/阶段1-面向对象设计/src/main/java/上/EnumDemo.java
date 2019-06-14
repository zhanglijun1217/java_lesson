package 上;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 关于枚举设计的一个demo
 *
 * Created by zlj on 2019/6/12.
 */
public class EnumDemo {

    public static void main(String[] args) {
        // 输出 枚举类中的 Three
//        EnumClass.THREE.print();

        // 输出 枚举 中的名字、位置、输出所有枚举
        Arrays.stream(CountingEnum.values()).forEach(e -> {
            System.out.println("输出枚举中的顺序: " + e.ordinal() + "名字：" + e.name() + "value：" + e.getValue());
        });

        // 操作符 枚举 （抽象方法）
        System.out.println(OperationOptimize.PLUS.apply(1, 2));

        // 测试枚举类的自己写的values方法
        Arrays.stream(EnumClass.values()).forEach(System.out::println);
    }

}

/**
 * 实现加减 操作的枚举（其实这个不符合开闭原则，当加入新的操作之后，要在switch中加入对应的逻辑）
 * 看下边通过定义abstract方法 来符合开闭原则
 */
enum Opration {
    PLUS,
    DIVIDE
    ;
    public double apply(double x, double y) {
        switch (this) {

            case PLUS:
                return x + y;
            case DIVIDE:
                return x - y;
        }
        throw new AssertionError("unknown");
    }
}

/**
 * 通过抽象方法， 来实现加入新的操作的时候 能符合开闭原则，只关心自己操作符抽象的实现
 */
enum OperationOptimize {
    PLUS("+"){
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
    },
    DIVIDE("-") {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    }
    ;

    @Getter
    private String str;
    private OperationOptimize(String str) {
        this.str = str;
    }

    // 抽象方法
    public abstract int apply(int x, int y);
}

enum CountingEnum {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4)
    ;
    @Getter
    private int value;

    /** private */ CountingEnum (int value) {
        this.value =  value;
    }
}


/**
 * 模拟枚举类 (枚举类：在enum出现之前的表达 可枚举的含义的类)
 * 通常 private 构造函数
 * final class
 * private static final 本类型 成员
 *
 */

final class EnumClass {
    public static final EnumClass ONE = new EnumClass(1);
    public static final EnumClass TWO = new EnumClass(2);
    public static final EnumClass THREE = new EnumClass(3);
    public static final EnumClass FOUR = new EnumClass(4);

    @Getter
    @Setter
    private int value;

    private EnumClass(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EnumClass{" +
                "value=" + value +
                '}';
    }

    public void print() {
        System.out.println(this.toString());
    }

    /**
     * 为枚举类实现一个values方法
     */

    public static EnumClass[] values() {
        // 获取枚举类中所有字段
        return Stream.of(EnumClass.class.getDeclaredFields())
                // 过滤出 public static final的
                .filter(field -> {
                    // 修饰符
                    int modifiers = field.getModifiers();
                    return Modifier.isPublic(modifiers)
                            && Modifier.isStatic(modifiers)
                            && Modifier.isFinal(modifiers);
                })
                // 取出对应的字段值
                .map(field -> {
                    try {
                        return field.get(null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).toArray(EnumClass[]::new);
    }
}
