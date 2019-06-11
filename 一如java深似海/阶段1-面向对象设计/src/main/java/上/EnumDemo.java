package 上;

import lombok.Getter;
import lombok.Setter;

/**
 * 关于枚举设计的一个demo
 *
 * Created by zlj on 2019/6/12.
 */
public class EnumDemo {

    public static void main(String[] args) {

    }


}

/**
 * 模拟枚举类 (枚举类：在enum出现之前的表达 可枚举的含义的类)
 * 通常 private 构造函数
 * final class
 * private static final 本类型 成员
 *
 */

final class EnumClass{
    private static final EnumClass ONE = new EnumClass(1);
    private static final EnumClass TWO = new EnumClass(2);
    private static final EnumClass THREE = new EnumClass(3);
    private static final EnumClass FOUR = new EnumClass(4);

    @Getter
    @Setter
    private int value;
    private EnumClass(int value) {
        this.value = value;
    }

}
