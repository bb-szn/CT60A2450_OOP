package org.example;

import java.util.Map;

public interface RaceResult {


    //im just going to override these and define them later, so no need to code here
    void recordResult(Driver driver, int position, int points);

    Map<Driver,Integer> getResults();

    int getDriverPoints(Driver driver);

}
