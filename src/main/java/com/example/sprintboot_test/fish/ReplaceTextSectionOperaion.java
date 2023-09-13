package com.example.sprintboot_test.fish;

public class ReplaceTextSectionOperaion extends Operation {
    int beginlndex;
    int endlndex;
    String replacement;

    @Override
    String getDescription() {
        return "replaces the text section from " + beginlndex + " to " + endlndex + " by:" +replacement;
    }


    public ReplaceTextSectionOperaion(int beginlndex, int endlndex, String replacement) {
        this.beginlndex = beginlndex;
        this.endlndex = endlndex;
        this.replacement = replacement;
    }

    @Override
    TextDocument apply(TextDocument current) {
        System.out.println(getDescription());
        return current.replaceTextSection(beginlndex, endlndex, replacement);
    }
}
