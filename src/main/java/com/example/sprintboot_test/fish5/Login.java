package com.example.sprintboot_test.fish5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Login {
    static List<LoginInfo> employees=new ArrayList<>();

    static void register(int employeeId, String password) {
        if (employeeId < 0 || null == password) {
            System.out.println("Error!");
            return;
        }
        for (int i = 0; i < employees.size(); i++) {
            LoginInfo loginInfo = employees.get(i);
            if (loginInfo.getEmployeeId() == employeeId) {
                System.out.println("Employee already exists");
                return;
            }
        }
        employees.add(new LoginInfo(employeeId, password));
        System.out.println("Registration successful");
    }

    static boolean checkLogin(int employeeId, String password) {
        for (int i = 0; i < employees.size(); i++) {
            LoginInfo loginInfo = employees.get(i);
            if (loginInfo.getEmployeeId() == employeeId && loginInfo.getPassword().equals(password)) {
                System.out.println("Login successful for " + employeeId);
                return true;
            }
        }
        System.out.println("Error! Login information does not match");
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            String[] s1 = s.split(" ");
            if(s1[0].equals("q"))
                break;
            if(s1[0].equals("R"))
                register(Integer.valueOf(s1[1]),s1[2]);
            if(s1[0].equals("C"))
                checkLogin(Integer.valueOf(s1[1]),s1[2]);
        }
    }
}
class LoginInfo {
    int employeeId;
    String password;

    public LoginInfo(int employeeId, String password) {
        this.employeeId = employeeId;
        this.password = password;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getPassword() {
        return password;
    }
}
