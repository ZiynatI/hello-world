package org.helloworld.demo.linkedlist;

import java.util.function.BiFunction;
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

    public T reduce(BiFunction<T, T, T> fn) {
        return this.getTail().fold(this.getHead(), fn);
    }

    public <R> R fold(R arg, BiFunction<R, T, R> fn) {
        if (this.isEmpty()) {
            return arg;
        } else {
            arg = fn.apply(arg, this.getHead());
            return this.getTail().fold(arg, fn);
        }
    }

    public LList<T> reverse() {
        BiFunction<T,T,LList<T>> fn =
       return this.fold(Nil.nil(),)
    }

    public LList<T> filter(Predicate<T> pred) {
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


    public abstract String toString();

    public abstract boolean equals(Object that);

    public abstract int hashCode();
}
