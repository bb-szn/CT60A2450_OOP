package org.example;

public class GravelCar extends RallyCar{

    protected double drag;

    public GravelCar(String make, String model, int horsepower, double drag){
        super(make,model,horsepower);
        this.drag = drag;
    }

    // typical value around 0.4 to 0.6
    public double getDrag() {
        return drag;
    }



    @Override
    public double calculatePerformance() {
        return (horsepower * 0.85) * (1-drag);
    }
}
