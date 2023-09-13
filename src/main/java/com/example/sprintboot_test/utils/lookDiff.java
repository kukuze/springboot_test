package com.example.sprintboot_test.utils;

import com.example.sprintboot_test.ReadExcel;

import java.util.ArrayList;

/**
 * @author yjz
 * @date 2023/5/16$ 23:23$
 * @description:
 */
public class lookDiff {
    public static void main(String[] args) throws Exception {
        ArrayList<String> excel = ReadExcel.excel("C:\\Users\\CharmingZe\\Desktop\\old\\新建 XLS 工作表.xls");
        ArrayList<String> excel2 = ReadExcel.excel("C:\\Users\\CharmingZe\\Desktop\\old\\新建 XLS 工作表 (2).xls");

        for (int i = 0; i <excel.size();i++) {
            if (!excel2.contains(excel.get(i))) {
                System.out.println(excel.get(i));
            }
        }
    }
}

