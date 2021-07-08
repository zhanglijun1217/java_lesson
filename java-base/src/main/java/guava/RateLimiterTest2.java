package guava;

import com.google.common.util.concurrent.RateLimiter;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class RateLimiterTest2 {

    public static void main(String[] args) {
        testSmoothBursty();
//        testSmoothBursty2();
//        testSmoothBursty3();
//        testSmoothWarmingUp();
    }

    static void testSmoothBursty() {
        RateLimiter rateLimiter = RateLimiter.create(2.0);
        for(int i = 0; i < 100; i++) {
            // 这里因为create是每秒2个的rateLimiter 这里获取令牌能做到比较平滑的每秒2个
            System.out.println("get one token cost" + rateLimiter.acquire() + "s");
        }
    }

    static void testSmoothBursty2() {
        RateLimiter rateLimiter = RateLimiter.create(0.5);
        rateLimiter.acquire();
        System.out.println("第一次获取令牌需要cost：" + rateLimiter.acquire() + "s"); // 第一次获取
        sleep(2000); // sleep 2秒 让令牌桶中充满令牌

        // 当桶中令牌数量足够时，acquire可以立即返回
        System.out.println("当桶中令牌数量足够时，acquire可以立即返回。这里cost：" + rateLimiter.acquire() + "s");

    }

    static void testSmoothBursty3() {
        // rateLimiter会累计令牌 对于直接请求多个令牌的请求可以立即返回，在没有足够的令牌时采用滞后处理 下个请求处理
        RateLimiter rateLimiter = RateLimiter.create(5.0);

        // 一次性获取5个令牌
        double acquire = rateLimiter.acquire(5);
        System.out.println("一次性获取5个令牌cost：" + acquire + "s");
        // 再次获取令牌
        double acquire1 = rateLimiter.acquire(1);
        System.out.println("再次获取（需要等待累计令牌）" + acquire1 + "s");
    }

    static void testSmoothWarmingUp() {
        /**
         * 测试带预热功能的rateLimiter 会在预热时间内频率越来越高，在预热时间到达后会到达正常的频率
         */
        RateLimiter rateLimiter = RateLimiter.create(2, 3, TimeUnit.SECONDS);
        for (int i = 0; i < 10; i ++) {
            if (i == 4) {
                System.out.println("预热结束");
            }
            // 预热结束之后 频率会和创建限流器的参数一致
            System.out.println("get 1 tokens: " + rateLimiter.acquire(1) + "s");
        }
    }

    @SneakyThrows
    static void sleep(int i) {
        Thread.sleep(i);
    }
}
