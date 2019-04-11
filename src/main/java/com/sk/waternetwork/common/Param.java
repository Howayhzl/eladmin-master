package com.sk.waternetwork.common;

import java.util.Objects;

/**
 * Copyright by Xunge Software 2018. All right reserved
 *
 * @author YangWL
 * @date 2019/3/5 0005
 * @Description:
 */
public class Param {

    private  String Application;
    private  String AppId;
    private  String Platform;
    private  String Content;

    private  String Mobile;

    public String getApplication() {
        return Application;
    }

    public void setApplication(String application) {
        Application = application;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Param param = (Param) o;
        return Objects.equals(Application, param.Application) &&
                Objects.equals(AppId, param.AppId) &&
                Objects.equals(Platform, param.Platform) &&
                Objects.equals(Content, param.Content) &&
                Objects.equals(Mobile, param.Mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Application, AppId, Platform, Content, Mobile);
    }

    @Override
    public String toString() {
        return "Param{" +
                "Application='" + Application + '\'' +
                ", AppId='" + AppId + '\'' +
                ", Platform='" + Platform + '\'' +
                ", Content='" + Content + '\'' +
                ", Mobile='" + Mobile + '\'' +
                '}';
    }
}
