package com.lukehere.app.icondsc.pojo;

public class Alert {
    private int priority;
    private String alertTitle;
    private String alertBody;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getAlertTitle() {
        return alertTitle;
    }

    public void setAlertTitle(String alertTitle) {
        this.alertTitle = alertTitle;
    }

    public String getAlertBody() {
        return alertBody;
    }

    public void setAlertBody(String alertBody) {
        this.alertBody = alertBody;
    }
}