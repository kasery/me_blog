package com.huangyong.pojo;

public class View {
    private int viewNum;
    private String date;

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "View{" +
                "viewNum=" + viewNum +
                ", date='" + date + '\'' +
                '}';
    }
}
