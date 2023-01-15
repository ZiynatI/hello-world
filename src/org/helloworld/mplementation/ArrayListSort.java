package org.helloworld.mplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListSort {
    private static final Helper<Integer, int[]> INT_HELPER = new IntArrayHelper();

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 2, 5, 4};
        Integer[] arr2 = {3, 1, 2, 5, 4};
        List<Integer> list = new ArrayList<>(Arrays.asList(arr2));

        sort(arr1);
        System.out.println(Arrays.toString(arr1));

        sort(arr2);
        System.out.println(Arrays.toString(arr2));

        sort(list);
        System.out.println(list);

    }

    //вот у тебя функция, что-то типа void sort(X list)
    //пусть она первый элемент с последним местами меняет
    //и пусть она работает для массивов и для листов
    //а ничего другое в неё передать не должен позволить компилятор
    //это довольно не тривиальная задача, и потребуется сопутствующий код
    //но решаемо
    //ну, типа
    //sort(new int[]{1, 2, 3}); // Compiled OK
    //sort(Arrays.asList(1, 2, 3)); // Compiled OK
    //sort(1); // Compilation failure
    //sort(new HashMap()); // Compilation failure
    //имей в виду, это не особо тривиальная проблема
    //если ты раньше такого не видела, придумать будет сложно)
    //но всё необходимое ты уже знаешь
    //у любого массива есть один единственный предок - Object
    //так что частью одной иерархии массивы и листы можно сказать не являются)

    public static <T> void sort(List<T> list) {
        Helper<T, List<T>> helper = new ListHelper<T>();
        sort(list, helper);
    }

    public static <T> void sort(T[] arr) {
        Helper<T, T[]> helper = new ArrayHelper<T>();
        sort(arr, helper);
    }

    public static void sort(int[] arr) {
        sort(arr, INT_HELPER);
    }


    public static <V, C> void sort(C coll, Helper<V, C> helper) {
        V temp = helper.get(coll, 0);
        int length = helper.size(coll);
        helper.set(coll, 0, helper.get(coll, length - 1));
        helper.set(coll, length - 1, temp);
    }

    private interface Helper<V, C> {
        V get(C coll, int idx);

        void set(C coll, int idx, V val);

        int size(C coll);
    }

    private static class ListHelper<T> implements Helper<T, List<T>> {
        @Override
        public T get(List<T> coll, int idx) {
            return coll.get(idx);
        }

        @Override
        public void set(List<T> coll, int idx, T val) {
            coll.set(idx, val);
        }

        @Override
        public int size(List<T> coll) {
            return coll.size();
        }
    }

    private static class ArrayHelper<T> implements Helper<T, T[]> {
        @Override
        public T get(T[] coll, int idx) {
            return coll[idx];
        }

        @Override
        public void set(T[] coll, int idx, T val) {
            coll[idx] = val;
        }

        @Override
        public int size(T[] coll) {
            return coll.length;
        }
    }

    private static class IntArrayHelper implements Helper<Integer, int[]> {

        @Override
        public Integer get(int[] coll, int idx) {
            return coll[idx];
        }

        @Override
        public void set(int[] coll, int idx, Integer val) {
            coll[idx] = val;
        }

        @Override
        public int size(int[] coll) {
            return coll.length;
        }
    }
}
