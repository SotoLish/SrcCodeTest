package org.soto.test;

/**
 * 字符串测试
 */
public class StringTest {

    public static void main(String[] args) {
        equalTest();
    }

    /**
     * 字符串==号判断的几种情况
     * 总结：
     */
    public static void equalTest() {
        String str1 = "str1";
        String str2 = new String("str1");
        String str3 = "str" + "1";
        String str4 = new String("str") + new String("1");
        System.out.println(str1 == str2); // false
        System.out.println(str1 == str3); // true
        System.out.println(str1 == str4); // false
        System.out.println(str2 == str3); // false
        System.out.println(str2 == str4); // false
        System.out.println(str3 == str4); // false
    }
}
