package com.example.sprintboot_test.fish4;

public class Salmon implements Animal{
    int fins;
    String category;
    public Salmon(int fins,String category){
        this.fins=fins;
        this.category=category;
    }
    @Override
    public String sound() {
        return "Pop";
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public int countLegs() {
        return 0;
    }

    @Override
    public String toString() {
        return "Salmon is a "+getCategory()+" and it has "+fins+" fins";
    }
}
