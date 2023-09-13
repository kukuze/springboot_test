package com.example.sprintboot_test.utils;

import com.example.sprintboot_test.ReadExcel;

import java.util.ArrayList;

public class generateQiantang {
    public static void main(String[] args) throws Exception {
        ArrayList<String> excel = ReadExcel.excel("C:\\Users\\CharmingZ1e\\Documents\\WeChat Files\\wxid_q9ufy9jc8eeu21\\FileStorage\\File\\2022-12\\11月热点.xls");
        int cur=1;
        for (int i = 0; i <excel.size();i+=9) {
            System.out.println("update atmosphere_sum_grid_tj set jddm= "+excel.get(i+1)+" where id="+cur+++";");
        }
    }
}
