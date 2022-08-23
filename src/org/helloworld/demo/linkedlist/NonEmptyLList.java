package org.helloworld.demo.linkedlist;

public class NonEmptyLList<T> extends LList<T> {

    private final T head;
    private final LList<T> tail;

    public NonEmptyLList(T head, LList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T getHead() {
        return head;
    }

    @Override
    public LList<T> getTail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getLength() {
        return 1 + tail.getLength();
    }

    @Override
    public String toString() {
        return "(" + getHead().toString() + ", " + getTail().toString() + ")";
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof NonEmptyLList) {
            NonEmptyLList<?> that2 = (NonEmptyLList<?>) that;
            return this.head.equals(that2.head) &&
                    this.tail.equals(that2.tail);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.head.hashCode() + 13 * this.tail.hashCode();
    }
}
