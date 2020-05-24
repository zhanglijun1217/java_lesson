package jvm小册.控制转移关键字的字节码;

/**
 * Created by zlj on 2020/5/24.
 *
 *   void findNear(int);
 *     descriptor: (I)V
 *     flags:
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: iload_1
 *          1: tableswitch   { // 101 to 106
 *                      101: 40
 *                      102: 51
 *                      103: 84  // 代码中并没有103 但是因为case间隔很小，switch对应的字节码助记符是tableswitch方式，为了使查找效率达到O(1)
 *                      104: 62
 *                      105: 84
 *                      106: 73
 *                  default: 84
 *             }
 *
 *         40: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         43: ldc           #3                  // String a▒▒101
 *         45: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         48: goto          92
 *
 *         51: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         54: ldc           #5                  // String a▒▒102
 *         56: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         59: goto          92
 *         62: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         65: ldc           #6                  // String a▒▒104
 *         67: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         70: goto          92
 *         73: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         76: ldc           #7                  // String a▒▒106
 *         78: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         81: goto          92
 *         84: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         87: ldc           #8                  // String sadadasd
 *         89: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 */
public class Switch_TableSwitch_Demo {
    void findNear(int a) {
        switch (a) {
            case 101:
                System.out.println("a是101");
                break;
            case 102:
                System.out.println("a是102");
                break;
            case 104:
                System.out.println("a是104");
                break;
            case 106:
                System.out.println("a是106");
                break;
                default:
                    System.out.println("sadadasd");
                    break;
        }
    }


    /**
     * 可以看到String也是会去检查case之间的间隔 （是通过hashcode方法检查的），如果间隔断层很小，则会采用tableswitch方式
     * 但是这里还看到hashcode之后是判断是否相等 得到一个int变量 存储在局部变量表3位置一个int值，然后又去走了一遍 0 1 2这三个tableswitch
     *
     *  void findString(java.lang.String);
     *     descriptor: (Ljava/lang/String;)V
     *     flags:
     *     Code:
     *       stack=2, locals=4, args_size=2
     *          0: aload_1
     *          1: astore_2
     *          2: iconst_m1
     *          3: istore_3
     *          4: aload_2
     *          5: invokevirtual #9                  // Method java/lang/String.hashCode:()I
     *          8: tableswitch   { // 65 to 68
     *                       65: 40
     *                       66: 54
     *                       67: 79   // 67对应C 代码中并没有C 但是因为使用了tableswitch
     *                       68: 68
     *                  default: 79
     *             }
     *         40: aload_2
     *         41: ldc           #10                 // String A
     *         43: invokevirtual #11                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
     *         46: ifeq          79
     *         49: iconst_0
     *         50: istore_3
     *         51: goto          79
     *
     *         54: aload_2
     *         55: ldc           #12                 // String B
     *         57: invokevirtual #11                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
     *         60: ifeq          79
     *         63: iconst_1
     *         64: istore_3
     *         65: goto          79
     *
     *         68: aload_2
     *         69: ldc           #13                 // String D
     *         71: invokevirtual #11                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
     *         74: ifeq          79
     *         77: iconst_2
     *
     *
     *         78: istore_3 // 将上面hashcode比较的结果变量 存放局部变量表3位置 在下面取出来再去进行一次tableswitch
     *
     *         79: iload_3
     *         80: tableswitch   { // 0 to 2
     *                        0: 108
     *                        1: 119
     *                        2: 130
     *                  default: 141
     *             }
     *        108: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *        111: ldc           #10                 // String A
     *        113: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *        116: goto          149
     *        119: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *        122: ldc           #12                 // String B
     *        124: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *        127: goto          149
     *        130: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *        133: ldc           #13                 // String D
     *        135: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *        138: goto          149
     *        141: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *        144: ldc           #14                 // String sdas
     *        146: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *        149: return
     * @param a
     */

    void findString(String a) {
        switch (a) {
            case "A":
                System.out.println("A");
                break;
            case "B":
                System.out.println("B");
                break;
            case "D":
                System.out.println("D");
                break;
                default:
                    System.out.println("sdas");
                    break;

        }
    }

    public static void main(String[] args) {
        System.out.println("A".hashCode());
    }
}
