package jvm小册.栈的执行;

import lombok.Data;

/**
 * Created by zlj on 2020/5/20.
 *
 * 对应的字节码：
 *    public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=3, locals=6, args_size=1 // locals为6 原因是存储args、scoreCalculator、score1、score2、average 但是average是double，所以花两个位置存储
 *          0: new           #2                  // class jvmС▒▒/ջ▒▒ִ▒▒/ScoreCalculator
 *          3: dup
 *          4: invokespecial #3                  // Method jvmС▒▒/ջ▒▒ִ▒▒/ScoreCalculator."<init>":()V
 *          7: astore_1    // 将scoreCalculator局部变量去存储在局部变量表1的位置
 *
 *          8: iconst_1 // 整数1加载到栈顶
 *          9: istore_2 // 栈顶元素移除 整数1加载到局部变量表2的位置
 *         10: iconst_2 // 整数2加载到栈顶
 *         11: istore_3 // 栈顶元素移除 整数2加载到局部变量表3的位置
 *
 *
 *         12: aload_1 // 加载局部变量表1位置的局部变量到操作数栈的栈顶，也就是scoreCalculator对象
 *         13: iload_2 // 加载局部变量表2位置的局部变量到栈顶， 也就是整数1
 *         14: i2d     // int类型转double 重新入栈
 *         15: invokevirtual #4  // 调用record方法                 // Method jvmС▒▒/ջ▒▒ִ▒▒/ScoreCalculator.record:(D)V
 *
 *
 *
 *         18: aload_1
 *         19: iload_3
 *         20: i2d
 *         21: invokevirtual #4                  // Method jvmС▒▒/ջ▒▒ִ▒▒/ScoreCalculator.record:(D)V
 *
 *
 *
 *         24: aload_1 // 加载局部变量表1位置的局部变量到操作数栈的栈顶，也就是scoreCalculator对象
 *         25: invokevirtual #5                  // Method jvmС▒▒/ջ▒▒ִ▒▒/ScoreCalculator.getAverage:()D
 *         28: dstore        4 // 存入下标位置为4的局部变量表中（double类型局部变量会占用两个位置）
 *         30: return
 *       LineNumberTable:
 *         line 52: 0
 *         line 53: 8
 *         line 54: 10
 *         line 56: 12
 *         line 57: 18
 *         line 60: 24
 *         line 62: 30
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      31     0  args   [Ljava/lang/String;
 *             8      23     1 scoreCalculator   LjvmС▒▒/ջ▒▒ִ▒▒/ScoreCalculator;
 *            10      21     2 score1   I
 *            12      19     3 score2   I
 *            30       1     4 average   D
 * }
 *
 */
public class ScoreCalculatorDemo {

    public static void main(String[] args) {

        ScoreCalculator scoreCalculator = new ScoreCalculator();
        int score1 = 1;
        int score2 = 2;

        scoreCalculator.record(score1);
        scoreCalculator.record(score2);


        double average = scoreCalculator.getAverage();

    }

}

@Data
class ScoreCalculator{
    public void record(double score) {}

    public double getAverage() {
        return 0;
    }
}
