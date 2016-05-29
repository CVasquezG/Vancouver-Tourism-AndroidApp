package com.camilovasquez.camilo.vancouverapp;


import android.os.Parcel;
import android.os.Parcelable;
import java.lang.*;

import java.util.ArrayList;


public class Attraction implements Parcelable{
    public  final int icon;
    public final String title;
    public final String city;
    public final double distance;
    public final int  desc;
    public final String website;
    public final double latitude;
    public final double longitude;
    public  ArrayList<Integer> images;
    public Attraction(int icon, String title, String city, double dist,int  description,String web, double latitude,double longitude, ArrayList<Integer> images) {

        this.icon = icon;
        this.title = title;
        this.city = city;
        this.distance = dist;
        this.desc = description;
        this.website = web;
        this.latitude = latitude;
        this.longitude = longitude;
        this.images = images;
    }


    protected Attraction(Parcel in) {
        icon = in.readInt();
        title = in.readString();
        city = in.readString();
        distance = in.readDouble();
        desc = in.readInt();
        website = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        images = in.readArrayList(null);

    }

    public static final Creator<Attraction> CREATOR = new Creator<Attraction>() {
        @Override
        public Attraction createFromParcel(Parcel in) {
            return new Attraction(in);
        }

        @Override
        public Attraction[] newArray(int size) {
            return new Attraction[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(icon);
        dest.writeString(title);
        dest.writeString(city);
        dest.writeDouble(distance);
        dest.writeInt(desc);
        dest.writeString(website);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeList(images);
    }


}

