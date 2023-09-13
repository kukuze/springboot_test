package com.example.sprintboot_test.utils;

import com.example.sprintboot_test.ReadExcel;

import java.util.ArrayList;

public class generateUuidMapErpcode {
    public static void main(String[] args) throws Exception {
//        ArrayList<String> excel = ReadExcel.excel("Z:\\Net\\石化项目\\1.7\\新建 XLS 工作表.xls");
//        StringBuffer sb=new StringBuffer();
//        for (int i = 0; i < excel.size(); i++) {
//            sb.append("'"+excel.get(i)+"',");
//        }
//        String substring = sb.substring(0, sb.length() - 1);
//        System.out.println("select equipment_uuid,erpcode from device where equipment_uuid in ("+substring+")");
        ArrayList<String> excel = ReadExcel.excel("Z:\\Net\\石化项目\\1.7\\map.xls");
        for (int i = 0; i < excel.size();) {
            System.out.println("update equipment_info_business set erpcode='"+excel.get(i+1)+"' where equipment_uuid='"+excel.get(i)+"';");
            i+=2;
        }
    }
}
