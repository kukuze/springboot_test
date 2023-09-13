package com.example.sprintboot_test.fish2;

public class Entry <K,V>{
    K key;
    V value;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
