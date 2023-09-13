package com.example.sprintboot_test.utils;

/**
 * @author yjz
 * @date 2023/5/4$ 14:24$
 * @description:
 */
public class removePaperFormat {
    public static void main(String[] args) {
        String inputStr = "Most of the previous studies focus on the achievement\n" +
                          "prediction of students based on enrollment data, the per-\n" +
                          "formance of students in a certain course, grade inflation,\n" +
                          "anticipated percentage of failing students and assist in grading\n" +
                          "system [3]. \n";
        String outputStr = inputStr.replaceAll("[\\r\\n\\x02]", ""); // 使用正则表达式去除 CRLF 和 STX 字符
        System.out.println("去除 CRLF 和 STX 后的字符串：" + outputStr);
    }
}
