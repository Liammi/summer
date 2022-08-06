package chainOfResponsibility;

import java.util.Random;

/**
 * @author u
 * @version V1.0
 * @date 2022-08-06 23:04
 */
public class Handler {

    private final static Random RANDOM = new Random();
    private static int nextId = 1;
    private int id = nextId++;
    private Handler nextInChain;

    public void add(Handler next) {
        if (nextInChain == null) {
            nextInChain = next;
        } else {
            nextInChain.add(next);
        }
    }

    public void wrapAround(Handler root) {
        if (nextInChain == null) {
            nextInChain = root;
        } else {
            nextInChain.wrapAround(root);
        }
    }

    public void exexute(int num) {
        if (RANDOM.nextInt(4) != 0) {
            System.out.println(id + "   -busy");
            nextInChain.exexute(num);
        } else {
            System.out.println(id + "   -handled-   " + num);
        }
    }

}
