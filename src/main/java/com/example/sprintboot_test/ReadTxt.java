package com.example.sprintboot_test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ReadTxt {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\CharmingZe\\Desktop\\test.txt");
        File newFile = new File("C:\\Users\\CharmingZe\\Desktop\\newtest.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(newFile));
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            List<String> list = new ArrayList<String>();
            while ((tempString = reader.readLine()) != null) {
                String[] str = tempString.split(",");
                for (int i = 0; i < str.length; i++) {
                    list.add(str[i]);
                }
            }
            reader.close();
            System.out.println(list.get(list.size()-1));
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i)+",");
                writer.flush();
                if((i+1)%7==0)
                    writer.newLine();
            }
//            for (int i = 0; i < list.size(); i++) {
//                System.out.print(list.get(i)+",");
//                if((i+1)%7==0)
//                    System.out.println();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}