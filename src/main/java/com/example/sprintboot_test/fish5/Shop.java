package com.example.sprintboot_test.fish5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Shop {
    String name="Fruits R Us";

    public static void main(String[] args) {
        String fileName = "D:\\Sprintboot_test\\src\\main\\java\\com\\example\\sprintboot_test\\fish5\\Stocks.txt";
        HashMap<String, String> fruitMap = new HashMap<>();
        HashMap<String, String> buyMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split(" ");
                fruitMap.put(s[1].toLowerCase(),s[2]);
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                System.out.print("Which fruit do you want to buy?");
                String str = br.readLine().toLowerCase();
                if(str.equals("none"))
                    break;
                if(null!=fruitMap.get(str)){
                    System.out.print("Quantityplease (in Kg):");
                    String quantity = br.readLine().toLowerCase();
                    buyMap.put(str,quantity);
                }else{
                    System.out.println("Apologies, "+str+" is not available now.");
                }
            }
            System.out.println("Invoice");
            System.out.println("==============================");
            System.out.println();
            System.out.println("Fruit Cost");
            System.out.println("------------------");
            for (String key:buyMap.keySet()) {
                System.out.println(String.format("%-" + 15 + "s%-" + 15 + "s", key, Float.valueOf(fruitMap.get(key))*Float.valueOf(buyMap.get(key))));
            }
            System.out.println("------------------");
            System.out.println(String.format("%-" + 15 + "s%-" + 15 + "s", "Total:", total(fruitMap,buyMap)));

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    public static float total(Map <String,String>fruit,Map<String,String> buy){
        float total=0;
        for (String key:buy.keySet()) {
            total+= Float.valueOf(fruit.get(key))*Float.valueOf(buy.get(key));
        }
        return total;
    }
}
