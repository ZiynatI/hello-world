package codewars;

import java.util.ArrayList;
import java.util.List;

public class BalancedParens {
    //Write a function which makes a list of strings representing all of the ways you can balance n pairs of parentheses
    //Examples:
    //balancedParens(0) returns ArrayList<String> with element:  ""
    //balancedParens(1) returns ArrayList<String> with element:  "()"
    //balancedParens(2) returns ArrayList<String> with elements: "()()","(())"
    //balancedParens(3) returns ArrayList<String> with elements: "()()()","(())()","()(())","(()())","((()))"
    //ну типа в каждый момент времени ты можешь воткнуть либо открывающую, либо закрывающую скобочку
    //рассмотрим и тот, и другой случай) это два рекурсивных вызова
    //ну и понятно, что не везде и не всё можно воткнуть
    //и посмотри как решалась задача на скобочки (однотипные), это поможет
    //вспомни основы рекурсии
    //что такое рекурсивный алгоритм, как он должен выглядеть, какие случаи нужно обрабатывать
    //вообще это аглоритм обхода графа, поиск в глубину (DFS) но ты алгоритмы пока не знаешь)
    //ДВА рекурсивных вызова, а не один
    //ты в итоге получаешь список и рекурсивно пытаешься его достроить до нужного
    //а нужно прокидывать в рекурсию текущую цепочку символов и получать из неё все возможные продолжения
    //"" - какие могут быть продолжения? "(" и ")", но второе недопустимо т.к. уровня вложенности недостаточно
    //"(" - какие могут быть продолжения? снова ")" и "(", теперь могут быть оба
    //максимально упрощённо:
    //void recurse(String stringSoFar) {
    //  recurse(stringSoFar + "(");
    //  recurse(stringSoFar + ")");
    //}
    //во-первых, представь, что с увеличением уровня погружения n растёт а не уменьшается - так просто удобнее
    //во-вторых, заполняй список на самом глубоком уровне (когда у тебя уже есть одна последовательность скобок) а не на промежуточных
    //промежуточные уровни нужны только затем, чтоб добавлять по одной скобке за уровень
    //а вся работа делается на глубине (в листьях графа, хотя тебе это пока ни о чём не говорит)
    //void recurse(String stringSoFar, int max, List<String> acc) {
    //  if (stringSoFar.length() == max) {
    //    // Maybe add string to a list?
    //  } else {
    //    recurse(stringSoFar + "(", max, acc);
    //    recurse(stringSoFar + ")", max, acc);
    //  }
    //}
    //а начинаешь так
    //List<String> acc = new ArrayList<>();
    //recurse("", n * 2, acc);
    //return acc;
    //acc = accumulator, там аккумулируется (собирается) ответ - это чтоб с кучей списков не работать
    public static void main(String[] args) {
        System.out.println(balancedParens(4));
    }

    public static List<String> balancedParens(int n) {
        List<String> acc = new ArrayList<>();
        return recurse("", n * 2, acc);
    }

    public static List<String> recurse(String stringSoFar, int max, List<String> acc) {
        if (stringSoFar.length() == max) {
            if (checkString(stringSoFar) == 0) {
                acc.add(stringSoFar);
            }
        } else {
            recurse(stringSoFar + "(", max, acc);
            if (checkString(stringSoFar) > 0) {
                recurse(stringSoFar + ")", max, acc);
            }
        }
        return acc;
    }
    public static int checkString(String s) {
        int nestingLevel = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                nestingLevel++;
            } else {
                nestingLevel--;
            }
        }
        return nestingLevel;
    }
}

