package startegy;

/**
 * @author u
 * @version V1.0
 * @date 2022-07-31 16:16
 */
public class Breeder {

    public static void main(String[] args) {
        new Duck(new FastFlyBehavior()).fly();
        new Duck(new SlowFlyBehavior()).fly();
    }

}
