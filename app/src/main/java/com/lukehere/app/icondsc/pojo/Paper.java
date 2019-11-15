package com.lukehere.app.icondsc.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Paper implements Parcelable {
    private int trackNumber;
    private String authorDetails;
    private String paperId;
    private String title;
    private String room;
    private String time;

    public Paper(int trackNumber, String authorDetails, String paperId, String title, String room, String time) {
        this.trackNumber = trackNumber;
        this.authorDetails = authorDetails;
        this.paperId = paperId;
        this.title = title;
        this.room = room;
        this.time = time;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getAuthorDetails() {
        return authorDetails;
    }

    public void setAuthorDetails(String authorDetails) {
        this.authorDetails = authorDetails;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private Paper(Parcel in) {
        trackNumber = in.readInt();
        authorDetails = in.readString();
        paperId = in.readString();
        title = in.readString();
        room = in.readString();
        time = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(trackNumber);
        dest.writeString(authorDetails);
        dest.writeString(paperId);
        dest.writeString(title);
        dest.writeString(room);
        dest.writeString(time);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Paper> CREATOR = new Parcelable.Creator<Paper>() {
        @Override
        public Paper createFromParcel(Parcel in) {
            return new Paper(in);
        }

        @Override
        public Paper[] newArray(int size) {
            return new Paper[size];
        }
    };
}