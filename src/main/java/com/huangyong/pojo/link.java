package com.huangyong.pojo;

public class link {
    private int link_id;
    private int link_type;
    private String link_name;
    private String link_url;
    private String link_description;
    private int link_rank;
    private int is_deleted;
    private String create_time;

    public int getLink_id() {
        return link_id;
    }

    public void setLink_id(int link_id) {
        this.link_id = link_id;
    }

    public int getLink_type() {
        return link_type;
    }

    public void setLink_type(int link_type) {
        this.link_type = link_type;
    }

    public String getLink_name() {
        return link_name;
    }

    public void setLink_name(String link_name) {
        this.link_name = link_name;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getLink_description() {
        return link_description;
    }

    public void setLink_description(String link_description) {
        this.link_description = link_description;
    }

    public int getLink_rank() {
        return link_rank;
    }

    public void setLink_rank(int link_rank) {
        this.link_rank = link_rank;
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
        return "link{" +
                "link_id=" + link_id +
                ", link_type=" + link_type +
                ", link_name='" + link_name + '\'' +
                ", link_url='" + link_url + '\'' +
                ", link_description='" + link_description + '\'' +
                ", link_rank=" + link_rank +
                ", is_deleted=" + is_deleted +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
