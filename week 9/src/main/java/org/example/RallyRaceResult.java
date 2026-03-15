package org.example;

import java.util.HashMap;
import java.util.Map;

public class RallyRaceResult implements RaceResult{

    private String raceName;
    private String location;
    Map<Driver, Integer> results = new HashMap<>();
    // we don't need constructor, because we will initiate the class empty

    //we calculate the points each driver gets based on the race results
    private int calculatePoints (int placement) {
        return switch (placement) {
            case 1 -> 25;
            case 2 -> 18;
            case 3 -> 15;
            case 4 -> 12;
            default -> 0;
        };
    }

    public void recordRaceResult (String raceName, String location, Map<Driver, Integer> raceOutcome){
        this.raceName = raceName;
        this.location = location;

        for (Map.Entry<Driver,Integer> entry: raceOutcome.entrySet()){
            Driver driver = entry.getKey();
            int position = entry.getValue();

            int points = calculatePoints(position);
            results.put(driver, points);
            driver.addPoints(points);
        }
    }




    public String getRaceName(){
        return raceName;
    }

    public String getLocation(){
        return location;
    }

    @Override
    public int getDriverPoints(Driver driver) {
        return results.get(driver);
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, position);
    }

    @Override
    public Map<Driver, Integer> getResults() {
        return results;
    }
}
