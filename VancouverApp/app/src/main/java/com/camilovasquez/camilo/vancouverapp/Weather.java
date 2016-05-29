package com.camilovasquez.camilo.vancouverapp;

/**
 * Created by camiv on 2016-03-30.
 */
public class Weather {

    public final String temperature;
    public final String clouds;
    public final String time;

    public Weather(String temperature, String clouds, String time) {

       this.temperature = temperature;
        this.clouds = clouds;
        this.time = time;
    }
}