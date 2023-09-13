package com.example.sprintboot_test.fish4;

import java.util.Date;

public class Book {
    String name;
    Author author;
    Publisher publisher;
    int publishYear;
    String genre;

    public Book(String name, Author author, Publisher publisher, int publishYear, String genre) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String getGenre() {
        return genre;
    }

    public Boolean copyrighted() {
        if (author.getDeathYear() == -1) {
            return true;
        } else {
            return !(new Date().getYear()>(2022+75));
        }
    }

    public String getPublishingLocation() {
        return getPublisher().getLocation();
    }
}
