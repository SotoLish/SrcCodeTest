package org.soto.test;

/**
 * 字符串去空判断
 */
public class StringTrimTest {
    public static void main(String[] args) {
        String test = "   0 " +
                "\r\n\t1" +
                "\r\n\t2" +
                "\r\n\t3" +
                "\r\n\t4" +
                "\r\n\t5" +
                "\r\n\t6" +
                "  7  ";
        System.out.println(test);
        //System.out.println("分隔符");
        //System.out.println(test.trim());
        System.out.println("分隔符");
        System.out.println(test.replaceAll("\\s*"," "));
    }
}
