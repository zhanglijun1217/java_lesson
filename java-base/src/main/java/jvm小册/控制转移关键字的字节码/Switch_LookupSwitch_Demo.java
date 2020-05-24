package jvm小册.控制转移关键字的字节码;

/**
 * Created by zlj on 2020/5/24.
 *
 * 对应的字节码：
 *
 *   void findA(int);
 *     descriptor: (I)V
 *     flags:
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: iload_1
 *          1: lookupswitch  { // 3  这里使用的是lookupswitch 因为case之间的断层比较大
 *                        1: 36
 *                       10: 47
 *                      100: 58
 *                  default: 69
 *             }
 *         36: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         39: ldc           #3                  // String a▒▒1
 *         41: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         44: goto          77
 *         47: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         50: ldc           #5                  // String a▒▒10
 *         52: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         55: goto          77
 *         58: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         61: ldc           #6                  // String a▒▒100
 *         63: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         66: goto          77
 *         69: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         72: ldc           #7                  // String adasda
 *         74: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 */
public class Switch_LookupSwitch_Demo {

    void findA(int a) {
        switch (a) {
            case 1:
                System.out.println("a是1");
                break;
            case 10:
                System.out.println("a是10");
                break;
            case 100:
                System.out.println("a是100");
                break;
                default:
                    System.out.println("adasda");
                    break;
        }
    }
}
