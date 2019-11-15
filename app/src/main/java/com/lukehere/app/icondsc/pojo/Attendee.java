package com.lukehere.app.icondsc.pojo;

public class Attendee {

    private String mFirstName;

    private String mLastName;

    private String mEmailAddress;

    private String mPhoneNumber;

    private String mOrganization;

    private String mPaperId;

    public Attendee(String mFirstName, String mLastName, String mEmailAddress, String mPhoneNumber, String mOrganization, String mPaperId) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mEmailAddress = mEmailAddress;
        this.mPhoneNumber = mPhoneNumber;
        this.mOrganization = mOrganization;
        this.mPaperId = mPaperId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getEmailAddress() {
        return mEmailAddress;
    }

    public void setEmailAddress(String mEmailAddress) {
        this.mEmailAddress = mEmailAddress;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getOrganization() {
        return mOrganization;
    }

    public void setOrganization(String mOrganization) {
        this.mOrganization = mOrganization;
    }

    public String getPaperId() {
        return mPaperId;
    }

    public void setPaperId(String mPaperId) {
        this.mPaperId = mPaperId;
    }
}
