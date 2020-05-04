package jvm小册.class文件结构;

import lombok.Data;

@Data
public class FieldsTest {

    private String aaa;
    private Integer b;
    private static final String hello = "hello world";

    private User user;
}

class User {

}
