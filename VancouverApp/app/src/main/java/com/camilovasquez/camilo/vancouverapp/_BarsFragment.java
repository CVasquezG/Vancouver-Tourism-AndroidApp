package com.camilovasquez.camilo.vancouverapp;

/**
 * Created by camiv on 2016-03-10.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.view.GestureDetectorCompat;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class _BarsFragment extends ListFragment {
    public  final List<Attraction> mItems = new ArrayList<Attraction>();        // ListView items list

    private GestureDetectorCompat gestureDetector;

    public _BarsFragment(){

        createList();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // initialize and set the list adapter
        setListAdapter(new AttractionListAdapter(getActivity(), mItems));



    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        Attraction item = mItems.get(position);




        // Toast.makeText(getActivity(),  item.title, Toast.LENGTH_SHORT).show();


        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putParcelable("aItem", item);
        i.putExtras(b);
        i.setClass(getActivity(), AttractionDetail.class);
        startActivity(i);







    }


    private void createList(){
        //GET USER LOCATION  using http://developer.android.com/training/location/retrieve-current.html


        MainActivity m = new MainActivity();
        double lat = MainActivity.mLatitude;
        double longi = MainActivity.mLongitude;

        LocationExtended userLocation = new LocationExtended(lat,longi);




        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_bar_black_24dp,
/*Name*/       "El Furniture Warehouse",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.279570,-123.122882))/10)/100.0,
/*desc*/       R.string.warehouse,
/*webs*/       "https://www.facebook.com/elfurny/",
/*lati*/       49.279570,-123.122882,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.warehouse);


        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_bar_black_24dp,
/*Name*/       "EXP Bar",
/*City*/       "Gastown",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.282361,-123.111155))/10)/100.0,
/*desc*/       R.string.exp,
/*webs*/       "http://www.expbar.ca/",
/*lati*/       49.282361,-123.111155,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.exp);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_bar_black_24dp,
/*Name*/       "Wings",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.277422,-123.125530))/10)/100.0,
/*desc*/       R.string.wings,
/*webs*/       "http://www.greatwings.ca/location/granville/",
/*lati*/       49.277422,-123.125530,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.wings);
            add(R.drawable.aquarium);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_bar_black_24dp,
/*Name*/       "Doolin's",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.279048,-123.123070))/10)/100.0,
/*desc*/       R.string.doolins,
/*webs*/       "http://www.doolins.ca/",
/*lati*/       49.279048,-123.123070,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.doolins);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_bar_black_24dp,
/*Name*/       "Roxy Burger",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.279867,-123.121512))/10)/100.0,
/*desc*/       R.string.roxy,
/*webs*/       "http://www.roxyburger.com",
/*lati*/       49.279867,-123.121512,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.roxy);


        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_bar_black_24dp,
/*Name*/       "Sip Lounge",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.278199,-123.124354))/10)/100.0,
/*desc*/       R.string.sip,
/*webs*/       "http://www.siplounge.com/",
/*lati*/       49.278199,-123.124354,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.siplounge);


        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_bar_black_24dp,
/*Name*/       "The Roadhouse",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.279981,-123.121283))/10)/100.0,
/*desc*/       R.string.roadhouse,
/*webs*/       "http://www.facebook.com/roadhousevan/",
/*lati*/       49.279981,-123.121283,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.roadhouse);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_bar_black_24dp,
/*Name*/       "Portside",
/*City*/       "Gastown",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.283557,-123.103819))/10)/100.0,
/*desc*/       R.string.portside,
/*webs*/       "http://www.theportsidepub.com/",
/*lati*/       49.283557,-123.103819,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.portside);


        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_bar_black_24dp,
/*Name*/       "The Pint",
/*City*/       "Gastown",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.281425,-123.107733))/10)/100.0,
/*desc*/       R.string.pint,
/*webs*/       "http://www.thepint.ca/vancouver/",
/*lati*/       49.281425,-123.107733,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.pint);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_bar_black_24dp,
/*Name*/       "SteamWorks",
/*City*/       "Gastown",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.284970,-123.110825))/10)/100.0,
/*desc*/       R.string.steamworks,
/*webs*/       "http://www.steamworks.com/",
/*lati*/       49.284970,-123.110825,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.steamworks);

        }}
        ));







        Collections.sort(mItems,new DistanceComparator());


    }



}
