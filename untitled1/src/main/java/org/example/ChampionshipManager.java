package org.example;

import java.util.*;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();

    private ChampionshipManager() {} //we do this cuz we didn't have constructor (?)

    public static ChampionshipManager getInstance() {
        if (instance == null){
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver){
        drivers.add(driver);

    }

    public void recordResults(RallyRaceResult result){
        races.add(result);
    }

    public List<Driver> getChampionshipScore() {

        List<Driver> sortedDrivers = new ArrayList<>(drivers);

        sortedDrivers.sort(new Comparator<Driver>() {
            public int compare(Driver d1, Driver d2) {
                return d2.getPoints() - d1.getPoints();
            }
        });

        return sortedDrivers;
    }




    public Driver getLeadingDriver() {

        List<Driver> scores = getChampionshipScore();

        if (scores.isEmpty()) {
            return null;
        } else {
            return scores.get(0);
        }
    }


    public int getTotalChampionshipPoints() {

        int totalPoints = 0;
        for (Driver driver : drivers) {
            totalPoints += driver.getPoints();
        }

        return totalPoints;
    }


    public List<RallyRaceResult> getRaceResults() {
        return races;
}}
