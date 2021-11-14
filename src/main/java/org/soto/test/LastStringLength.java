package org.soto.test;

import java.util.Scanner;

/**
 * 字符串最后一个单词的长度
 */
public class LastStringLength {

    /**
     * 描述
     * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。
     * （注：字符串末尾不以空格为结尾）
     * 输入描述：
     * 输入一行，代表要计算的字符串，非空，长度小于5000。
     *
     * 输出描述：
     * 输出一个整数，表示输入字符串最后一个单词的长度。
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chs = s.toCharArray();
        int len = chs.length;
        int count = 0;
        int i = len - 1;
        char space = ' ';
        while(i >= 0 && chs[i] != space) {
            count++;
            i --;
        }

        System.out.println(count);
    }
}
