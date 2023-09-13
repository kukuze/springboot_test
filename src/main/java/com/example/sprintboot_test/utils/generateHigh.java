package com.example.sprintboot_test.utils;

import com.example.sprintboot_test.ReadExcel;

import java.util.ArrayList;

public class generateHigh {
    public static void main(String[] args) throws Exception {
        ArrayList<String> excel = ReadExcel.excel("Z:\\Net\\石化项目\\1.6\\新建 XLS 工作表.xls");
        for (int i = 0; i <excel.size();i++) {
            System.out.println("update device set riskpump='1' where erpcode= '"+excel.get(i)+"';");
        }
    }
}
