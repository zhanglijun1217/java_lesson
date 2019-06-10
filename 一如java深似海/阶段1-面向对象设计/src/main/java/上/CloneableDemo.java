package 上;

import lombok.Getter;
import lombok.Setter;

/**
 * Cloneable接口的一个demo
 * Created by zlj on 2019/6/11.
 */
public class CloneableDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("潜拷贝");
        CloneableData cloneableData = new CloneableData();
        cloneableData.setVal(1);
        // 这里调用clone方法 的对象如果没有实现 标记型接口 Cloneable 那么这里会报错
        System.out.println("结果value为：" + cloneableData.clone().getVal());


        System.out.println("深拷贝");
        // 深浅拷贝的选择 其实 和 对象类型有关系
        DeepCloneableData deepCloneableData = new DeepCloneableData();
        deepCloneableData.setVal(cloneableData);
        // 如果这里是浅拷贝 那么DeepCloneData对象clone出来的内部 CloneData对象还是上边创建的对象，引用地址相同，这里传递了地址引用
        DeepCloneableData clone = deepCloneableData.clone();
        System.out.println("地址比较结果为：" + (clone.getVal() == cloneableData));

    }


    /**
     * 潜拷贝
     * 如果不实现Cloneable接口 上边调用会报错
     */
    @Getter
    @Setter
    private static class CloneableData
            implements Cloneable
    {
        private int val;

        /**
         * 实现Object.clone方法的优化
         * （1）访问限制 放开设置为public (Object默认实现是个浅拷贝）
         * （2） 优化返回值为目标类型
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        public CloneableData clone() throws CloneNotSupportedException {
             CloneableData copy = (CloneableData)super.clone();
             return copy;
        }
    }

    @Getter
    @Setter
    private static class DeepCloneableData
    implements Cloneable {
        /**
         * 包装类型的val
         */
        private CloneableData val;

        @Override
        public DeepCloneableData clone() throws CloneNotSupportedException {
            DeepCloneableData clone = (DeepCloneableData)super.clone();
            // value对象也去赋值 进行深拷贝
            clone.setVal(getVal().clone());
            return clone;
        }
    }
}
