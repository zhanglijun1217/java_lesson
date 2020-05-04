package jvm小册.class文件结构;

/**
 * 常量池中的常量项：CONSTANT_InvokeDynamic_info
 *
 * 对应反编译之后的结果：
 *    #3 = InvokeDynamic      #0:#28         // #0:run:()Ljava/lang/Runnable;  这里的#0指的是引导方法表中的第一个引导方法
 *      #28 = NameAndType        #33:#40        // run:()Ljava/lang/Runnable;
 * BootstrapMethods:
 *   0: #25 invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
 *     Method arguments:
 *       #26 ()V
 *       #27 invokestatic jvm小册/CONSTANT_InvokeDynamic_info_test.lambda$foo$0:()V
 *       #26 ()V
 */
public class CONSTANT_InvokeDynamic_info_test {
    public void foo() {
        new Thread(() -> {
            System.out.println("run");
        }).start();
    }
}
