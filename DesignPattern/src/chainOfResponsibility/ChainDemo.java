package chainOfResponsibility;

/**
 * @author u
 * @version V1.0
 * @date 2022-08-06 23:30
 */
public class ChainDemo {

    public static void main(String[] args) {
        Handler rootChain = new Handler();
        rootChain.add(new Handler());
        rootChain.add(new Handler());
        rootChain.add(new Handler());
        rootChain.wrapAround(rootChain);
        for (int i = 0; i < 6; i++) {
            System.out.println("Operation #" + i + ":");
            rootChain.exexute(i);
            System.out.println();
        }
    }

}
