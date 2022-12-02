package org.helloworld.demo.linkedlist;

public class Pair<T, R> {
    public final T left;
    public final R right;

    public Pair(T left, R right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + ", " + right.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof Pair) {
            Pair<?, ?> that2 = (Pair<?, ?>) that;
            return that2.left.equals(this.left) && that2.right.equals(this.right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.right.hashCode() * 549 + this.left.hashCode() * 987;
    }

    ;
}
