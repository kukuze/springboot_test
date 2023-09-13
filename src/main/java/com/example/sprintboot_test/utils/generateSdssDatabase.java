package com.example.sprintboot_test.utils;

import java.util.ArrayList;

public class generateSdssDatabase {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>() {{
            add("balance");
            add("dongying");
            add("htcz_dy");
            add("kaihua");
            add("mengzi");
            add("qujiang");
            add("quzhou");
            add("qzdhy");
            add("sdss");
            add("sdss4bz");
        }};
        for (int i = 0; i < strings.size(); i++) {
            String s="INSERT INTO sdss_database VALUES ('"+(i+1)+"', '"+strings.get(i)+"', 'postgresql', NULL, NULL,NULL,NULL,NULL);";
            System.out.println(s);
        }

    }
}
