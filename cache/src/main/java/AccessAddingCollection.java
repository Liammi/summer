import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author u
 * @version V1.0
 * @date 2022-08-12 23:31
 */
public class AccessAddingCollection {

    @Test
    public void getListSize() throws InterruptedException {
        List<String> lists = new ArrayList<>();

        CompletableFuture.runAsync(
                () -> {
                    for (int i = 0; i < 100000; i++) {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lists.add("test");
                    }
                }
        );

        for (int i = 0; i < 100000; i++) {
            Thread.sleep(300);
            System.out.println(lists.size());
        }
    }

}
