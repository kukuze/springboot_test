package com.example.sprintboot_test.fish2;

import java.util.HashSet;
import java.util.Set;

public class ArrayMap<K, V> extends AbstractMap<K, V> {
    Entry<K, V> entries[];

    public ArrayMap() {
        entries=GenericArrayHelper.newEntryArrayOfSize(10);
    }

    public ArrayMap(Entry<K, V>[] entry) {
        entries= GenericArrayHelper.copyArray(entry);
    }


    @Override
    public V getOrThrow(K key) throws UnknownKeyException {
        for (Entry<K,V> entry:entries) {
            if(entry!=null&&entry.key.equals(key))
                return entry.value;
        }
        throw new UnknownKeyException();
    }

    @Override
    public void put(K key, V value) {
        int i;
        for(i = 0; i < entries.length; i++) {
            Entry<K, V> entry = entries[i];
            if (entry==null||entry.key.equals(key)) {
                entries[i] = new Entry<>(key, value);
                return;
            }
        }
        entries=GenericArrayHelper.copyArrayWithIncreasedSize(entries,entries.length*2);
        entries[i]=new Entry<>(key, value);
    }

    @Override
    public Set<K> keysAsSet() {
        Set<K> keySet = new HashSet<>();
        for (Entry<K,V> entry:entries) {
            if(entry!=null)
                keySet.add(entry.key);
        }
        return keySet;
    }

}
