package org.soto.test;

/**
 * 获取最长公共前缀字串
 */
public class LongestCommonPrefixStr {

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
//        String[] strings = {"dog","rececar","car"};
        System.out.println(getLongestCommomStr(strings));
    }

    /**
     * 最长公共前缀子串
     * @return
     */
    public static String getLongestCommomStr(String[] strings) {
        StringBuilder result = new StringBuilder("");
        if (strings.length == 0) {
            return result.toString();
        }
        // 字符串数组长度
        int strsSize = strings.length;
        // 二维字符数组
        char[][] charss = new char[strsSize][];
        // 最短字符串长度
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strsSize; i++) {
            char[] chars = strings[i].toCharArray();
            charss[i] = chars;
            // 记录最短字符串长度
            if (chars.length < minLen) {
                minLen = chars.length;
                if (minLen == 0) {
                    return result.toString();
                }
            }

        }
        // 按列，从第0列到最短字符串的长度那一列
        for (int i = 0; i < minLen; i++) {
            // 该列第一个字符
            char start = charss[0][i];
            int j;
            for (j = 1; j < strsSize; j++) {
                // 下列存在不同的字符，直接返回已有前缀
                if (start != charss[j][i]) {
                    return result.toString();
                }
            }
            // 均匹配，添加该字符
            result.append(start);
        }
        return result.toString();
    }
}
