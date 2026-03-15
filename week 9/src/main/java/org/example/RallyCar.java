package org.example;

public abstract class RallyCar {
//abstract -> wont have an implementation, only a blueprint for child classes

    protected String make;
    protected String model;
    protected int horsepower;

    public RallyCar(String make, String model, int horsepower){
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    //getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    //we will override this anyway, can be left empty
    public abstract double calculatePerformance();
}
