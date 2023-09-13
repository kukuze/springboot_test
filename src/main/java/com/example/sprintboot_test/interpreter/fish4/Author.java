package com.example.sprintboot_test.fish4;

import java.util.Objects;

public class Author {
    String name;
    int birthYear;
    int deathYear;

    public Author(String name, int birthYear, int deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return birthYear == author.birthYear && deathYear == author.deathYear && Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthYear, deathYear);
    }
}
