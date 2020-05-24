package jvm小册.控制转移关键字的字节码;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * switch-case 枚举的原理
 *
 * 会生成一个该类的子类，Switch_EnumSwitch_Demo$1.class，
 * 其中有个字段了一个int[]数组，然后在staic代码块中初始化这个数组为枚举values返回数组的长度，
 * 并且以每个枚举的ordinal方法作为数组下标，值为1,2,3这样 递增。$1子类对应的伪代码：
 * static class MyLoopTest$1 {
 *
 * 		static final int[] $SwitchMap$Color;
 *
 * 		static {
 * 			Color[] values = Color.values();
 * 			int length = values.length;
 * 			$SwitchMap$Color = new int[length];
 *
 * 			try {
 * 				$SwitchMap$Color[Color.RED.ordinal()] = 1;	//和switch中的case 1对应
 *                        } catch (NoSuchFieldError e) {
 *            }
 *
 * 			try {
 * 				$SwitchMap$Color[Color.BLUE.ordinal()] = 2; //和switch中的case 2对应
 *            } catch (NoSuchFieldError e) {
 *            }
 *
 * 			try {
 * 				$SwitchMap$Color[Color.YELLOW.ordinal()] = 3; //和switch中的case 3对应
 *            } catch (NoSuchFieldError e) {
 *            }
 ** 		}
 * 	}
 *
 * 	然后在switch枚举的地方，直接使用的是这个子类维护的静态数组，然后以iaload指令去数组中取 当前要switch判断的枚举的ordinal值
 * 	对应下标在数组中的值，然后判断其值去实现对应的case。
 * 	如果case的值是全部枚举值，那么编译器会使用tableswitch，如果不是全部枚举值，那么会使用lookupswitch。
 *
 */
@SuppressWarnings("all")
public class Switch_EnumSwitch_Demo {

    @Getter
    @AllArgsConstructor
    enum Color {
        red,
        blue,
        black,
        white
        ;

    }

    // case中有全部枚举的  会使用tableswitch
    void findByEnumAll(Color color) {
        switch (color) {
            case red:
                System.out.println("red");
                break;
            case blue:
                System.out.println("blue");
                break;
            case black:
                System.out.println("black");
                break;
            case white:
                System.out.println("white");
                break;
                default:
                    System.out.println("default");
                    break;
        }
    }


    //case中只有部分枚举的 会使用lookupswitch
    /**
     *        0: getstatic     #2                  // 获取子类中 静态数组 名字：$stackMap$Color 类型int[] 下标是枚举中的ordinal值，value是1,2,3递增的常量
     *        3: aload_1                           // load方法参数到操作数栈栈顶 即当前要判断的枚举
     *        4: invokevirtual #3                  // 调用参数枚举的 ordinal方法
     *        7: iaload                             // iaload指令取数组下标的值 即 $stackMap$Color[ordinal] 然后加载到栈顶
     *        8: lookupswitch  { // 2               // 因为case范围不是全部枚举值，所以使用的是lookupswitch
     *                      1: 36
     *                      4: 47
     *                default: 58
     *           }
     * @param color
     */
    void findByEnumPart(Color color) {
        switch (color) {
            case red:
                System.out.println("red");
                break;
            case white:
                System.out.println("white");
                break;
            default:
                System.out.println("default");
                break;
        }
    }

}
