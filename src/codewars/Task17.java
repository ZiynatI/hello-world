package codewars;

public class Task17 {
    public static void main(String[] args) {
        System.out.println(isSquare(-5));
        System.out.println(isSquare(76115600));
    }

    //Given an integral number, determine if it's a square number:
    //    In mathematics, a square number or perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
    //The tests will always use some integral number, so don't worry about that in dynamic typed languages.
    //Examples
    //-1  =>  false
    // 0  =>  true
    // 3  =>  false
    // 4  =>  true
    //25  =>  true
    //26  =>  false
    public static boolean isSquare(int n) {
        boolean isSquare = false;
        for (int i = 0; ; ++i) {
            int j = i * i;
            if (j == n) {
                isSquare = true;
                break;
            } else if (j >= n) {
                break;
            }
        }
        return isSquare;
    }
}
