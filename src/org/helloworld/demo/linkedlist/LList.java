package org.helloworld.demo.linkedlist;

import java.util.HashMap;
import java.util.Map;
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

    public <R> R fold(R acc, BiFunction<R, T, R> fn) {
        if (this.isEmpty()) {
            return acc;
        } else {
            acc = fn.apply(acc, this.getHead());
            return this.getTail().fold(acc, fn);
        }
    }

    public LList<T> reverse() {
        //                return fold(Nil.nil(), (acc, head) -> prepend(head, acc));
        if (this.isEmpty()) {
            return Nil.nil();
        } else {
            LList<T> acc = prepend(this.getHead(),this.getTail().reverse());
            return prepend(this.getHead(),this.getTail().reverse());
        }
    }
    public <R> R foldRight(R acc, BiFunction<T, R, R> fn) {
        if (this.isEmpty()) {
            return acc;
        } else {
            return fn.apply(this.getHead(), this.getTail().foldRight(acc, fn));
        }
    }

    public String mkString(String separator) {
        StringBuilder sb = this.fold(new StringBuilder(""), (acc, element) -> acc.append(element).append(separator));
        return sb.delete(sb.length() - separator.length(), sb.length()).toString();
    }


    public LList<T> filter(Predicate<T> pred) {
        if (this.isEmpty()) {
            return Nil.nil();
        }
        T head2 = this.getHead();
        if (pred.test(head2)) {
            return  prepend(head2, getTail().filter(pred));
        } else {
            return getTail().filter(pred);
        }
    }

    //вот теперь держись)
    //сделай метод groupBy, который, получая функцию, будет разбивать список на несколько в зависимости от значения функции
    //грубо:
    //LList(1, 2, 3, 4, 5).groupBy(x -> x % 2) == Map(((0, LList(2, 4)), (1, LList(1, 3, 5)))
    public <R> Map<R, LList<T>> groupBy(Function<T, R> fn) {
        //        if (this.isEmpty()) {
        //            return new HashMap<>();
        //        } else {
        //            Map<R, LList<T>> map = this.getTail().groupBy(fn);
        //            T head = this.getHead();
        //            R result = fn.apply(head);
        //            map.put(result, prepend(head, map.getOrDefault(result, Nil.nil())));
        //            return map;
        //        }

        //да)
        //а теперь через foldRight
        //чтоб было понятней - foldRight делает почти то же, что ты сама написала, только гораздо меньшим количеством кода

        return this.foldRight(new HashMap<R, LList<T>>(), (T head,Map<R, LList<T>> map) ->  {
            R result = fn.apply(head);
            map.put(result, prepend(head, map.getOrDefault(result, Nil.nil())));
            return map;
        });
    }



    public abstract String toString();

    public abstract boolean equals(Object that);

    public abstract int hashCode();
}
