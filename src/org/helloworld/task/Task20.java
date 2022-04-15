package org.helloworld.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task20 {
    public static void main(String[] args) {
        System.out.println(changeToUpper("привет. как дела. всё хорошо. hello there."));
    }

    //дан текст, сделай чтоб слова после точки начинались с заглавной буквы
    public static String changeToUpper(String s) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("((\\.\\s)|^)[а-яёa-z]");
        Matcher matcher = pattern.matcher(s);
        int num = 0;
        while (matcher.find()) {
            sb.append(s, num, matcher.start());
            sb.append(matcher.group().toUpperCase());
            num = matcher.end();
        }
        sb.append(s, num, s.length());
        return sb.toString();
    }
}
