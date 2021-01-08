package org.soto.test;

/**
 * 异常传递给方法
 */
public class ExceptionToMethod {
    public static void main(String[] args) {
        outputException(new Exception("新的异常"));
    }
    public static void outputException(Exception e) {
        System.out.println(e.getMessage());
    }
}
