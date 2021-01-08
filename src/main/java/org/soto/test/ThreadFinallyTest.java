package org.soto.test;

import java.lang.reflect.AccessibleObject;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试中断线程时，try catch finally中的finally会不会执行
 */
public class ThreadFinallyTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {

            AtomicInteger atomicInteger = new AtomicInteger(0);
            @Override
            public void run() {

                try {
                    while (true) {
                        System.out.println(atomicInteger.getAndIncrement() + " Thread Sleeping ...");
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    System.out.println("Exception");
                    System.out.println(e);
                } finally {
                    System.out.println("Thread Finally execute .");
                }

            }
        };
        thread.start();
        // Thread.sleep(5000);
        // thread.interrupt();
        // thread.stop();

    }
}
