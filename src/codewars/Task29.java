package codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task29 {
    public static void main(String[] args) {
        System.out.println(stat("01|15|59, 1|47|6, 01|17|20, 1|32|34, 2|3|17"));
    }

    //You are the "computer expert" of a local Athletic Association (C.A.A.). Many teams of runners come to compete. Each time you get a string of all race results of every team who has run. For example here is a string showing the individual results of a team of 5 runners:
    //"01|15|59, 1|47|6, 01|17|20, 1|32|34, 2|3|17"
    //Each part of the string is of the formPanel: h|m|s where h, m, s (h for hour, m for minutes, s for seconds) are positive or null integer (represented as strings) with one or two digits. Substrings in the input string are separated by , or ,.
    //To compare the results of the teams you are asked for giving three statistics; range, average and median.
    //    Range : difference between the lowest and highest values. In {4, 6, 9, 3, 7} the lowest value is 3, and the highest is 9, so the range is 9 − 3 = 6.
    //    Mean or Average : To calculate mean, add together all of the numbers in a set and then divide the sum by the total count of numbers.
    //    Median : In statistics, the median is the number separating the higher half of a data sample from the lower half. The median of a finite list of numbers can be found by arranging all the observations from lowest value to highest value and picking the middle one (e.g., the median of {3, 3, 5, 9, 11} is 5) when there is an odd number of observations. If there is an even number of observations, then there is no single middle value; the median is then defined to be the mean of the two middle values (the median of {3, 5, 6, 9} is (5 + 6) / 2 = 5.5).
    //Your task is to return a string giving these 3 values. For the example given above, the string result will be
    //"Range: 00|47|18 Average: 01|35|15 Median: 01|32|34"
    //of the formPanel: "Range: hh|mm|ss Average: hh|mm|ss Median: hh|mm|ss"`
    //where hh, mm, ss are integers (represented by strings) with each 2 digits.
    //Remarks:
    //    if a result in seconds is ab.xy... it will be given truncated as ab.
    //    if the given string is "" you will return ""
    public static String stat(String strg) {
        if (strg == "") {
            return "";
        }
        List<Integer> resultsLst = splitAsSeconds(strg);
        StringBuilder result = new StringBuilder("Range: ");
        result.append(secondsToStat(findRange(resultsLst)));
        result.append(" Average: ").append(secondsToStat(findAverage(resultsLst)));
        result.append(" Median: ").append(secondsToStat(findMedian(resultsLst)));
        return result.toString();
    }

    public static List<Integer> splitAsSeconds(String strg) {
        List<Integer> resultsLst = new ArrayList<>();
        String[] results = strg.split(",\\s?");
        for (String result : results) {
            String[] resultsarr = result.split("\\|");
            int thisResult = (Integer.parseInt(resultsarr[0]) * 60 + Integer.parseInt(resultsarr[1])) * 60 + Integer.parseInt(resultsarr[2]);
            resultsLst.add(thisResult);
            thisResult = 0;
        }
        return resultsLst;
    }

    public static int findRange(List<Integer> resultsLst) {
        int range = Collections.max(resultsLst) - Collections.min(resultsLst);
        return range;
    }

    public static int findAverage(List<Integer> resultsLst) {
        int average = 0;
        for (int i = 0; i < resultsLst.size(); i++) {
            average += resultsLst.get(i);
        }
        average = average / (resultsLst.size());
        return average;
    }

    public static int findMedian(List<Integer> resultsLst) {
        int median;
        Collections.sort(resultsLst);
        if (resultsLst.size() == 1) {
            median = resultsLst.get(0);
            return median;
        }
        if (resultsLst.size() == 2) {
            median = (resultsLst.get(0) + resultsLst.get(1)) / 2;
            return median;
        }
        if (resultsLst.size() % 2 == 0) {
            median = (resultsLst.get(resultsLst.size() / 2 - 1) + resultsLst.get(resultsLst.size() / 2)) / 2;
        } else {
            median = resultsLst.get((resultsLst.size() / 2));
        }
        return median;
    }

    public static StringBuilder secondsToStat(int result) {
        StringBuilder sb = new StringBuilder();
        if (result / 3600 < 10) {
            sb.append('0');
        }
        sb.append(result / 3600);
        sb.append('|');
        result = result % 3600;
        if (result / 60 < 10) {
            sb.append('0');
        }
        sb.append(result / 60);
        sb.append('|');
        if (result % 60 < 10) {
            sb.append('0');
        }
        sb.append(result % 60);

        return sb;
    }
}