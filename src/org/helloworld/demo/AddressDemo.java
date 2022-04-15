package org.helloworld.demo;

public class AddressDemo {
    public static void main(String[] args) {
        testObjectWrapper();
    }

    public static void testPrimitive() {
        int qwe = 1;
        func1(qwe);
        System.out.println(qwe);
    }

    public static void testObjectWrapper() {
        Wrapper wrapper = new Wrapper();
        wrapper.qwe = 1;
        func2(wrapper);
        System.out.println(wrapper.qwe);
    }

    public static void func1(int x) {
        x = 2;
    }

    public static void func2(Wrapper w) {
        w.qwe = 2;
    }

    public static class Wrapper {
        public int qwe;
    }
}
