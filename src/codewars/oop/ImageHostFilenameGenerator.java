package codewars.oop;

import java.util.Locale;
import java.util.Random;

public class ImageHostFilenameGenerator {
    //https://www.codewars.com/kata/586a933fc66d187b6e00031a
    //You are developing an image hosting website.
    //You have to create a function for generating random and unique image filenames.
    //Create a function for generating a random 6 character string which will be used to access the photo URL.
    //To make sure the name is not already in use, you are given access to an PhotoManager object.
    //You can call it like so to make sure the name is unique
    //// at this point, the website has only one photo, hosted on the 'ABCDEF' url
    //photoManager.nameExists("ABCDEF"); // returns true
    //photoManager.nameExists("BBCDEF"); // returns false
    //Note: We consider two names with same letters but different cases to be unique.
    public static String generateName(PhotoManager photoManager) {
        while (true) {
            Random random = new Random();
            char[] word = new char[6];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            String s = new String(word).toUpperCase(Locale.ROOT);
            if (!photoManager.nameExists(s)) {
                return s;
            }
        }
    }

    static class PhotoManager {

        public boolean nameExists(String s) {
            return true;
        }
    }
}
