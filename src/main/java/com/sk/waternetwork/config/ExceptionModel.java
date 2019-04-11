package com.sk.waternetwork.config;

/**
 * Created by Administrator on 2019/3/12.
 */
public class ExceptionModel {
    private String ip;
    private String method;
    private String reason;
    private String time;

    public ExceptionModel() {
    }

    public ExceptionModel(String ip, String method, String reason, String time) {
        this.ip = ip;
        this.method = method;
        this.reason = reason;
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ExceptionModel{" +
                "ip='" + ip + '\'' +
                ", method='" + method + '\'' +
                ", reason='" + reason + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
