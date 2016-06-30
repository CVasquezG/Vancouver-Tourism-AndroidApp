package com.camilovasquez.camilo.vancouverapp;

import java.util.Comparator;

/**
 * Created by camiv on 2016-03-18.
 */
public class DistanceComparator implements Comparator<Attraction> {

    @Override
    public int compare(Attraction lhs, Attraction rhs) {

        return ((Double)lhs.distance).compareTo(rhs.distance);
    }
}
