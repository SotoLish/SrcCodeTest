package org.soto.test;

/**
 * 异常信息捕获
 * 有没有声明throws的区别
 */
public class ExceptionMsgCatch {
    public static void main(String[] args) {
        try {
            expTest1();
//            expTest2();
        } catch (Exception e) {
            System.out.println("--//--");
            System.out.println(e.getMessage());
            System.out.println("--//--");
            System.out.println(e.getStackTrace());
            System.out.println("--//--");
            System.out.println(e.fillInStackTrace());
            System.out.println("--//--");
            System.out.println(e.getLocalizedMessage());
            System.out.println("--//--");

            System.out.println(e);
            System.out.println("--//--");


            e.printStackTrace();
        }
    }

    public static void expTest1() throws Exception {
        throw new NullPointerException();
    }

    public static void expTest2() {
        int i =  1/0;
    }
}
