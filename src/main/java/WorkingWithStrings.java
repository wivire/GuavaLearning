import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;

import java.io.UnsupportedEncodingException;

/**
 * 代码来自“ http://blog.csdn.net/wenniuwuren”
 */
public class WorkingWithStrings {

    public static void main(String[] args) throws UnsupportedEncodingException {

        // 问题： 1."UTF-8"必须在Java平台中被支持    2.人工敲入会有偏差
        // byte[] bytes = "foo".getBytes("UTF-8");
        // 解决： Charsets类提供了对Java平台支持字符集
        byte[] bytes = "foo".getBytes(Charsets.UTF_8);


        // 问题： 使用StringBuilder类连接字符串太繁琐， 代码其实都是重复的
        // 解决： Strings类封装了连接字符串的统一代码
        System.out.println("padEnd");
        String stringsTest = Strings.padEnd("foo", 6, 'o');
        System.out.println(stringsTest);

        // 在String作为参数时，将null转换成""   防止空指针问题
        System.out.println("nullToEmpty");
        String nullToEmptyTest1 = Strings.nullToEmpty("123");
        String nullToEmptyTest2 = Strings.nullToEmpty(null);
        System.out.println(nullToEmptyTest1 + "--" + nullToEmptyTest2);

        // ""转null
        System.out.println("emptyToNull");
        String emptyToNullTest1 = Strings.emptyToNull("123");
        String emptyToNullTest2 = Strings.emptyToNull("");
        System.out.println(emptyToNullTest1 + "--" + emptyToNullTest2);

        // 将字符串中的Tab和多个空格转为一个空格
        String tabsAndSpaces = "String with   spaces   and tabs";
        String expected = "String with spaces and tabs";
        String scrubbed = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces,' ');
        System.out.println(expected.equals(scrubbed));



        // Object utilities 对象工具
        // 1. toString()实现
        System.out.println(Objects.toStringHelper(WorkingWithStrings.class).omitNullValues()
                .add("expected", expected).add("tabsAndSpaces", tabsAndSpaces));

        // 2. 检查如果为null值 , 填充默认值
        System.out.println(Objects.firstNonNull(null, "default value"));

        // 3. 生成hashcode
        System.out.println(Objects.hashCode(tabsAndSpaces, expected));

        // 4. CompareTo实现    如果都是相同的返回0，有一个不同返回-1
        System.out.println(ComparisonChain.start().compare(tabsAndSpaces, expected).compare(expected, scrubbed).result());
    }
}
