import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * @author u
 * @version V1.0
 * @date 2022-04-04 21:23
 */
public class ThreeRegexModel {

    /**
     * 独占模式 xy{1,4}尽可能多的匹配了y的值，但是不进行回溯 导致y的值无法匹配
     */
    @Test
    void threeRegexModel() {
        Pattern greedyPattern = Pattern.compile("xy{1,3}z");
        Pattern lazyPattern = Pattern.compile("xy{1,3}?z");
        Pattern possessivePattern = Pattern.compile("xy{1,4}+yz");
        System.out.println("greedyPattern.matcher(\"xyyz\").matches() = " + greedyPattern.matcher("xyyz").matches());
        System.out.println("lazyPattern.matcher(\"xyyz\").matches() = " + lazyPattern.matcher("xyyz").matches());
        System.out.println("alongPattern.matcher(\"xyyz\").matches() = " + possessivePattern.matcher("xyyz").matches());
    }

}
