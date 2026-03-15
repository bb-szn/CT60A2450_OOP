package org.example;

public class AsphaltCar extends RallyCar{
    protected double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;

    }

    //getter for new variable
    public double getDownforce() {
        return downforce;
    }

    @Override
    public double calculatePerformance() {
        return (horsepower * 0.85) + (downforce * 0.5);
    }

}
