package com.example.sprintboot_test.fish4;

public class Main {
    public static void main(String[] args) {
        Animal parrot = new Parrot("green", "gird");
        Animal salmon = new Salmon(8, "Fish");
        Animal tiger = new Tiger(50.5, "Mammals");
        System.out.println(parrot);
        System.out.println(salmon);
        System.out.println(tiger);
    }
}
