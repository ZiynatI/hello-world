package org.helloworld.demo.linkedlist;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class LList<T> {
    static <T2> LList<T2> prepend(T2 head, LList<T2> tail) {
        return new NonEmptyLList<>(head, tail);
    }

    abstract public T getHead();

    abstract public LList<T> getTail();

    abstract public boolean isEmpty();

    abstract public int getLength();

    public <R> LList<R> map(Function<T, R> fn) {
        if (this.isEmpty()) {
            return Nil.nil();
        } else {
            R head2 = fn.apply(this.getHead());
            return prepend(head2, this.getTail().map(fn));
        }
    }

    public LList<T> filter(Predicate<T> pred) {
//        pred.test(x) == true
        if (this.isEmpty()) {
            return Nil.nil();
        }
        T head2 = this.getHead();
        if (pred.test(head2)) {
            return prepend(head2, getTail().filter(pred));
        } else {
            return getTail().filter(pred);
        }
    }


    abstract public String toString();

    abstract public boolean equals(Object that);

    abstract public int hashCode();
}
