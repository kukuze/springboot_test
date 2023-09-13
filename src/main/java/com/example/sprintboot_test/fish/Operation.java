package com.example.sprintboot_test.fish;

public class Operation {
    String getDescription(){
        return "does not moditfythe document";
    }
    TextDocument apply(TextDocument current){
        return current.noop();
    }
}
