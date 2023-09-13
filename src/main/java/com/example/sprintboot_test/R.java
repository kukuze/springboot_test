package com.example.sprintboot_test;

public class R<T> {
    Integer code=200;
    T data;
    String message;

    public R(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public R(T data) {
        this.data = data;
    }
    public static R error(String res){
        return new R(10000,res);
    }
    public static R success(Object data){
        return new R(data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
