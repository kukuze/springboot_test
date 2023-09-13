package com.example.sprintboot_test.fish;

public class AddTextAtOperation extends Operation {
    int position;
    String addition;

    public AddTextAtOperation(int position, String addition) {
        this.position = position;
        this.addition = addition;
    }

    @Override
    String getDescription() {
        return "adds the following text at position "+position+": "+addition;
    }

    @Override
    TextDocument apply(TextDocument current) {
        System.out.println(getDescription());
        return current.addTextAt(position,addition);
    }
}
