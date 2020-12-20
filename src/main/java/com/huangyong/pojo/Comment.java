package com.huangyong.pojo;

public class Comment {
    private Integer comment_id;
    private Integer blog_id;
    private String commentator;
    private String email;
    private String website_url;
    private String comment_body;
    private String comment_create_time;
    private String commentator_ip;
    private String reply_body;
    private String reply_create_time;
    private int comment_status;
    private int is_deleted;
    //验证码
    private String verifyCode;

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Integer blog_id) {
        this.blog_id = blog_id;
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public String getComment_body() {
        return comment_body;
    }

    public void setComment_body(String comment_body) {
        this.comment_body = comment_body;
    }

    public String getComment_create_time() {
        return comment_create_time;
    }

    public void setComment_create_time(String comment_create_time) {
        this.comment_create_time = comment_create_time;
    }

    public String getCommentator_ip() {
        return commentator_ip;
    }

    public void setCommentator_ip(String commentator_ip) {
        this.commentator_ip = commentator_ip;
    }

    public String getReply_body() {
        return reply_body;
    }

    public void setReply_body(String reply_body) {
        this.reply_body = reply_body;
    }

    public String getReply_create_time() {
        return reply_create_time;
    }

    public void setReply_create_time(String reply_create_time) {
        this.reply_create_time = reply_create_time;
    }

    public int getComment_status() {
        return comment_status;
    }

    public void setComment_status(int comment_status) {
        this.comment_status = comment_status;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", blog_id=" + blog_id +
                ", commentator='" + commentator + '\'' +
                ", email='" + email + '\'' +
                ", website_url='" + website_url + '\'' +
                ", comment_body='" + comment_body + '\'' +
                ", comment_create_time='" + comment_create_time + '\'' +
                ", commentator_ip='" + commentator_ip + '\'' +
                ", reply_body='" + reply_body + '\'' +
                ", reply_create_time='" + reply_create_time + '\'' +
                ", comment_status=" + comment_status +
                ", is_deleted=" + is_deleted +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
