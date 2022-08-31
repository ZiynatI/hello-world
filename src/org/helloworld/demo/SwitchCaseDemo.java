package org.helloworld.demo;

import java.util.ArrayList;
import java.util.List;

public class SwitchCaseDemo {
    public static void main(String[] args) {

        int month = 9;
        String monthString;
        switch (month) {
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
                monthString = "Invalid month";
                break;
        }
        System.out.println("School starts in " + monthString);

    }

    public static List<String> getPlanetAtmosphere(int seqNumberFromSun) {
        List<String> result = new ArrayList<>();
        switch (seqNumberFromSun) {
            case 1:
                result.add("Нет атмосферы");
            case 2:
            case 4:
                result.add("Углекислый газ");
            case 3:
                result.add("Углекислый газ");
                result.add("Азот");
                result.add("Кислород");
            case 5:
            case 6:
                result.add("Водород");
                result.add("Гелий");
            case 7:
            case 8:
                result.add("Метан");
                result.add("Водород");
                result.add("Гелий");
            default:
        }
        return result;
    }

    public static List<String> getPlanetAtmosphere2(int seqNumberFromSun) {
        List<String> result = new ArrayList<>();
        switch (seqNumberFromSun) {
            case 1:
                result.add("Нет атмосферы");
                break;
            case 3:
                result.add("Азот");
                result.add("Кислород");
            case 2:
            case 4:
                result.add("Углекислый газ");
                break;
            case 7:
            case 8:
                result.add("Метан");
            case 5:
            case 6:
                result.add("Водород");
                result.add("Гелий");
        }
        return result;
    }
}
