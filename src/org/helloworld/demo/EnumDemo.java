package org.helloworld.demo;

public class EnumDemo {
    public static void main(String[] args) {

    }

    enum Weather {
        SUNNY, HOT, RAINY, CHILLY
    }

    class WeatherToday {
        Weather forecast;

        public WeatherToday(Weather forecast) {
        }

        public void giveForecast() {

            switch (forecast) {
                case SUNNY:
                    System.out.println("It is sunny today");
                    break;
                case HOT:
                    System.out.println("Such terrible weather!");
                    break;
                case RAINY:
                    System.out.println("Take an umbrella with you.");
                    break;
                case CHILLY:
                    System.out.println( "What a nice day!");
                    break;
            }
        }
    }
}
