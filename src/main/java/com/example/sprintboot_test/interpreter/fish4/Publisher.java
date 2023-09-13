package com.example.sprintboot_test.fish4;

import java.util.List;

public class Publisher {
    String name;
    String location;
    List<Library> libraries;

    public Publisher(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Library> getLibraries() {
        return libraries;
    }
}
