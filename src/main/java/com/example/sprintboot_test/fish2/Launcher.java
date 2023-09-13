package com.example.sprintboot_test.fish2;

import java.util.HashSet;
import java.util.Set;

public class Launcher {
    public static void main(String[] args) throws UnknownKeyException {
        AbstractMap<String,Integer> map=new <String,Integer>ArrayMap();
        putEntries(map);
        printMap(map);
        Set<String>keyset=new <String>HashSet(){{
            add("unknown");
        }};
        try {
            map.getValuesAsSetOrThrow(keyset);
        }catch (UnknownKeyException e){
            System.out.println("unknown key");
        }


    }
    public static void putEntries(AbstractMap<String,Integer> map){
        map.put("sizeInMB",42);
        map.put("version",4);
        map.put("yearOfRelease",2015);
    }
    public static void printMap(AbstractMap<String,Integer> map){
        Set<String> keys = map.keysAsSet();
        try{
            for (String s : keys) {
                Integer value = map.getOrThrow(s);
                System.out.println(s + ":" + value);
            }
        }catch (UnknownKeyException e){
            System.out.println("unknown key");
        }
    }
}
