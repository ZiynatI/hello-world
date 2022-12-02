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
        return "(" + (left == null ? null : left.toString()) + ":" + (right == null ? null : right.toString()) + ")";
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof Pair) {
            Pair<?, ?> that2 = (Pair<?, ?>) that;
            assert this.left != null && this.right != null && that2.left != null && that2.right != null;
            return this.left.equals(that2.left) && this.right.equals(that2.right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.right == null ? 0 : this.right.hashCode()) * 549 + (this.right == null ? 0 : this.left.hashCode()) * 987;
    }
}
