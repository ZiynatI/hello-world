package org.helloworld.demo.linkedlist;


import java.util.Objects;

public class Pair<T, R> {
    public final T left;
    public final R right;

    public static void main(String[] args) {
        Pair<String, String> p = new Pair<>(null, null);
        Pair<String, String> b = new Pair<>("null", "null");
        System.out.println(p.equals(b));
    }

    public Pair(T left, R right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + String.valueOf(left) + "," + String.valueOf(this.right) + ")";
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof Pair) {
            Pair<?, ?> that2 = (Pair<?, ?>) that;
            return Objects.equals(this.left, that2.left) && Objects.equals(this.right, that2.right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.right == null ? 0 : this.right.hashCode()) * 549 + (this.right == null ? 0 : this.left.hashCode()) * 987;
    }
}
