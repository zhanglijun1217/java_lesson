package segfault.javaBase.lesson1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Callable;

/**
 * 内部类的demo
 * Created by zlj on 2019/6/8.
 */
public class InnerClassDemo {

    /**
     * 在构造函数中创建匿名内部类
     */
    public InnerClassDemo() {
        new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
    }

    // 在static block中创建
    static {
        new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    // 在实例 block中 创建 匿名内部类
    {
        Comparable<Object> comparable = new Comparable<Object>() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

    }

    public static void main(String[] args) {

        // Event Listener模式  可以在方法中创建匿名内部类
        PropertyChangeListener propertyChangeListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
            }
        };
    }
}
