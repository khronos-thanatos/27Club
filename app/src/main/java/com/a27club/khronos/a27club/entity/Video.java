package com.a27club.khronos.a27club.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Video implements Parcelable {
   @SerializedName("Title")  private String Title;
    @SerializedName("Link") private String Link;
    @SerializedName("Thumb") private String Thumb;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getThumb() {
        return Thumb;
    }

    public void setThumb(String thumb) {
        Thumb = thumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Video(Parcel in) {
        Thumb = in.readString();
        Link = in.readString();
        Title = in.readString();
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel source) {
            return new Video(source);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Thumb);
        dest.writeString(Link);
        dest.writeString(Title);
    }
}
