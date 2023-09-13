package com.example.sprintboot_test.fish;

public class RemoveTextSectionOperation extends Operation{
    int beginlndex;
    int endlndex;

    @Override
    String getDescription() {
        return "removes the text section from "+beginlndex+" to "+endlndex;
    }

    public RemoveTextSectionOperation(int beginlndex, int endlndex) {
        this.beginlndex = beginlndex;
        this.endlndex = endlndex;
    }

    @Override
    TextDocument apply(TextDocument current) {
        System.out.println(getDescription());
        return current.removeTextSection(beginlndex,endlndex);
    }
}
