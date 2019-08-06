package 命令行工具;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;


public class TestJVMParam {

    @SneakyThrows
    public static void main(String[] args) {
        new CountDownLatch(1).await();
    }
}

