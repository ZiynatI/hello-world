package org.helloworld.demo.linkedlist;

public class Nil extends LList<Object>{

    public static Nil NIL = new Nil();

    public static <T>LList<T> nil() {
        return (LList<T>) NIL;
    }

    Nil() {}

    @Override
    public Object getHead() {
        throw new IllegalStateException("NIL has no head!");
    }

    @Override
    public LList<Object> getTail() {
        throw new IllegalStateException("NIL has no tail!");
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public String toString() {
        return "NIL";
    }

    @Override
    public boolean equals(Object that) {
        return that instanceof Nil;
    }

    @Override
    public int hashCode() {
        return 124165412;
    }
}
