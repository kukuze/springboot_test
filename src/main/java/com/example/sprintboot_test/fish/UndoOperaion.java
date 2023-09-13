package com.example.sprintboot_test.fish;

public class UndoOperaion extends Operation{
    @Override
    String getDescription() {
        return "reverts the previous operation";
    }

    @Override
    TextDocument apply(TextDocument current) {
        System.out.println(getDescription());
        return current.undo();
    }
}
