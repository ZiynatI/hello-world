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
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        } else if (this.getTail().isEmpty()) {
            return this.getHead();
        } else {
            T head = getHead();
            T reducedTail = getTail().reduce(fn);
            return fn.apply(head, reducedTail);
        }
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

    public T fold(T arg, BiFunction<T, T, T> fn) {
        if (arg != null) {
            T head = fn.apply(this.getHead(), arg);
            return prepend(head, this.getTail()).fold(null, fn);
        } else {
            if (this.isEmpty()) {
                throw new IllegalStateException("List is empty");
            } else if (this.getTail().isEmpty()) {
                return this.getHead();
            } else {
                T head = fn.apply(this.getHead(), this.getTail().getHead());
                LList<T> newList = prepend(head, this.getTail().getTail());
                return newList.fold(null, fn);
            }
        }
    }

    public abstract String toString();

    public abstract boolean equals(Object that);

    public abstract int hashCode();
}
