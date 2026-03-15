package org.example;

public class Driver {
    protected String name;
    protected String country;
    protected int points;
    protected RallyCar car;


    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.points = 0;
        this.car = car;

    }

    public RallyCar getCar() {
        return car;
    }
    public void setCar(RallyCar car){
        this.car=car;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public int getPoints() {
        return points;
    }
    public void addPoints(int points) {
        this.points += points;
    }
}
