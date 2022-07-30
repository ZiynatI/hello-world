package codewars;

public class Mumbling {
    //    This time no story, no theory. The examples below show you how to write function accum:
    //Examples:
    //accum("abcd")      -> "A-Bb-Ccc-Dddd"
    //accum("RqaEzty")   -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
    //accum("cwAt")      -> "C-Ww-Aaa-Tttt"
    //The parameter of accum is a string which includes only letters from a..z and A..Z.
    public static void main(String[] args) {
        System.out.println(accum("RqaEzty"));
    }

    public static String accum(String s) {
        StringBuilder word = new StringBuilder();
        word.append(Character.toUpperCase(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            char thisChar = Character.toLowerCase(s.charAt(i));
            word.append("-").append(Character.toUpperCase(thisChar));
            int index = 0;
            while (index != i) {

                word.append(thisChar);
                index++;
            }
        }
        return word.toString();
    }
}
