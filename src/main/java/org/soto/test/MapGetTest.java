package org.soto.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuqixin
 * @date: 2020/12/17 14:36
 */
public class MapGetTest {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String ,String>(){{
            put("1","1");
        }};
        String value = map.get("1");
        String value2 = map.get("2");
        System.out.println(value);
        System.out.println(value2);
    }
}
