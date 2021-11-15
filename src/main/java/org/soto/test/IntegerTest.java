package org.soto.test;

/**
 * 整数测试
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 129;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));

    }
}
