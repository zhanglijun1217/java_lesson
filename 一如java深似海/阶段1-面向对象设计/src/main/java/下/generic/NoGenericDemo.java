package 下.generic;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型一个作用的demo
 * Created by zlj on 2019/6/15.
 */
public class NoGenericDemo {

    public static void main(String[] args) {

        // 不指定泛型的List 相当于List<Object>
        List list = new ArrayList();
        List<Object> objects = list;


        // 泛型带来编译时候的强类型检查
        //List<String> strings = objects; // 这行会编译 不通过 因为Object和String不一样

        // 注意 这个是编译通过的 type是代表所有的类型
        Type type = int.class;
        Class c = int.class;
    }
}
