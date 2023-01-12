package org.helloworld.task;

import java.util.List;

public class ArrayListSort {
    public static void main(String[] args) {
        sort(new int[]{1, 2, 3});
        System.out.println();
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
    public static <T> void sort(T list) {

    }


    public static <T> void sortList(List<T> list) {
        T temp = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.set(list.size() - 1, temp);
    }

    public static <T> void sortArray(T[] list) {
        T temp = list[0];
        list[0] = list[list.length - 1];
        list[list.length - 1] = temp;
    }
}
