package org.soto.test;

/**
 * @author: liuqixin
 * @date: 2020/12/21 16:00
 */
public class StringReplace {

    public static void main(String[] args) {
        String str1 = "http://172.16.2.178/download/";
        String str2 = "/app/download/dis_cache/userId/2020-11-12/1@123.json";
        String comStr = getCommomString(str1, str2);
        String result = str1.substring(0,str1.indexOf(comStr)) + str2.subSequence(str2.indexOf(comStr),str2.length());

//        System.out.println(getOverlapString(str1, str2));
//        System.out.println(str2.indexOf(comStr));
        System.out.println(result);
    }

    /**
     * 拼接重复字符串
     *
     * @param str1
     * @param str2
     * @return
     */
    public static final String getOverlapString(String str1, String str2) {
        //重叠的开始位置
        int index = -1;
        //重叠串的长度
        int len = 0;
        String result = "";
        //用前串控制外层循环,“指针”向右移动
        for (int i = 0; i < str1.length(); i++) {
            //判断右移过程“指针”位置的字符是否与后串的第一个字符匹配，需匹配才有重叠
            if (str1.charAt(i) == str2.charAt(0)) {
                index = i;
                len++;
                //如果前串的指针位置比后串的长度还要长，则退出，即没有重叠串
                if (str1.length() - i > str2.length()) {
                    index = -1;
                    break;
                }
                for (int j = 1; j < str1.length() - i; j++) {
                    //前后串移动匹配，找出最长重叠串
                    if (str1.charAt(i + j) == str2.charAt(j)) {
                        len++;
                    } else {
                        index = -1;
                        len = 0;
                        break;
                    }
                }
            }
        }
        if (index == -1) {
            result = null;
        } else {
            result = str1 + str2.substring(len);
        }
        return result;
    }


    /**
     * 最长公共子串
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String getCommomString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return "";
        }
        int start = 0;
        int maxLen = 0;
        int[][] table = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0 || j == 0) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        table[i][j] = 1;
                    }
                    if (table[i][j] > maxLen) {
                        maxLen = table[i][j];
                        start = i;
                    }
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        table[i][j] = table[i - 1][j - 1] + 1;
                    }
                    if (table[i][j] > maxLen) {
                        maxLen = table[i][j];
                        start = i + 1 - maxLen;
                    }
                }
            }
        }
        return s1.substring(start, start + maxLen);
    }
}
