package com.huangyong.pojo;
import java.util.List;

public class Config {
    private String config_name;
    private String config_value;
    private String create_time;
    private String update_time;
    private List<Config> configList;

    public Config() {

    }

    public Config(String config_name, String config_value, String create_time, String update_time,List<Config> configList ) {
        this.config_name = config_name;
        this.config_value = config_value;
        this.create_time = create_time;
        this.update_time = update_time;
        this.configList = configList;
    }

    public String getConfig_name() {
        return config_name;
    }

    public void setConfig_name(String config_name) {
        this.config_name = config_name;
    }

    public String getConfig_value() {
        return config_value;
    }

    public void setConfig_value(String config_value) {
        this.config_value = config_value;
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

    public List<Config> getConfigList() {
        return configList;
    }

    public void setConfigList(List<Config> configList) {
        this.configList = configList;
    }

    @Override
    public String toString() {
        return "Config{" +
                "config_name='" + config_name + '\'' +
                ", config_value='" + config_value + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", configList=" + configList +
                '}';
    }
}
