package com.example.sprintboot_test.utils;

import com.example.sprintboot_test.ReadExcel;

import java.util.ArrayList;

public class generateUpdateUuid {
    public static void main(String[] args) throws Exception {
        ArrayList<String> excel = ReadExcel.excel("C:\\Users\\CharmingZ1e\\Desktop\\石化项目最新包1.0\\1.1\\uuid.xls");
        for (int i = 0; i <excel.size();) {
            System.out.println("update "+excel.get(i+1)+" set node_port=\"17004\" where "+excel.get(i)+" in (\"f6ec9f6837a2467179ac4ccf21ee3106\",\n" +
                    "        \"b1d26fd91fb7a84a916a5b6f68539d2d\",\n" +
                    "        \"8ce9c5dbf2ecdf4d8e553f9e816ae8b2\",\n" +
                    "        \"5b25526a8af88c6ae595a4b22929c625\",\n" +
                    "        \"4082a4e93768071b0c76825c690e0ab9\",\n" +
                    "        \"3514313b0079791bc0394f26223bf777\",\n" +
                    "        \"bd73560930022917ab5a5fbc2ffd06dd\",\n" +
                    "        \"57341c198bf00151306429a619976125\",\n" +
                    "        \"3990daeadefb5a4b5ef4830bc52ddd92\",\n" +
                    "        \"374e8a7cab24a5629bedc4d236d48ca8\");");
            i+=2;
        }
    }
}
