package com.example.sprintboot_test.fish4;

public class Parrot implements Animal{
    String color;
    String category;
    public Parrot(String color,String category) {
        this.color=color;
        this.category=category;
    }

    @Override
    public String sound() {
        return "Squak";
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public int countLegs() {
        return 2;
    }

    @Override
    public String toString() {
        return color+" "+sound();
    }
}
