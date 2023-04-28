package codewars;

//https://www.codewars.com/kata/64416600772f2775f1de03f9
/*Rook Count Attack
This kata is focused on counting the number of rooks that are attacking each other on a standard 8x8 chessboard. A rook is a chess piece that can move horizontally or vertically across any number of squares on the board.
How the rook moves
Rook Moves
Input
The input for this kata is a bidimensional array that represents the positions of the rooks on the board.
    Each element in the array is a two-element array that represents the x and y coordinates of a rook on the board(check test section).
    The order of rooks in the array is random and there will not be any duplicate rooks in the same tile.
    Also the rooks are not removed from board an attack happened.
Rooks on [c6, f4, f6] will be [2,5], [5,3], [5,5]
Output
The output for this kata is an integer that represents the number of pairs of rooks attacking each others. A rook is considered to be attacked by another rook if they are on the same row or column.
Example
The image bellow contains 3 rooks, [c6, f4, f6]. All three of them are attacking each other. Your solution should return 2 as number of attacks between all rooks. The counter attacks are not counted for this kata.
Three Rooks
Example 2
The example bellow shows clearly the attacks order. Please note, that rooks are not removed from the board after an happen happend.
    Rook on b6 attacks just the rook on d6, because attack on b4 already counted and it can't attack rook on f6 because of obstacle on d6.
In few words, rook attack just the nearest rook which has not managed to attack yet. The result is 5, watch the image below. Rook Attacks
Check Tests in case something is not clear.
Good luck and have fun.
PS: There are 500_000 random tests with up to 64 rooks on same board(8x8).*/
public class RookUtils {
    public static int countAttackingRooks(int[][] rooks) {
        int attackingPairs = 0;
        int[][] copyArr = new int[rooks.length][2];
        for (int i = 0; i < copyArr.length; i++) {
            for (int j = 0; j < 2; j++) {
                copyArr[i][j] = rooks[i][j];
            }
        }
        for (int i = rooks.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (copyArr[j][0] != 8) {
                    if (copyArr[j][0] == copyArr[i][0]) {
                        attackingPairs++;
                        copyArr[j][0] = 8;
                    }
                }
                if (copyArr[j][1] != 8) {
                    if (copyArr[j][1] == copyArr[i][1]) {
                        attackingPairs++;
                        copyArr[j][1] = 8;
                    }
                }
            }
        }
        return attackingPairs;
    }
}
