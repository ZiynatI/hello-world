package codewars;

import java.util.LinkedHashMap;
import java.util.Map;

public class TimeFormatter {
    //https://www.codewars.com/kata/52742f58faf5485cae000b9a
    //Your task in order to complete this Kata is to write a function which formats a duration,
    //given as a number of seconds, in a human-friendly way.
    //The function must accept a non-negative integer. If it is zero, it just returns "now".
    //Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
    //It is much easier to understand with an example:
    //* For seconds = 62, your function should return
    //    "1 minute and 2 seconds"
    //* For seconds = 3662, your function should return
    //    "1 hour, 1 minute and 2 seconds"
    //For the purpose of this Kata, a year is 365 days and a day is 24 hours.
    //Note that spaces are important.
    //Detailed rules
    //The resulting expression is made of components like 4 seconds, 1 year, etc.
    //In general, a positive integer and one of the valid units of time, separated by a space.
    //The unit of time is used in plural if the integer is greater than 1.
    //The components are separated by a comma and a space (", ").
    //Except the last component, which is separated by " and ", just like it would be written in English.
    //A more significant units of time will occur before than a least significant one.
    //Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.
    //Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
    //A component will not appear at all if its value happens to be zero.
    //Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.
    //A unit of time must be used "as much as possible".
    //It means that the function should not return 61 seconds, but 1 minute and 1 second instead.
    //Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.
    public static void main(String[] args) {
        System.out.println(secondsToMap(3662));
        System.out.println(formatDuration(3662));
        System.out.println(formatDuration(62));
    }

    public static Map<String, Integer> secondsToMap(int seconds) {
        Map<String, Integer> timeMap = new LinkedHashMap<>();
        timeMap.put("year", 0);
        timeMap.put("day", 0);
        timeMap.put("hour", 0);
        timeMap.put("minute", 0);
        timeMap.put("second", 0);
        timeMap.put("second", seconds % 60);
        int minutes = seconds / 60;
        timeMap.put("minute", minutes % 60);
        int hours = minutes / 60;
        timeMap.put("hour", hours % 24);
        int days = hours / 24;
        timeMap.put("day", days % 365);
        int years = days / 365;
        timeMap.put("year", years);
        return timeMap;
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }
        Map<String, Integer> timeMap = secondsToMap(seconds);
        StringBuilder time = new StringBuilder();
        for (Map.Entry<String, Integer> measure : timeMap.entrySet()) {
            if (measure.getValue() != 0) {
                time.append(measure.getValue()).append(" ").append(measure.getKey());
                if (measure.getValue() != 1) {
                    time.append("s");
                }
                time.append(", ");
            }
        }
        time.delete(time.length() - 2, time.length());
        for (int i = time.length() - 1; i > 0; i--) {
            if (time.charAt(i) == ',') {
                time.replace(i, i + 1, " and");
                break;
            }
        }
        return time.toString();
    }
}
