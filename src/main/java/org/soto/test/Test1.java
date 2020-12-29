package org.soto.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuqixin
 * @date: 2020/12/10 19:21
 */
public class Test1 {

    public static void main(String[] args) {
        Father father = new Father();
        setFather(father);
        System.out.println(father);
    }

    public static void  setFather(Father father) {
        Integer integer = new Integer(1);
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(new Integer(1));
        integers.add(new Integer(2));
        father.setInteger(integer);
        father.setIntegers(integers);
    }


}
