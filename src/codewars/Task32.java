package codewars;

import java.util.Arrays;

public class Task32 {
    public static void main(String[] args) {
        for (int i = 4; i < 3000; i += 4) {
            System.out.println("Year " + i + ": " + Arrays.toString(mostFrequentDays(i)));
        }
    }

    //What is your favourite day of the week? Check if it's the most frequent day of the week in the year.
    //You are given a year as integer (e.g. 2001). You should return the most frequent day(s) of the week in that year. The result has to be a list of days sorted by the order of days in week (e. g. ['Monday', 'Tuesday'], ['Saturday', 'Sunday'], ['Monday', 'Sunday']). Week starts with Monday.
    //Input: Year as an int.
    //Output: The list of most frequent days sorted by the order of days in week (from Monday to Sunday).
    //Preconditions:
    //    Week starts on Monday.
    //    Year is between 1583 and 4000.
    //    Calendar is Gregorian.
    //Examples (input -> output):
    //* 2427 -> ["Friday"]
    //* 2185 -> ["Saturday"]
    //* 2860 -> ["Thursday", "Friday"]
    //01.01.01-понедельник. 4 года - 1461 день.
    public static String[] mostFrequentDays(int year) {
        String[] week = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int allDays = 0;
        for (int i = 1; i < year; i++) {
            if (isLeap(i)) {
                allDays += 366;
            } else {
                allDays += 365;
            }
        }
        int weekday = allDays % 7;
        if (isLeap(year)) {
            if (weekday != 6) {
                return new String[]{week[weekday], week[weekday + 1]};
            } else {
                return new String[]{week[0], week[weekday]};
            }
        } else {
            return new String[]{week[weekday]};
        }
    }

    public static boolean isLeap(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }
}
