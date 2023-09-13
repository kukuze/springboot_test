package com.example.sprintboot_test;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pet")
public class Pet {
    private String name;
    private String age;
    private Integer h;
    public Pet() {
    }
    public Pet(String name, String age) {
        this.name = name;
        this.age = age;
    }
    static public class Clothe{
        public String color;
    }
}
