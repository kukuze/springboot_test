//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.sprintboot_test.mybatis;

public abstract class AbstractWrapper<T, R, Children extends AbstractWrapper<T, R, Children>>{
    public Children eq(boolean condition, R column, Object val) {
        return this.addCondition(column);
    }
    protected Children addCondition(R column) {
        this.columnToString(column);
        return null;
    }
    protected String columnToString(R column) {
//        System.out.println((String)column);
        return (String)column;
    }
}
