package org.example;

import java.util.*;



public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();

    private ChampionshipManager() {} //private constructor for singleton,

    //because this is how we will control how many instances are there:
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

    //get score by sorting the driver list (I used AI for this part, i could not do this on my own)
    public List<Driver> getChampionshipScore() {

        List<Driver> sortedDrivers = new ArrayList<>(drivers);

        sortedDrivers.sort(new Comparator<Driver>() {
            public int compare(Driver d1, Driver d2) {
                return d2.getPoints() - d1.getPoints();
            }
        });

        return sortedDrivers;
    }



    //we call the previous method and get the points of the first guy
    public Driver getLeadingDriver() {

        List<Driver> scores = getChampionshipScore();

            return scores.get(0); 
        }


        //iterate trough the people and add their scores up
    public int getTotalChampionshipPoints() {

        int totalPoints = 0;
        for (Driver driver : drivers) {
            totalPoints += driver.getPoints();
        }

        return totalPoints;
    }

    //basic getter
    public List<RallyRaceResult> getRaceResults() {
        return races;
}}
