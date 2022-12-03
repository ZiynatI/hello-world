package org.helloworld.demo.linkedlist;


import java.util.Objects;

public class Pair<L, R> {
    public final L left;
    public final R right;

    public static void main(String[] args) {
        Pair<String, String> p = new Pair<>(null, null);
        Pair<String, String> b = new Pair<>("null", "null");
        System.out.println(p.equals(b));
    }

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    public <L2> Pair<L2, R> withLeft(L2 left2) {
        return new Pair<L2, R>(left2, right);
    }

    public <R2> Pair<L, R2> withRight(R2 right2) {
        return new Pair<L, R2>(left, right2);
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
