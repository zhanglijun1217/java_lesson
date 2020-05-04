package jvm小册.class文件结构;

/**
 * javap -v StringConstantTest
 *
 * Constant pool:
 *    #1 = Methodref          #5.#18         // java/lang/Object."<init>":()V
 *    #2 = String             #19            // hello world (这里指向的是常量池索引19的位置) 这个是常量项 CONSTANT_String_info
 *    ...
 *    #19 = Utf8               hello world  // 对应的CONSTANT_Utf8_info常量项
 */
public class StringContantTest {

    public final String s = "hello world";
}
