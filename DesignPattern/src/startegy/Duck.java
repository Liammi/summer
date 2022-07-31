package startegy;

/**
 * @author u
 * @version V1.0
 * @date 2022-07-31 16:11
 */
public class Duck {

    private FlyBehavior flyBehavior;

    public Duck(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void fly() {
        flyBehavior.fly();
    }

}
