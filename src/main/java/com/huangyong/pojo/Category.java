package com.huangyong.pojo;

public class Category {
    private int category_id;
    private String category_name;
    private String category_icon;
    private int category_rank;
    private int is_deleted;
    private String create_time;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_icon() {
        return category_icon;
    }

    public void setCategory_icon(String category_icon) {
        this.category_icon = category_icon;
    }

    public int getCategory_rank() {
        return category_rank;
    }

    public void setCategory_rank(int category_rank) {
        this.category_rank = category_rank;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", category_icon='" + category_icon + '\'' +
                ", category_rank=" + category_rank +
                ", is_deleted=" + is_deleted +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
