package com.trance.netstrategy.bean;

public class IpModel {
    private int code;
    private String ip;
    private String city;

    public IpModel(int code, String ip, String city) {
        this.code = code;
        this.ip = ip;
        this.city = city;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
