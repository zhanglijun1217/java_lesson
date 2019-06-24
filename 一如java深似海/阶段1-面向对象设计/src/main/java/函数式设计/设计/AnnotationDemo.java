package 函数式设计.设计;

/**
 * Created by zlj on 2019/6/24.
 */
@Demo(value = "demo")
public class AnnotationDemo {


    public static void main(String[] args) {
        // 注解其实是通过 代理实现的

        Demo annotation = AnnotationDemo.class.getAnnotation(Demo.class);
        // 获取了Demo anno
        System.out.println(annotation.value());
    }
}
