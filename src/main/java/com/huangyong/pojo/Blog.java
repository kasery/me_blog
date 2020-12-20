package com.huangyong.pojo;

public class Blog {
    private Integer blog_id;
    private String blog_title;
    private String  blog_sub_url;
    private String blog_cover_image;
    private String blog_content;
    private int blog_category_id;
    private String blog_category_name;
    private String blog_tags;
    private int blog_status;
    private Integer blog_views;
    private int enable_comment;
    private int is_deleted;
    private String create_time;
    private String update_time;

    public Integer getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Integer blog_id) {
        this.blog_id = blog_id;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title;
    }

    public String getBlog_sub_url() {
        return blog_sub_url;
    }

    public void setBlog_sub_url(String blog_sub_url) {
        this.blog_sub_url = blog_sub_url;
    }

    public String getBlog_cover_image() {
        return blog_cover_image;
    }

    public void setBlog_cover_image(String blog_cover_image) {
        this.blog_cover_image = blog_cover_image;
    }

    public String getBlog_content() {
        return blog_content;
    }

    public void setBlog_content(String blog_content) {
        this.blog_content = blog_content;
    }

    public int getBlog_category_id() {
        return blog_category_id;
    }

    public void setBlog_category_id(int blog_category_id) {
        this.blog_category_id = blog_category_id;
    }

    public String getBlog_category_name() {
        return blog_category_name;
    }

    public void setBlog_category_name(String blog_category_name) {
        this.blog_category_name = blog_category_name;
    }

    public String getBlog_tags() {
        return blog_tags;
    }

    public void setBlog_tags(String blog_tags) {
        this.blog_tags = blog_tags;
    }

    public int getBlog_status() {
        return blog_status;
    }

    public void setBlog_status(int blog_status) {
        this.blog_status = blog_status;
    }

    public Integer getBlog_views() {
        return blog_views;
    }

    public void setBlog_views(Integer blog_views) {
        this.blog_views = blog_views;
    }

    public int getEnable_comment() {
        return enable_comment;
    }

    public void setEnable_comment(int enable_comment) {
        this.enable_comment = enable_comment;
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

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blog_id=" + blog_id +
                ", blog_title='" + blog_title + '\'' +
                ", blog_sub_url='" + blog_sub_url + '\'' +
                ", blog_cover_image='" + blog_cover_image + '\'' +
                ", blog_content='" + blog_content + '\'' +
                ", blog_category_id=" + blog_category_id +
                ", blog_category_name='" + blog_category_name + '\'' +
                ", blog_tags='" + blog_tags + '\'' +
                ", blog_status=" + blog_status +
                ", blog_views=" + blog_views +
                ", enable_comment=" + enable_comment +
                ", is_deleted=" + is_deleted +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
