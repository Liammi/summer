import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author u
 * @version V1.0
 * @date 2022-08-12 23:43
 */
public class CacheManager {

    private volatile List<String> strings = new ArrayList<>();
    private volatile boolean isLoading = false;
    private int anInt = 0;
    private final Object object = new Object();

    public void loadCache(List<String> stringList) {

//        synchronized (object) {
//            if (!isLoading) {
//                isLoading = true;
//            }
//        }
//        anInt = anInt + 1;
//
//        isLoading = false;

        strings = stringList;

    }

    public void loadIntCache(int num) {

        synchronized (object) {
            if (!isLoading) {
                isLoading = true;
            }
        }
//        anInt = anInt + 1;
        anInt = num;


        isLoading = false;


    }

    public static void main(String[] args) throws InterruptedException {
        CacheManager cacheManager = new CacheManager();
        for (int i = 0; i < 1000; i++) {
//            cacheManager.loadCache(new ArrayList<>());
            cacheManager.loadIntCache(1);
        }
        CompletableFuture.runAsync(
                () -> {
                    for (int i = 0; i < 1000; i++) {
//                        cacheManager.loadCache(new ArrayList<>());
                        cacheManager.loadIntCache(2);
                    }
                }
        );
        CompletableFuture.runAsync(
                () -> {
                    for (int i = 0; i < 1000; i++) {
//                        cacheManager.loadCache(new ArrayList<>());
                        cacheManager.loadIntCache(3);
                    }
                }
        );
        CompletableFuture.runAsync(
                () -> {
                    for (int i = 0; i < 1000; i++) {
//                        cacheManager.loadCache(new ArrayList<>());
                        cacheManager.loadIntCache(4);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        CompletableFuture.runAsync(
                () -> {
                    for (int i = 0; i < 1000; i++) {
//                        cacheManager.loadCache(new ArrayList<>());
                        cacheManager.loadIntCache(5);
                    }
                }
        );
        Thread.sleep(1000);
        System.out.println(cacheManager.anInt);
    }

}
