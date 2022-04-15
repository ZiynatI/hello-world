package org.helloworld.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpDemo {
    public static void main(String[] args) {
        String regex = "(?<=prefix_).+(?=_suffix)";
        String s = "prefix_MyString_suffix";
        System.out.println(s.replaceAll(regex, "123"));

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        System.out.println(m.replaceAll("123"));

        String emailRegex = "[a-z0-9.A-Z]+@[a-z]+(\\.[a-z]{2,3})+";
        String emailRegex1 = "[a-z0-9A-Z.]+@[a-z]+";
        System.out.println("example@gmail.com".matches(emailRegex));
        System.out.println("my.new.Mail@yandex.ru.ru".matches(emailRegex));
        System.out.println("nodotabcde@gmailcom".matches(emailRegex));
        System.out.println("reu@uz.ru.uz".matches(emailRegex));

        String phoneRegex = "\\+\\d{3}[ ]*[(]?\\d{2}[ ]*[)]?\\d{3}([ ]*[-]?\\d{2}){2}";
        String phoneRegex2 = "^\\+?\\d{3}[ -]?[(]?\\d{2}[)]?[ -]?\\d{3}([ -]?\\d{2}){2}$";
        System.out.println("+998991231234".matches(phoneRegex2));
        System.out.println("+998 (99) 123-12-34".matches(phoneRegex2));
        System.out.println("+998-(99)-123 12 34".matches(phoneRegex2));

    }
}