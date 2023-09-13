package com.example.sprintboot_test.utils;

import com.example.sprintboot_test.ReadExcel;

import java.util.ArrayList;
import java.util.HashSet;

public class generateQinglunBuSql {
    public static void main(String[] args) throws Exception {
        ArrayList<String> excel = ReadExcel.excel("C:\\Users\\CharmingZ1e\\Desktop\\石化项目\\1.5\\塑料部.xls");
        HashSet<String> strings = new HashSet<>();
        for (int i = 0; i <excel.size();) {
            strings.add("update "+excel.get(i+1)+" set "+excel.get(i+2)+" ='合成树脂部' where "+excel.get(i+2)+" ='塑料部';");
            i+=4;
        }
        for (String s:strings){
            System.out.println(s);
        }
        //update test_tb set address=replace(address,'东','西') where id=2
//        ArrayList<String> excel = ReadExcel.excel("C:\\Users\\CharmingZ1e\\Desktop\\石化项目\\1.5\\腈纶部Contain.xls");
//        for (int i = 0; i <excel.size();) {
//            System.out.println("update "+excel.get(i+1)+" set "+excel.get(i+2)+"=REPLACE("+excel.get(i+2)+",'腈纶部','"+"碳纤维部') where "+excel.get(i+2)+" like '%腈纶部%';");
//            i+=4;
//        }
    }
}
