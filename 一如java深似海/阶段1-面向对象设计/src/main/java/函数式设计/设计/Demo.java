package 函数式设计.设计;

import java.lang.annotation.*;

/**
 * Created by zlj on 2019/6/24.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // TYPE 表示类、接口、枚举的作用范围
public @interface Demo {

    String value();
}
