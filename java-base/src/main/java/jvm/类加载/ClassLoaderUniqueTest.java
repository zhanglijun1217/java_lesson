package jvm.类加载;

import lombok.SneakyThrows;

import java.io.InputStream;

public class ClassLoaderUniqueTest {

    /**
     * 类加载器和类 才确定 Class在jvm中的唯一性
     * 影响Class的equals、isAssignableFrom、isInstance、instanceof等
     *
     * 本身运行这个类中的main方法 会内置类加载器加载该test类 这时的ClassA 和 自定义类加载器加载的test类ClassB 不是一个class
     * @param args
     */
    @SneakyThrows
    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader parent = contextClassLoader.getParent();
        System.out.println(contextClassLoader);
        System.out.println("parent:" + contextClassLoader.getParent());

        ClassLoader myClassLoader = new ClassLoader() {
            // 一个自定义的类加载器
            @SneakyThrows
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                if (name == null) {
                    return super.loadClass(name);
                }

                int index = name.lastIndexOf(".") + 1;
                String fileName = name.substring(index) + ".class";

                InputStream resourceAsStream = getClass().getResourceAsStream(fileName);
                if (resourceAsStream == null) {
                    return super.loadClass(name);
                }

                byte[] bytes = new byte[resourceAsStream.available()];
                resourceAsStream.read(bytes);
                return defineClass(name, bytes, 0, bytes.length);
            }


            @Override
            public String toString() {
                return "自定义类加载器111111";
            }
        };

        String s = "jvm.类加载.ClassLoaderUniqueTest";
        Class<?> aClass = myClassLoader.loadClass(s);
        Object o = aClass.newInstance();

        System.out.println(o.getClass());
        System.out.println(o.getClass().getClassLoader()); // 是myClassLoader的toString方法
        System.out.println(o instanceof ClassLoaderUniqueTest); // false

        System.out.println(ClassLoaderUniqueTest.class);
        System.out.println(o.getClass().equals(ClassLoaderUniqueTest.class)); // false
        System.out.println(o.getClass().isInstance(ClassLoaderUniqueTest.class)); // false


        Class<?> aClass1 = Class.forName("jvm.类加载.ClassLoaderUniqueTest", true, myClassLoader);
        Object o1 = aClass1.newInstance();
        System.out.println(o1.getClass().getClassLoader());
        System.out.println(o.getClass().equals(o1.getClass())); // 输出true
    }
}
