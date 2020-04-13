package 集合基础.基础总览;

/**
 * Created by zlj on 2019/9/5.
 */
public class CollectionDemo {

    public static void main(String[] args) {
        String[] strings = new String[]{"hello", "world"};

        copyOf(strings, strings);

        /**
         * 这里由Collection接口中的 size()方法 返回最大是Integer.maxValue引发的思考
         *  为什么size()方法最大返回了 Integer.maxValue
         *      因为返回值的类型是int  在java中很多设计的都是int 这和os位数相关
         *      int是4字节，32位 long、double是8字节 64位（在32位 os 中分高低位 操作不是线程安全的）
         *      因为int有最大值，所以int再+1 会是负数（符号位）
         */
        System.out.println(Integer.MAX_VALUE+1); // 输出负数


    }

    static void copyOf(Object[] src, Object[] des) {
        // System.arraycopy方法中的src和des之所以是object的，是因为要支持二维数据
        System.arraycopy(src, 0, des, 0, src.length);
    }
}
