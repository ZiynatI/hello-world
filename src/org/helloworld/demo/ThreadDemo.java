package org.helloworld.demo;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {

    static List<Integer> list = new ArrayList<>();

    private static synchronized void addElement(int i) {
        list.add(i);
    }

    public static void main(String[] args) throws Exception {
        new Thread(new MyNewRunnable()).start();
        new Thread(new MyNewRunnable()).start();
        new Thread(new MyNewRunnable()).start();
        new Thread(new MyNewRunnable()).start();
        new Thread(new MyNewRunnable()).start();
        Thread.sleep(1000);
        System.out.println(list.size());

        new MyNewRunnable().run();
    }

    private static class MyNewRunnable implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= 100000; ++i) {
                    addElement(i);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
