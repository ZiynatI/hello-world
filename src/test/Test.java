package test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println(engine() ? "Бьёт" : "Не бьёт");
    }

    /**
     * Перечисление ChessboardSquare указывает на содержимое клетки - на ферзя, ладью, слона в клетке или на пустую
     * клетку.
     */
    enum ChessboardSquare {
        Queen, Bishop, Rook, Empty;
    }

    public static boolean engine() {
        Scanner input = new Scanner(System.in);
        int firstFiguresNum;
        ChessboardSquare firstFigure = ChessboardSquare.Empty;
        while (firstFigure == ChessboardSquare.Empty) {
            System.out.println("Выберите первую (нападающую) фигуру\n" +
                    "Чтобы выбрать королеву, введите 1\n" +
                    "Чтобы выбрать слона,введите 2\n" +
                    "Чтобы выбрать ладью, введите 3");
            firstFiguresNum = input.nextInt();
            if (firstFiguresNum == 1) {
                firstFigure = ChessboardSquare.Queen;
            } else if (firstFiguresNum == 2) {
                firstFigure = ChessboardSquare.Bishop;
            } else if (firstFiguresNum == 3) {
                firstFigure = ChessboardSquare.Rook;
            } else {
                System.out.println("Неправильно введенный номер\nПопробуйте ещё раз");
            }
        }

        System.out.println("Введите на какой столбец вставить первую фигуру(от 1 до 8)");
        int columnOfFirstFigure = input.nextInt();
        System.out.println("Введите на какую строку вставить первую фигуру(от 1 до 8)");
        int rowOfFirstFigure = input.nextInt();
        Cell firstFigurePosition = new Cell(rowOfFirstFigure, columnOfFirstFigure);
        System.out.println("Введите на какой столбец вставить вторую фигуру(от 1 до 8)");
        int columnOfSecondFigure = input.nextInt();
        System.out.println("Введите на какую строку вставить вторую фигуру(от 1 до 8)");
        int rowOfSecondFigure = input.nextInt();
        Cell secondFigurePosition = new Cell(rowOfSecondFigure, columnOfSecondFigure);
        if (firstFigure == ChessboardSquare.Queen) {
            return canQueenCapture(firstFigurePosition, secondFigurePosition);
        } else if (firstFigure == ChessboardSquare.Rook) {
            return canRookCapture(firstFigurePosition, secondFigurePosition);
        } else if (firstFigure == ChessboardSquare.Bishop) {
            return canBishopCapture(firstFigurePosition, secondFigurePosition);
        }
        return false;
    }

    /**
     * Ферзь ходит по диагонали, вертикали и горизонтали. Если у клетка другой фигуры находится с ферзём на одной строке
     * или на одном столбце, то ферзь бьёт. Если у клеток столб и строка имеют одинаковую сумму или разность, они на
     * одном диагонале
     */
    public static boolean canQueenCapture(Cell queensPosition, Cell anotherPiecesPosition) {
        return canRookCapture(queensPosition, anotherPiecesPosition) || canBishopCapture(queensPosition, anotherPiecesPosition);
    }

    public static boolean canRookCapture(Cell rooksPosition, Cell anotherPiecesPosition) {
        return rooksPosition.row == anotherPiecesPosition.row
                || rooksPosition.column == anotherPiecesPosition.column;
    }

    public static boolean canBishopCapture(Cell bishopsPosition, Cell anotherPiecesPosition) {
        return bishopsPosition.row + bishopsPosition.column == anotherPiecesPosition.row + anotherPiecesPosition.column
                || bishopsPosition.row - bishopsPosition.column == anotherPiecesPosition.row - anotherPiecesPosition.column;
    }

}

/**
 * Класс Cell указывает на ту или иную клетку по номеру столбика и строки.
 */
class Cell {
    int row;
    int column;

    Cell(int column, int row) {
        this.column = column;
        this.row = row;
    }
}
