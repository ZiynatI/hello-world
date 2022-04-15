package codewars;

public class Task4 {
    public static void main(String[] args) {
        Object[] arr = new Object[]{5874, 54, 548, 47, 88};
        int i = 89;
        System.out.println(check(arr, i));
    }

    //You will be given an array a and a value x. All you need to do is check whether the provided array contains the value.
    //Array can contain numbers or strings. X can be either.
    //Return true if the array contains the value, false if not.
    public static boolean check(Object[] a, Object x) {
        boolean contains = false;
        for (int i = 0; i < a.length; i++) {
            if (x == a[i]) {
                contains = true;
                break;
            } else {
                contains = false;
            }
        }
        return contains;
    }
}
