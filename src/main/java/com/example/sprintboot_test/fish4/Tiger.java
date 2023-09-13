package com.example.sprintboot_test.fish4;

public class Tiger implements Animal{
    double distance;
    String category;
    public Tiger(double distance,String category) {
        this.distance = distance;
        this.category=category;
    }

    @Override
    public String sound() {
        return "Halum";
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public int countLegs() {
        return 4;
    }

    @Override
    public String toString() {
        return "Tiger has "+countLegs()+" legs and it can run "+distance+" kilometers per hour";
    }
}
