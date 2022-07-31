import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author u
 * @version V1.0
 * @date 2022-06-14 13:24
 */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        // 延迟5S执行任务
        scheduledExecutorService.schedule(new Task(), 5, TimeUnit.SECONDS);
        // 以一定频率 延迟1S 每隔3秒执行
        scheduledExecutorService.scheduleAtFixedRate(new Task(), 1, 3, TimeUnit.SECONDS);

    }

}
