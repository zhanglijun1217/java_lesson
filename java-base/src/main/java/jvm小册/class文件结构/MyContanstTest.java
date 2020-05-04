package jvm小册.class文件结构;

/**
 *  boolean、byte、short 和 char 类型的变量 在常量池中会被当做int的结构来存储
 *  {
 *      tag : CONSTANT_Integer_info的tag （tag值是3）
 *      info:  具体的值
 *  }
 */
public class MyContanstTest {

    public final Boolean b = true;
    public final char c = 'A';
    public final byte by = 66;
    public final short s = 67;
    public final int i = 68;


}
