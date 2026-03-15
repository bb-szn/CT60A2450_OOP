package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // make some cars
        GravelCar car1 = new GravelCar("Toyota", "CarA", 380, 0.6);
        GravelCar car2 = new GravelCar("Hyundai", "CarB", 370, 0.45);
        AsphaltCar car3 = new AsphaltCar("Ford", "CarC", 390, 240.0);
        AsphaltCar car4 = new AsphaltCar("M-Sport", "CarD", 375, 225.0);

        // make racers
        Driver bob = new Driver("Bob", "France", car1);
        Driver anna = new Driver("Anna", "Finland", car2);
        Driver rob = new Driver("Rob", "Estonia", car3);
        Driver lisa = new Driver("Lisa", "Belgium", car4);

        // register drivers
        manager.registerDriver(bob);
        manager.registerDriver(anna);
        manager.registerDriver(rob);
        manager.registerDriver(lisa);

        // Finland jyväskylä rally results
        Map<Driver, Integer> finlandPositions = new HashMap<>();
        finlandPositions.put(bob, 2);
        finlandPositions.put(rob, 1);
        finlandPositions.put(anna, 4);
        finlandPositions.put(lisa, 3);

        RallyRaceResult finlandRally = new RallyRaceResult();
        finlandRally.recordRaceResult("Finland Rally", "Jyväskylä", finlandPositions);
        manager.recordResults(finlandRally);

        // some racers swich cars (AI suggestion lol)
        anna.setCar(car3);
        rob.setCar(car2);

        // Monte Carlo rally results
        Map<Driver, Integer> monteCarloPositions = new HashMap<>();
        monteCarloPositions.put(anna, 2);
        monteCarloPositions.put(lisa, 1);
        monteCarloPositions.put(bob, 4);
        monteCarloPositions.put(rob, 3);

        RallyRaceResult monteRally = new RallyRaceResult();
        monteRally.recordRaceResult("Monte Carlo Rally", "Monaco", monteCarloPositions);
        manager.recordResults(monteRally);

        // display championship information
        displayChampionshipStandings(manager);
        displayChampionshipLeader(manager);
        displayRaceResults(manager);
        displayCarPerformanceRatings();
    }









    private static void displayChampionshipStandings(ChampionshipManager manager) {
        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        int pos = 1;
        for (Driver drive : manager.getChampionshipScore()) {
            System.out.println(pos + ". " + drive.getName() + " (" + drive.getCountry() + "): " + drive.getPoints() + " points");
            pos++;
        }
        System.out.println();
    }

    private static void displayChampionshipLeader(ChampionshipManager manager) {
        Driver leader = manager.getLeadingDriver();
        System.out.println("===== LEADER =====");
        if (leader != null) {
            System.out.println(leader.getName() + " with " + leader.getPoints() + " points");
        } else {
            System.out.println("No leader found");
        }
        System.out.println();
    }

    private static void displayRaceResults(ChampionshipManager manager) {
        System.out.println("===== RACE RESULTS =====");
        for (RallyRaceResult race : manager.getRaceResults()) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
            for (Driver driverr : race.getResults().keySet()) {
                int points = race.getDriverPoints(driverr);
                int position = 5; // default
                if (points == 25) position = 1;
                else if (points == 18) position = 2;
                else if (points == 15) position = 3;
                else if (points == 12) position = 4;
                System.out.println("Position " + position + ": " + driverr.getName() + " - " + points + " points");
            }
            System.out.println();
        }
    }

    private static void displayCarPerformanceRatings() {
        System.out.println("===== CAR PERFORMANCE =====");
        GravelCar gravel = new GravelCar("Hyundai", "CarB", 370, 0.5);
        AsphaltCar asphalt = new AsphaltCar("Ford", "CarC", 390, 240.0);
        System.out.println("Gravel Car Performance: " + gravel.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphalt.calculatePerformance());
    }
}