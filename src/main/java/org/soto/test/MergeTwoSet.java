package org.soto.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 合并表记录
 */
public class MergeTwoSet {

    /**
     * 描述
     * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
     *
     *
     * 提示:
     * 0 <= index <= 11111111
     * 1 <= value <= 100000
     *
     * 输入描述：
     * 先输入键值对的个数n（1 <= n <= 500）
     * 然后输入成对的index和value值，以空格隔开
     *
     * 输出描述：
     * 输出合并后的键值对（多行）
     * 示例：
     * 输入：
     * 4
     * 0 1
     * 0 2
     * 1 2
     * 3 4
     *
     * 输出：
     * 0 3
     * 1 2
     * 3 4
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        StreamTokenizer st = new StreamTokenizer(
                new BufferedReader(new InputStreamReader(System.in))
        );
        st.nextToken();
        int n = (int)st.nval;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(n);
        for (int i = 0;i < n;i++) {
            st.nextToken();
            int key = (int) st.nval;
            st.nextToken();
            int value = (int)st.nval;
            Integer exist = (Integer)map.get(key);
            if (null == exist) {
                map.put(key,value);
            } else {
                map.put(key,exist + value);
            }
        }

        StringBuilder sb = new StringBuilder();
        Set<Integer> keySet =  map.keySet();
        for(Integer index : keySet) {
            Integer value = map.get(index);
            if (value != 0) {
                sb.append(index).append(" ").append(value).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
