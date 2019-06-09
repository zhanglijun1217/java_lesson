package 上;

import java.lang.reflect.Field;

/**
 * Created by zlj on 2019/6/10.
 */
public class StringTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        // 将String常量化的写法  这里的常量是一种语法特性，对象常量化
        String v1 = "Hello";

        // 面向对象的写法
        String v2 = new String("Hello");


        /**
         * String类中的 char[]变量设置为final 那么真的是不不能改的吗？
         * 当然不是了 反射来一把 尝试将v2修改掉
         */
        System.out.println("反射修改之前：v1: " + v1 + " v2:" + v2);
        Field stringValue = String.class.getDeclaredField("value");
        // 获取private 属性
        stringValue.setAccessible(true);
        // 替换
        stringValue.set(v2, "world".toCharArray());

        System.out.println("反射修改之后：v1: " + v1 + " v2:" + v2);

    }


    // 可以自定义一个可继承的String类
    private static class ExtendableString{
        private final char value[];

        /** Cache the hash code for the string */
        private int hash; // Default to 0


        private ExtendableString(char[] value) {
            this.value = value;
        }

        // equals 和 hashCode方法 如果可被继承 那么 有可能会被覆写
        /**
         * public boolean equals() {}
         * public int hashCode {}
         */
    }
}
