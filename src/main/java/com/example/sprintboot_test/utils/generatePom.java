package com.example.sprintboot_test.utils;

import java.io.File;
//<dependency>
//<groupId>com.sun.activation</groupId>
//<artifactId>javax.activation</artifactId>
//<version>1.2.0</version>
//</dependency>
public class generatePom {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\CharmingZ1e\\Desktop\\石化项目最新包\\手工jar");
        for (File jar : dir.listFiles()) {
            String name = jar.getName();
            String groupId="jssh";
            String artifactId=name.substring(0,name.lastIndexOf("."));
            String version="1.0";
//            System.out.println("<dependency><groupId>"+groupId+"</groupId><artifactId>"+artifactId+"</artifactId>" +
//                    "<version>"+version+"</version></dependency>");

            System.out.println("mvn install:install-file -DgroupId="+groupId+" -DartifactId="+artifactId+" -Dversion="+version+" -Dpackaging=jar -Dfile="+name);
        }
    }
}
