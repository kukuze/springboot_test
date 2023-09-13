package com.example.sprintboot_test.fish;

public class Launcher {
    public static void main(String[] args) {
        Operation[] operations = new Operation[5];
        operations[0]=new AddTextAtOperation(0,"Hello Aachen!");
        operations[1]=new ReplaceTextSectionOperaion(6,12,"World");
        operations[2]=new UndoOperaion();
        operations[3]=new ReplaceTextSectionOperaion(0,5,"Goodbye");
        operations[4]=new RemoveTextSectionOperation(14,15);
        TextDocument textDocument = new TextDocument("");
        for (int i = 0; i < operations.length; i++) {
            TextDocument apply = operations[i].apply(textDocument);
            textDocument=apply;
            System.out.println(textDocument.getContent());
        }

    }
}
