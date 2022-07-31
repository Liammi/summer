import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author u
 * @version V1.0
 * @date 2022-06-14 13:15
 */
public class CachedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task());
        }

    }

}
