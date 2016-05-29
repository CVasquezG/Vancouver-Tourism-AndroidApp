package com.camilovasquez.camilo.vancouverapp;

import android.location.Location;

/**
 * Created by camiv on 2016-03-17.
 */
public class LocationExtended  extends Location{
    public LocationExtended(String provider) {
        super(provider);
    }

    public LocationExtended(double lat,double longitude){
        super("");
        this.setLatitude(lat);
        this.setLongitude(longitude);
    }

}
