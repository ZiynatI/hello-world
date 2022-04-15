package codewars;

public class Task2 {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(MakeUpperCase(str));
    }
    //Write a function which converts the input string to uppercase.
    public static String MakeUpperCase(String str) {
        String upperCaseString = new String();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'A') {
                upperCaseString = upperCaseString + 'A';
            } else if (c == 'b' || c == 'B') {
                upperCaseString = upperCaseString + 'B';
            } else if (c == 'c' || c == 'C') {
                upperCaseString = upperCaseString + 'C';
            } else if (c == 'd' || c == 'D') {
                upperCaseString = upperCaseString + 'D';
            } else if (c == 'e' || c == 'E') {
                upperCaseString = upperCaseString + 'E';
            } else if (c == 'f' || c == 'F') {
                upperCaseString = upperCaseString + 'F';
            } else if (c == 'g' || c == 'G') {
                upperCaseString = upperCaseString + 'G';
            } else if (c == 'h' || c == 'H') {
                upperCaseString = upperCaseString + 'H';
            } else if (c == 'i' || c == 'I') {
                upperCaseString = upperCaseString + 'I';
            } else if (c == 'j' || c == 'J') {
                upperCaseString = upperCaseString + 'J';
            } else if (c == 'k' || c == 'K') {
                upperCaseString = upperCaseString + 'K';
            } else if (c == 'l' || c == 'L') {
                upperCaseString = upperCaseString + 'L';
            } else if (c == 'm' || c == 'M') {
                upperCaseString = upperCaseString + 'M';
            } else if (c == 'n' || c == 'N') {
                upperCaseString = upperCaseString + 'N';
            } else if (c == 'o' || c == 'O') {
                upperCaseString = upperCaseString + 'O';
            } else if (c == 'p' || c == 'P') {
                upperCaseString = upperCaseString + 'P';
            } else if (c == 'q' || c == 'Q') {
                upperCaseString = upperCaseString + 'Q';
            } else if (c == 'r' || c == 'R') {
                upperCaseString = upperCaseString + 'R';
            } else if (c == 's' || c == 'S') {
                upperCaseString = upperCaseString + 'S';
            } else if (c == 't' || c == 'T') {
                upperCaseString = upperCaseString + 'T';
            } else if (c == 'u' || c == 'U') {
                upperCaseString = upperCaseString + 'U';
            } else if (c == 'v' || c == 'V') {
                upperCaseString = upperCaseString + 'V';
            } else if (c == 'w' || c == 'W') {
                upperCaseString = upperCaseString + 'W';
            } else if (c == 'x' || c == 'X') {
                upperCaseString = upperCaseString + 'X';
            } else if (c == 'y' || c == 'Y') {
                upperCaseString = upperCaseString + 'Y';
            } else if (c == 'z' || c == 'Z') {
                upperCaseString = upperCaseString + 'Z';
            } else if (c == ' ') {
                upperCaseString = upperCaseString + ' ';
            } else {
                upperCaseString = upperCaseString + c;
            }
        }
        return upperCaseString;
    }
}
