package org.example;

import java.util.List;
import java.util.Map;

public interface RaceResult {


    void recordResult(Driver driver, int position, int points);

    Map<Driver,Integer> getResults();

    int getDriverPoints(Driver driver);

}
