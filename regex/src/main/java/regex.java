import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author u
 * @version V1.0
 * @date 2022-04-03 19:16
 */
public class regex {

    /**
     * 传入的\反斜杠在JAVA中用于字符串转义
     */
    @Test
    public void PatternAndMatcher() {
        Pattern pattern = Pattern.compile("\\w+");
        System.out.println("pattern.pattern() = " + pattern.pattern());
    }

    /**
     * {@link Pattern#split(java.lang.CharSequence)}
     * 该方法用于分割字符串并且返回一个String[]
     * {@link String#split(java.lang.String)}
     * 该方法也用于分割字符串并且返回一个String[]
     * - 注意该方法内部的实现其实为Pattern.split只是内部做了转换 省略了构造正则表达式的步骤
     */
    @Test
    public void PatternSplit() {
        String testStr = "我的QQ是:123424，我的邮箱是234234@163.com";
        Pattern pattern = Pattern.compile("\\d+");// \d匹配所有数字
        Arrays.stream(pattern.split(testStr)).forEach(System.out::println);
        Arrays.stream(testStr.split("\\d+")).forEach(System.out::println);
    }

    /**
     * {@link Pattern#matches(java.lang.String, java.lang.CharSequence)}
     * 该方法为一个静态方法，只需要传入正则表达式,需匹配的字符串，用于快速匹配字符串，该方法只适用于匹配一次，并且匹配全部字符串
     */
    @Test
    public void patternMatcherStatic() {
        System.out.println("Pattern.matches(\"\\\\d+\", \"2223\") = " + Pattern.matches("\\d+", "2223"));
        System.out.println("Pattern.matches(\"\\\\d+\", \"2223d\") = " + Pattern.matches("\\d+", "2223d"));
        System.out.println("Pattern.matches(\"\\\\d+\", \"d2223\") = " + Pattern.matches("\\d+", "d2223"));
    }

    /**
     * {@link Pattern#matcher(java.lang.CharSequence)}返回一个Matcher对象 可以使用Matcher.matches进行匹配
     * Pattern.matches的静态方法底层实现也是该方法
     */
    @Test
    public void patternMatcher() {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("22333");
        System.out.println("matcher.pattern() = " + matcher.pattern());
        System.out.println("matcher.matches() = " + matcher.matches());
    }

}
