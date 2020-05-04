package jvm小册.class文件结构;

/**
 * long和double常量在常量池中都占用两个索引值。
 *    #3 = Long               9223372036854775807l
 *    #5 = Fieldref           #6.#22         // jvm小册/LongConstantTest.num:J
 */
public class LongConstantTest {

    public final long num = Long.MAX_VALUE;
}
