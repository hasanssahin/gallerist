package com.hasansahin.gallerist.exception.handler;

import java.util.Date;

public class Exception<E> {
    private String path;
    private Date createTime;
    private String hostName;
    private E message;

    public Exception() {
    }

    public Exception(String path, Date createTime, String hostName, E message) {
        this.path = path;
        this.createTime = createTime;
        this.hostName = hostName;
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public E getMessage() {
        return message;
    }

    public void setMessage(E message) {
        this.message = message;
    }
}
