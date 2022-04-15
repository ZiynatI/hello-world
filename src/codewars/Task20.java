package codewars;

public class Task20 {
    public static void main(String[] args) {
        System.out.println(stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"}));
        System.out.println();
    }

    //Complete the solution so that it strips all text that follows any of a set of comment markers passed in.
    //Any whitespace at the end of the line should also be stripped out.
    //Example:
    //Given an input string of:
    //apples, pears # and bananas
    //grapes
    //bananas !apples
    //The output expected would be:
    //apples, pears
    //grapes
    //bananas
    //The code would be called like so:
//    public static String stripComments(String text, String[] commentSymbols) {
//        for(int i = 0;i<text.length();i++){
//            if()
//        }
//        return "";
//    }
    public static String stripComments(String text, String[] commentSymbols) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (!isCommentSymbol(Character.toString(text.charAt(i)), commentSymbols)) {
                stb.append(text.charAt(i));
            } else {
                do {
                    i++;
                    if (i == text.length() - 1) {
                        break;
                    }
                } while (text.charAt(i + 1) != '\n');
            }
        }for (int i=0;i<stb.length();i++){
            if(i==stb.length()-1){
                break;
            }
            if(stb.charAt(i)==' '&&stb.charAt(i+1)=='\n'){
                stb.deleteCharAt(i);
            }
        }if(stb.charAt(stb.length()-1)==' '){
            stb.deleteCharAt(stb.length()-1);
        }
        return stb.toString();
    }
    public static boolean isCommentSymbol(String verifiable, String[] commentSymbols) {
        boolean isComment = false;
        for (int i = 0; i < commentSymbols.length; i++) {
            if (commentSymbols[i].equals(verifiable)) {
                isComment = true;
                return isComment;
            } else {
                isComment = false;
            }
        }
        return isComment;
    }
}

