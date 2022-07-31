import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author u
 * @version V1.0
 * @date 2022-06-14 13:00
 */
public class SingelThreadExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }

    }

}
