package jvm.异常分析;

/**
 * 使用-Xss参数调整小 线程栈的大小 然后在单线程内递归。造成stackoverflow异常
 * vmargs -Xss128k
 */
public class JavaVMStackSOF {

    static int length = 1;

    static void stackLeak() {
        length ++;
        stackLeak();
    }

    public static void main(String[] args) {
        try {
            stackLeak();
        } catch (Throwable t) {
            System.out.println("stack legth: " + length); // 线程栈大小设置为128k，栈深度大概为1000左右
            throw t;
        }
    }
}
