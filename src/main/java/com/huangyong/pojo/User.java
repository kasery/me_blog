package com.huangyong.pojo;

public class User {
    private Integer admin_user_id;

    private String login_user_name;

    private String login_password;

    private String nick_name;

    private Byte locked;

    public User() {

    }

    public User(Integer admin_user_id, String login_user_name, String login_password, String nick_name, Byte locked) {
        this.admin_user_id = admin_user_id;
        this.login_user_name = login_user_name;
        this.login_password = login_password;
        this.nick_name = nick_name;
        this.locked = locked;
    }

    public Integer getAdmin_user_id() {
        return admin_user_id;
    }

    public void setAdmin_user_id(Integer admin_user_id) {
        this.admin_user_id = admin_user_id;
    }

    public String getLogin_user_name() {
        return login_user_name;
    }

    public void setLogin_user_name(String login_user_name) {
        this.login_user_name = login_user_name;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "User{" +
                "admin_user_id=" + admin_user_id +
                ", login_user_name='" + login_user_name + '\'' +
                ", login_password='" + login_password + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", locked=" + locked +
                '}';
    }
}