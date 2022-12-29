package codewars;

public class Millipede {
    //https://www.codewars.com/kata/6344701cd748a12b99c0dbc4
    //The set of words is given.
    //Words are joined if the last letter of one word and the first letter of another word are the same.
    //Return true if all words of the set can be combined into one word.
    //Each word can and must be used only once. Otherwise return false.
    //Input
    //Array of 3 to 7 words of random length. No capital letters.
    //Example true
    //Set: excavate, endure, desire, screen, theater, excess, night.
    //Millipede: desirE EndurE ExcavatE ExcesS ScreeN NighT Theater.
    //Example false
    //Set: trade, pole, view, grave, ladder, mushroom, president.
    //Millipede: presidenT Trade.
    public static boolean check(String[] millipede) {
        char lastsLast = millipede[0].charAt(millipede[0].length() - 1);
        char lastsFirst = millipede[0].charAt(0);
        millipede[0] = "";
        for (int i = 1; i < millipede.length; i++) {
            for (int j = 1; j < millipede.length; j++) {
                if (!millipede[j].equals("")) {
                    if (lastsLast == millipede[j].charAt(0)) {
                        lastsLast = millipede[j].charAt(millipede[j].length() - 1);
                        millipede[j] = "";
                        break;
                    } else {
                        if (lastsFirst == millipede[j].charAt(millipede[j].length() - 1)) {
                            lastsFirst = millipede[j].charAt(0);
                            millipede[j] = "";
                            break;
                        }
                    }
                }
            }
        }
        for (String s : millipede) {
            if (!s.equals("")) {
                return false;
            }
        }
        return true;
    }
}
