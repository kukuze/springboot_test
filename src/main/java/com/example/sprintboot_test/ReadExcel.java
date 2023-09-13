package com.example.sprintboot_test;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

public class ReadExcel {
    public static void main(String[] args) throws Exception {
        long t1 = new Date().getTime();
//        excel("C:\\Users\\CharmingZ1e\\Documents\\WeChat Files\\wxid_q9ufy9jc8eeu21\\FileStorage\\File\\2022-09\\工作簿2(1).xlsx");
        long t2 = new Date().getTime();

        System.out.println((t2-t1)/1000 + "秒");
    }

    public static ArrayList<String> excel(String url) throws Exception {
         File file = new File(url);
        if (!file.exists()){
            throw new Exception("文件不存在!");
        }
        InputStream in = new FileInputStream(file);

        // 读取整个Excel
        HSSFWorkbook sheets = new HSSFWorkbook(in);
        // 获取第一个表单Sheet
        HSSFSheet sheetAt = sheets.getSheetAt(0);

        //默认第一行为标题行，i = 0
        HSSFRow titleRow = sheetAt.getRow(0);
        ArrayList <String>arrayList = new ArrayList();
        // 循环获取每一行数据
        for (int i = 0; i < sheetAt.getPhysicalNumberOfRows(); i++) {
            HSSFRow row = sheetAt.getRow(i);
            // 读取每一格内容
            StringBuilder sb = new StringBuilder();
            String s = new String();
            for (int index = 0; index < row.getPhysicalNumberOfCells(); index++) {
                HSSFCell titleCell = titleRow.getCell(index);
                HSSFCell cell = row.getCell(index);
                cell.setCellType(CellType.STRING);
                if (cell.getStringCellValue().equals("")) {
                    continue;
                }
                sb.append(cell+" ");


            }
            String[] temp = sb.toString().split(" ");
            for (int j = 0; j <temp.length; j++) {
                arrayList.add(temp[j]);
            }

        }
        return arrayList;
    }
}
