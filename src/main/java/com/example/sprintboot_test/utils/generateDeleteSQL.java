package com.example.sprintboot_test.utils;

import com.example.sprintboot_test.ReadExcel;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author yjz
 * @date 2023/4/26$ 10:33$
 * @description:
 */
public class generateDeleteSQL {
    public static void main(String[] args) throws Exception {
        ArrayList<String> excel = ReadExcel.excel("C:\\Users\\CharmingZe\\Desktop\\new\\新建 XLS 工作表.xls");
        StringBuffer buffer=new StringBuffer();
        HashSet<String> erpCodeSetAndAlarmId = new HashSet<>();
        String condi="\"%s\",";
        buffer.append("delete *  from equipment_info_bussiness where id in(");
        HashSet<String> remainIdSet = new HashSet<>();
        HashSet<String> allIdSet = new HashSet<>();

        for (int i = 0; i < excel.size(); i+=3) {
            allIdSet.add(excel.get(i));
            erpCodeSetAndAlarmId.add(excel.get(i+1)+excel.get(i+2));
        }
        for (int i = 0; i < excel.size(); i+=3) {
            if(erpCodeSetAndAlarmId.contains(excel.get(i+1)+excel.get(i+2))){
                remainIdSet.add(excel.get(i));
                erpCodeSetAndAlarmId.remove(excel.get(i+1)+excel.get(i+2));
            }
        }
        allIdSet.removeAll(remainIdSet);
        allIdSet.forEach(a->{
            buffer.append(String.format(condi,a));
        });

        buffer.append(")");
        System.out.println(buffer.toString());
    }
}
