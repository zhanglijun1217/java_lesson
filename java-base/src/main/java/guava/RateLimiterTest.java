package guava;

import com.google.common.util.concurrent.RateLimiter;
import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class RateLimiterTest {

    static AtomicLong counter = new AtomicLong(0);
    static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static void main(String[] args) {
        // RateLimiter使用令牌桶算法来实现控制一定速率的限流
        final RateLimiter rateLimiter1 = RateLimiter.create(5.0, 2, TimeUnit.SECONDS);// 这里2.0是吞吐率 代表每秒多少许可数
        final RateLimiter rateLimiter2 = RateLimiter.create(5000.0, 2, TimeUnit.SECONDS); // 预热时间内许可平稳增长到最大

        System.out.println(rateLimiter1); // 输出RateLimiter[stableRate=2.0qps]
        System.out.println(rateLimiter2);

        sleep(3000);
        for (int i = 0; i < 1000; i++) {
            long begin = System.currentTimeMillis();
            if (rateLimiter1.tryAcquire(1)) {
                System.out.println("获取许可成功。任务-" + counter.getAndIncrement() + "耗时" + (System.currentTimeMillis() - begin));
//                sleep(1000); // 这里1s会让令牌桶中增加令牌
            }
        }
    }


    public static class Task {
        private final int mileSecond;
        public Task(int mileSecond) {
            this.mileSecond = mileSecond;
        }
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在运行");
            sleep(mileSecond);
        }
    }

    @SneakyThrows
    static void sleep(int mileSeconds) {
        Thread.sleep(mileSeconds);
    }
}
