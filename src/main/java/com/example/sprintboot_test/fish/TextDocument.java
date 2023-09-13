package com.example.sprintboot_test.fish;

public class TextDocument {
    String content;

    public String getContent() {
        return content;
    }

    public TextDocument(String content) {
        this.content = content;
    }
    TextDocument undo(){
        return this;
    }
    TextDocument noop(){
        return new ModifiedTextDocument(content,this);
    }
    TextDocument replaceTextSection(int beginlndex, int endlndex, String replacement){
        String fir = content.substring(0,beginlndex);
        String last = content.substring(endlndex);
        String newStr=fir+replacement+last;
        return new ModifiedTextDocument(newStr,this);
    }
    TextDocument addTextAt(int position, String addition){
        String fir = content.substring(0,position);
        String last = content.substring(position);
        String newStr=fir+addition+last;
        return new ModifiedTextDocument(newStr,this);
    }
    // a b c d e f
    // 0 1 2 3 4 5
    TextDocument removeTextSection(int beginlndex,int endlndex){
        String fir = content.substring(0,beginlndex);
        String last = content.substring(endlndex);
        return new ModifiedTextDocument(fir+last,this);
    }
}
