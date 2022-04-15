package codewars;

public class Task22 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("zzbaabcd"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("baablkj12345432133d"));
    }

    //Find the length of the longest substring in the given string s that is the same in reverse.
    //As an example, if the input was “I like racecars that go fast”, the substring (racecar) length would be 7.
    //If the length of the input string is 0, the return value must be 0.
    //Example:
    //"a" -> 1
    //"aab" -> 2
    //"abcde" -> 1
    //"zzbaabcd" -> 4
    //"" -> 0
    public static int longestPalindrome(final String s) {
        if (s.equals("")) {
            return 0;
        }
        int longest = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + longest; j < s.length(); j++) {
                if (j - i + 1 > longest && isPalindrome(s, i, j)) {
                    longest = j - i + 1;
                }
            }
        }
        return longest;
    }

    public static boolean isPalindrome(String s, final int startIdx, final int endIdx) {
        if (s.charAt(startIdx) != s.charAt(endIdx)) {
            return false;
        }
        if (endIdx - startIdx <= 1) {
            return true;
        }
        return isPalindrome(s, startIdx + 1, endIdx - 1);
    }
}