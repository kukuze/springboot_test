package com.example.sprintboot_test;

import lombok.Data;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
@Data
public class User {
    private String name;
    private Integer age;
    static ArrayList<Integer>s=new ArrayList<>();
    {
        System.out.println("代码块");
    }
    static {
        s.add(1);
        System.out.println("静态代码块");
    }

    public User() {
        this.age=1;
        System.out.println("先执行无参构造");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化user");
    }


    public void test(Integer... a){
        System.out.println(a.getClass());
        System.out.println(a.length);
    }
    public <T> void fanxing(ArrayList<T>a){
        System.out.println(a);
    }
}
