package com.set.excelprj.test.pojo;

public class Result {
    public boolean flag;
    public String message;

    public Result(boolean flag) {
        this.flag = flag;
    }

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
