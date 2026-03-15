package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {

    //static so callable always
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {


        int totalPoints = 0;
        for (Driver driver : drivers) {
            totalPoints += driver.getPoints();
        }
        return ((double) totalPoints / drivers.size());
    }
    //basically getTotalPoints / number of people









    public static String findMostSuccessfulCountry(List<Driver> drivers) {

        Map<String, Integer> countryPoints = new HashMap<>();

        for (Driver driver : drivers) {

            String country = driver.getCountry();
            int currentPoints = 0;

            //check if we already had a guy from that country
            if (countryPoints.containsKey(country)) {
                currentPoints = countryPoints.get(country);
            }

            countryPoints.put(country, currentPoints + driver.getPoints());
        }

        String bestCountry = "Unknown";
        int maxPoints = 0;

        for (Map.Entry<String, Integer> entry : countryPoints.entrySet()) {

            if (entry.getValue() > maxPoints) {
                maxPoints = entry.getValue();
                bestCountry = entry.getKey();
            }
        }

        return bestCountry;
    }
}

