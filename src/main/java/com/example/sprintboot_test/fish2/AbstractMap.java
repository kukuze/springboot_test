package com.example.sprintboot_test.fish2;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractMap <K,V>{
    public abstract V getOrThrow (K key) throws UnknownKeyException;
    public abstract void put(K key,V value);
    public Set<V> getValuesAsSetOrThrow(Set<K>keys) throws UnknownKeyException {
        HashSet<V> objects = new HashSet<>();
        for (K k:keys) {
            objects.add(getOrThrow(k));
        }
        return objects;
    }
    public abstract Set<K> keysAsSet();
}
