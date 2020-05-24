package jvm小册.控制转移关键字的字节码;

import lombok.Data;

/**
 * Created by zlj on 2020/5/24.
 *
 * 对应的字节码：
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=3, locals=6, args_size=1
 *
 *       //   0-7 是new一个ScoreCalculator对象实例 并放在局部变量表的1位置
 *          0: new           #2                  // class jvmС▒▒/▒▒▒▒ת▒ƹؼ▒▒ֵ▒▒ֽ▒▒▒/ScoreCalculator
 *          3: dup
 *          4: invokespecial #3                  // Method jvmС▒▒/▒▒▒▒ת▒ƹؼ▒▒ֵ▒▒ֽ▒▒▒/ScoreCalculator."<init>":()V
 *          7: astore_1
 *
 *
 *          8: getstatic     #4                  // Field numbers:[I  获取静态变量numbers数组
 *         11: astore_2    // 数组放在局部变量2的位置
 *
 *         12: aload_2   // 将局部变量表2位置的数组加载到操作数栈的栈顶
 *         13: arraylength  // 获取数组的长度
 *         14: istore_3  // 数组长度存储在局部变量表3的位置
 *
 *         15: iconst_0  //  将0加载到操作数的栈顶 (相当于循环过程中的游标)
 *         16: istore        4 // 存储0到局部变量表4的位置
 *
 *         18: iload         4   // 将局部变量表4的位置的循环游标加载到栈顶  $i
 *         20: iload_3           // 将局部变量表3的位置 数组长度 加载至栈顶  $len
 *
 *         21: if_icmpge     43 // 判断操作：如果游标 $i 大于等于 数组长度 $len 则直接跳转到指令43 即return
 *              如果小于
 *         24: aload_2     // 加载局部变量表位置2的数组到栈顶
 *         25: iload         4 // 加载局部变量表位置4的游标到栈顶
 *         27: iaload          // 使用iaload指令将数组 $arr 下标为 $i 的元素放入栈顶
 *         28: istore        5 // 元素存储在局部变量表5的位置
 *
 *         30: aload_1        // 将局部变量表中的ScoreCalculator对象实例加载在栈顶
 *         31: iload         5  // 将数组下标位置的元素加载到栈顶
 *         33: i2d
 *         34: invokevirtual #5                  // Method jvmС▒▒/▒▒▒▒ת▒ƹؼ▒▒ֵ▒▒ֽ▒▒▒/ScoreCalculator.record:(D)V record方法调用
 *
 *
 *
 *         37: iinc          4, 1  // i++操作，这个指令比较特殊 不用操作入栈、操作数、出栈
 *         40: goto          18   // 跳转到指令18 继续循环中的判断操作
 *         43: return
 *       LineNumberTable:
 *         line 13: 0
 *         line 15: 8
 *         line 16: 30
 *         line 15: 37
 *         line 18: 43
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *            30       7     5 number   I
 *             0      44     0  args   [Ljava/lang/String;
 *             8      36     1 scoreCalculator   LjvmС▒▒/▒▒▒▒ת▒ƹؼ▒▒ֵ▒▒ֽ▒▒▒/ScoreCalculator;
 *
 */
public class ForLoopDemo {

    static int[] numbers = new int[]{1,2,3};

    public static void main(String[] args) {
        ScoreCalculator scoreCalculator = new ScoreCalculator();

        for (int number : numbers) {
            scoreCalculator.record(number);
        }
    }
}

@Data
class ScoreCalculator{
    public void record(double score) {}

    public double getAverage() {
        return 0;
    }
}
