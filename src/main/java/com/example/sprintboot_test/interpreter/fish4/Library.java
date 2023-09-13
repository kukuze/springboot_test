package com.example.sprintboot_test.fish4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    String name;
    int openYear;
    String location;
    HashMap<Book, Integer> books;

    public Library(String name, int openYear, String location) {
        this.name = name;
        this.openYear = openYear;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getOpenYear() {
        return openYear;
    }

    public String getLocation() {
        return location;
    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public List<Book> getBooksByGenre(String genre) {
        if (null == genre || genre.equals(""))
            return null;
        ArrayList<Book> res = new ArrayList<>();
        books.forEach((k, v) -> {
            if (k.getGenre().equals(genre))
                res.add(k);
        });
        return res;
    }

    public List<Book> getBooksByAuthor(Author author) {
        if (null == author)
            return null;
        ArrayList<Book> res = new ArrayList<>();
        books.forEach((k, v) -> {
            if (k.getAuthor().equals(author))
                res.add(k);
        });
        return res;
    }

    public void addBook(Book book) {
        if (book == null)
            return;
        if (books.containsKey(book)) {
            books.put(book, books.get(book) + 1);
        } else {
            books.put(book, 1);
        }
    }
}
