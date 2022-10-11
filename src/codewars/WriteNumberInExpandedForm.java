package codewars;

public class WriteNumberInExpandedForm {
    //https://www.codewars.com/kata/5842df8ccbd22792a4000245
    //Write Number in Expanded Form
    //You will be given a number, and you will need to return it as a string in Expanded Form. For example:
    //Kata.expandedForm(12); # Should return "10 + 2"
    //Kata.expandedForm(42); # Should return "40 + 2"
    //Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
    //NOTE: All numbers will be whole numbers greater than 0.
    public static void main(String[] args) {
        System.out.println(expandedForm(70304));
    }

    public static String expandedForm(int num) {
        return recurse(num, 0, "").substring(3);
    }

    public static String recurse(int num, int zeros, String expending) {
        StringBuilder e = new StringBuilder();
        if (num == 0) {
            return expending;
        } else {
            int tail = num % 10;
            if (tail == 0) {
                expending = recurse((num - num % 10) / 10, zeros + 1, "") + expending;
            } else {
                expending = recurse((num - num % 10) / 10, zeros + 1, " + " + tail * (int) Math.pow(10, zeros)) + expending;
            }

        }
        return expending;
    }
}
