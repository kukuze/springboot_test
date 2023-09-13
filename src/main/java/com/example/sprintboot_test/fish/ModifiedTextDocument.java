package com.example.sprintboot_test.fish;

public class ModifiedTextDocument extends TextDocument {
    TextDocument pre;

    public ModifiedTextDocument(String content, TextDocument pre) {
        super(content);
        this.pre = pre;
    }

    @Override
    public TextDocument undo() {
        return pre;
    }
}
