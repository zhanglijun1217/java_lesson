package jvm小册.class文件结构;

import lombok.Getter;

/**
 * Constant pool:
 *    #1 = Methodref          #7.#31         // java/lang/Object."<init>":()V
 *    #2 = Class              #32            // jvm小册/NameAndTypeConstantPoolTest
 *    #3 = Methodref          #2.#31         // jvm小册/NameAndTypeConstantPoolTest."<init>":()V
 *    #4 = String             #33            // 233
 *    #5 = Methodref          #2.#34         // jvm小册/NameAndTypeConstantPoolTest.testMethod:(ILjava/lang/String;)V
 *    #6 = Fieldref           #2.#35         // jvm小册/NameAndTypeConstantPoolTest.field:I
 *    #7 = Class              #36            // java/lang/Object
 *    #8 = Utf8               field
 *    #9 = Utf8               I
 *   #10 = Utf8               <init>
 *   #11 = Utf8               ()V
 *   #12 = Utf8               Code
 *   #13 = Utf8               LineNumberTable
 *   #14 = Utf8               LocalVariableTable
 *   #15 = Utf8               this
 *   #16 = Utf8               Ljvm小册/NameAndTypeConstantPoolTest;
 *   #17 = Utf8               testMethod
 *   #18 = Utf8               (ILjava/lang/String;)V
 *   #19 = Utf8               i
 *   #20 = Utf8               s
 *   #21 = Utf8               Ljava/lang/String;
 *   #22 = Utf8               main
 *   #23 = Utf8               ([Ljava/lang/String;)V
 *   #24 = Utf8               args
 *   #25 = Utf8               [Ljava/lang/String;
 *   #26 = Utf8               nameAndTypeConstantPoolTest
 *   #27 = Utf8               getField
 *   #28 = Utf8               ()I
 *   #29 = Utf8               SourceFile
 *   #30 = Utf8               NameAndTypeConstantPoolTest.java
 *   #31 = NameAndType        #10:#11        // "<init>":()V
 *   #32 = Utf8               jvm小册/NameAndTypeConstantPoolTest
 *   #33 = Utf8               233
 *   #34 = NameAndType        #17:#18        // testMethod:(ILjava/lang/String;)V
 *   #35 = NameAndType        #8:#9          // field:I
 *   #36 = Utf8               java/lang/Object
 */
public class NameAndTypeConstantPoolTest {

    @Getter
    private int field;
    public void testMethod(int i, String s) {
    }


    public static void main(String[] args) {
        NameAndTypeConstantPoolTest nameAndTypeConstantPoolTest = new NameAndTypeConstantPoolTest();
        nameAndTypeConstantPoolTest.testMethod(1, "233");
    }
}
