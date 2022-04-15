package org.helloworld.task;

public class Task13 {
    /* есть такая игра - орлянка
правила такие - ты загадываешь сторону монетки (орёл/решка) и называешь ставку
угадала - удваиваешь деньги, проиграла - теряешь деньги
напиши симулятор игрока, играющего по такой стратегии:
он ставит 1 доллар, и если проигрывает - удваивает ставку,
 снова проигрывает - снова удваивает, и так далее пока не выиграет, потом он снова начинает ставить 1 доллар
нужно расписать, как меняется его финансовое состояние в течение 10 ходов
в подробностях: сколько у него денег, сколько он поставил, чем кончился раунд
так как сторона монетки не важна, пусть всегда ставит на орла
идея ясна?)
пример
Раунд 1
У меня 0 долларов
Я ставлю 1 доллар
Я победил
---
Раунд 2
У меня 1 доллар
Я ставлю 1 доллар
Я победил
---
Раунд 3
У меня 2 доллара
Я ставлю 1 доллар
Я проиграл
---
Раунд 4
У меня 1 доллара
Я ставлю 2 доллара
Я проиграл
---
Раунд 5
У меня -1 доллар
Я ставлю 4 доллара
Я победил*/
    public static void main(String[] args) {
        playGame(10);
    }

    //Ничего не берет, возвращает сторону монетки. Орел=true; Решка=false
    public static boolean coinToss() {
        double sideQualifier = Math.random();
        boolean sideOfTheCoin = false;
        if (sideQualifier >= 0 && sideQualifier < 0.5) {
            sideOfTheCoin = true;
        } else {
            sideOfTheCoin = false;
        }
        return sideOfTheCoin;
    }

    //Берет ставку, возвращает наш выигрыш от этого раунда
    public static int playRound(int bet) {
        int prize;
        if (coinToss() == true) {
            prize = bet * 2;
        } else {
            prize = 0;
        }
        return prize;
    }

    /**
     * @param lastResult результат предыдущего раунда
     * @param lastBet    последняя ставка
     * @return следующая ставка
     */
    public static int getNextBet(boolean lastResult, int lastBet) {
        int nextBet = 0;
        if (lastResult) {
            nextBet = 1;
        } else {
            nextBet = lastBet * 2;
        }
        return nextBet;
    }

    /**
     * @param numberOfRounds количество раундов
     */
    public static void playGame(int numberOfRounds) {
        int bank = 0;
        int bet = 1;
        for (int round = 1; round <= numberOfRounds; round++) {
            System.out.println("Раунд:" + round);
            System.out.println("На счету: $" + bank);
            System.out.println("Ставка: $" + bet);
            bank = bank - bet;
            int prize = playRound(bet);
            boolean win = prize != 0;
            if (win) {
                bet = 1;
                System.out.println("Победа!");
            } else {
                bet = bet * 2;
                System.out.println("Проигрыш");
            }
            bank = bank + prize;
        }
    }
}