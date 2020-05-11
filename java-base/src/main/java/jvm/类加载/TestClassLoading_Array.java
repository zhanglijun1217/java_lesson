package jvm.类加载;

/**
 * Created by zlj on 2020/5/11.
 *
 * 对于数组来说 其类型是jvm在运行时动态生成的 类型为class [Ljvm.类加载.ArrayItem;
 * 这样其实不会主动调用ArrayItem这个类 所以并不会初始化static中的代码
 */
public class TestClassLoading_Array {


    public static void main(String[] args) {

        ArrayItem[] arrayItems = new ArrayItem[22]; // 助记符是anewarray 表示创建引用类型的数组，并且把其引用推到栈顶
        System.out.println(arrayItems.getClass());

        int[] ints = new int[2]; // 助记符是newarray 表示原生类型的数组，并且把其引用推到栈顶
        System.out.println(ints.getClass());
    }
}
class ArrayItem {

    static {
        System.out.println("ArrayItem 初始化了...");
    }
}
