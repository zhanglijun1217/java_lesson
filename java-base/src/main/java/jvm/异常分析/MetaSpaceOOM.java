package jvm.异常分析;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib操作动态类生成 演示元空间溢出（jdk1.8之后的元空间存储对应的类信息、运行时常量池（不包含字符串常量池））
 * vmargs：-XX:MaxMetaspaceSize=10m -XX:MetaspaceSize=5m
 *
 * 异常： Caused by: java.lang.OutOfMemoryError: Metaspace
 */
public class MetaSpaceOOM {

    static class MetaSpaceOOMObject {

    }

    public static void main(String[] args) {

        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MetaSpaceOOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invoke(obj, args);
                }
            });

            enhancer.create();
        }
    }
}
