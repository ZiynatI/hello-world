package codewars;

public class BackSpacesInString {
    public static void main(String[] args) {
        System.out.println(cleanString("abc#d##c"));
    }
    //        //https://www.codewars.com/kata/5727bb0fe81185ae62000ae3
    //        //Assume "#" is like a backspace in string. This means that string "a#bc#d" actually is "bd"
    //        //Your task is to process a string with "#" symbols.
    //        //Examples
    //        //"abc#d##c"      ==>  "ac"
    //        //"abc##d######"  ==>  ""
    //        //"#######"       ==>  ""
    //        //""              ==>  ""
    public static String cleanString(String s) {
        StringBuilder sb = new StringBuilder();
        int backspaces = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                backspaces++;
            } else {
                if (backspaces == 0) {
                    sb.append(s.charAt(i));
                } else {
                    if (backspaces > 0) {
                        backspaces--;
                    }
                }
            }
        }
        return sb.reverse().toString();
    }
}
