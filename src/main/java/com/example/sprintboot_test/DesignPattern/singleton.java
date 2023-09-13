package com.example.sprintboot_test.DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CharmingZe
 * @version 1.0
 * @data 2023/2/15 20:16
 */
public class singleton {
    private volatile static List<String>list=null;
    public static List<String>getList(){
        if(list==null){
            synchronized (singleton.class){
                if(list==null)
                    list=new ArrayList<>();
            }
        }
        return list;
    }
}
