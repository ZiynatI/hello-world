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

    public static LList<Integer> rangeInclusive(int a, int b) {
        if (a == b) {
            return prepend(a, Nil.nil());
        } else {
            return prepend(a, rangeInclusive(a > b ? a - 1 : a + 1, b));
        }
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
//дальше - T maxBy(T -> Comparable), ищет максимальный элемент в списке используя функцию, считающую сравнимое значение каждого элементв
   public T maxBy(Function<> fn){

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

    //concat(list1, list2) - склеивает списки list1.concat(list2)
    public static <T> LList<T> concat(LList<? extends T> list1, LList<? extends T> list2) {
        if (list1.isEmpty()) {
            return (LList<T>) list2;
        } else {
            return LList.<T>prepend(list1.getHead(), LList.<T>concat(list1.getTail(), list2));
        }
    }

    public LList<T> reverse() {
        //                return fold(Nil.nil(), (acc, head) -> prepend(head, acc));
        return reverse(Nil.nil());
    }

    //и как разберёшься - сделай метод zip(list2), который из двух списков делает один список пар
    //(лишние элементы одного из списков отбрасываются)
    public <R> LList<Pair<T, R>> zip(LList<R> list2) {
        if (this.isEmpty() || list2.isEmpty()) {
            return Nil.nil();
        } else {
            return prepend(new Pair<T, R>(this.getHead(), list2.getHead()), this.getTail().zip(list2.getTail()));
        }
    }

    private LList<T> reverse(LList<T> acc) {
        if (this.isEmpty()) {
            return acc;
        } else {
            LList<T> nextAcc = prepend(this.getHead(), acc);
            return this.getTail().reverse(nextAcc);
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
            return prepend(head2, getTail().filter(pred));
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

        return LList.this.<Map<R, LList<T>>>foldRight(new HashMap<R, LList<T>>(), (T head, Map<R, LList<T>> map) -> {
            R result = fn.apply(head);
            map.put(result, LList.<T>prepend(head, map.getOrDefault(result, Nil.<T>nil())));
            return map;
        });
    }


    public LList<T> drop(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("int n can not be less than zero");
        } else if (n == 0) {
            return this;
        } else {
            return this.getTail().drop(n - 1);
        }
    }


    //если у нас список из 100 элементов, take(5) оставит 5 первых
    //на остальные 95 ему плевать
    public LList<T> take(int n) {
        if (this.isEmpty() || n == 0) {
            return Nil.nil();
        } else {
            return prepend(this.getHead(), this.getTail().take(n - 1));
        }
    }
    //теперь takeWhile/dropWhile
    //они будут брать/выбрасывать элементы, которые соответствуют предикату

    public LList<T> takeWhile(Predicate<T> predicate) {
        if (!predicate.test(this.getHead()) || this.isEmpty()) {
            return Nil.nil();
        } else {
            return prepend(this.getHead(), this.getTail().takeWhile(predicate));
        }
    }

    public LList<T> dropWhile(Predicate<T> predicate) {
        if (this.isEmpty() || !predicate.test(this.getHead())) {
            return this;
        } else {
            return this.getTail().dropWhile(predicate);
        }
    }

    public abstract String toString();

    public abstract boolean equals(Object that);

    public abstract int hashCode();
}
