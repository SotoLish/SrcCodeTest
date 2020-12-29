package org.soto.test;

import java.util.List;

/**
 * @author: liuqixin
 * @date: 2020/12/10 19:21
 */
public class Father {

    private Integer integer;

    private List<Integer> integers;

    public Integer getInteger() {
        return integer;
    }

    public Father setInteger(Integer integer) {
        this.integer = integer;
        return this;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public Father setIntegers(List<Integer> integers) {
        this.integers = integers;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Father{");
        sb.append("integer=").append(integer);
        sb.append(", integers=").append(integers);
        sb.append('}');
        return sb.toString();
    }
}
