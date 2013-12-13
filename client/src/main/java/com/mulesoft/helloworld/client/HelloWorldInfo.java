package com.mulesoft.helloworld.client;

import java.io.Serializable;

public class HelloWorldInfo implements Serializable {
    private String token;
    private String tabName;
    private String url;

    public HelloWorldInfo() {
        super();
    }
    public HelloWorldInfo(String name, String url, String token) {
        this.tabName = name;
        this.url = url;
        this.token = token;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getTabName() {
        return tabName;
    }
    public void setTabName(String tabName) {
        this.tabName = tabName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
