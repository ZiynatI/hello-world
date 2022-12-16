package org.helloworld.demo.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadDemo {

    static Integer acc = 0;

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = Collections.synchronizedList(list);
        Runnable r = () -> {
            for (int i = 0; i < 10000; i++) {
                incrementAcc();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(acc);
    }

    public static synchronized void incrementAcc() {
        acc = acc + 1;
    }

    public static void test(List<Integer> list) {

    }
}
