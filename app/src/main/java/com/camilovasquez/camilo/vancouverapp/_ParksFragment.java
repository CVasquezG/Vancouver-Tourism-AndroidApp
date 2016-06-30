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



public class _ParksFragment extends ListFragment {
    public final List<Attraction> mItems = new ArrayList<Attraction>();        // ListView items list

    private GestureDetectorCompat gestureDetector;

    public _ParksFragment(){
        createList();

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //GET USER LOCATION  using http://developer.android.com/training/location/retrieve-current.html



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

        MainActivity m = new MainActivity();
        double lat = MainActivity.mLatitude;
        double longi = MainActivity.mLongitude;

        LocationExtended userLocation = new LocationExtended(lat,longi);


        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_terrain_black_24dp,
/*Name*/       "Stanley Park",
/*City*/       "Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.304209,-123.139211))/10)/100.0,
/*desc*/       R.string.stanley,
/*webs*/       "http://www.vancouver.ca/parks-recreation-culture/stanley-park.aspx",
/*lati*/       49.304209,-123.139211,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.stanleyone);
            add(R.drawable.stanleytwo);
            add(R.drawable.stanleythree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_terrain_black_24dp,
/*Name*/       "Queen Elizabeth Park",
/*City*/       "Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.241668,-123.112682))/10)/100.0,
/*desc*/       R.string.queen,
/*webs*/       "http://www.vancouver.ca/parks-recreation-culture/queen-elizabeth-park.aspx",
/*lati*/       49.241668,-123.112682,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.queenone);
            add(R.drawable.queentwo);
            add(R.drawable.queenthree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_terrain_black_24dp,
/*Name*/       "Lynn Canyon Park",
/*City*/       "North Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.343388,-123.018464))/10)/100.0,
/*desc*/       R.string.lynn,
/*webs*/       "http://lynncanyon.ca/",
/*lati*/       49.343388,-123.018464,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.lynnone);
            add(R.drawable.lynntwo);
            add(R.drawable.lynnthree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_terrain_black_24dp,
/*Name*/       "Trout Lake",
/*City*/       "East Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.255317,-123.065343))/10)/100.0,
/*desc*/       R.string.trout,
/*webs*/       "http://troutlakecc.com/",
/*lati*/       49.255317,-123.065343,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.troutone);
            add(R.drawable.trouttwo);
            add(R.drawable.troutthree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_terrain_black_24dp,
/*Name*/       "Pacific Spirit Park",
/*City*/       "UBC",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.252826,-123.215666))/10)/100.0,
/*desc*/       R.string.spirit,
/*webs*/       "https://www.vancouvertrails.com/trails/pacific-spirit-regional-park/",
/*lati*/       49.252826,-123.215666,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.spiritone);
            add(R.drawable.spirittwo);
            add(R.drawable.spiritthree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_terrain_black_24dp,
/*Name*/       "Crab Park",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.284654,-123.102348))/10)/100.0,
/*desc*/       R.string.crab,
/*webs*/       "http://vancouver.ca/parks-recreation-culture/crab-park-at-portside-dog-park.aspx",
/*lati*/       49.284654,-123.102348,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.crabtwo);
            add(R.drawable.crabtwo);
            add(R.drawable.crabthree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_terrain_black_24dp,
/*Name*/       "George Wainborn Park",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.272680,-123.128939))/10)/100.0,
/*desc*/       R.string.george,
/*webs*/       "http://www.insidevancouver.ca/2013/06/22/yaletowns-best-kept-secret-inside-george-wainborn-park/",
/*lati*/       49.272680,-123.128939,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.georgeone);
            add(R.drawable.georgetwo);
            add(R.drawable.georgethree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_terrain_black_24dp,
/*Name*/       "Harbour Green Park",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.290218,-123.121906))/10)/100.0,
/*desc*/       R.string.harbour,
/*webs*/       "http://www.pwlpartnership.com/our-portfolio/waterfronts/harbour-green-park",
/*lati*/       49.290218,-123.121906,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.harbourgreenone);
            add(R.drawable.harbourgreentwo);
            add(R.drawable.harbourgreenthree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_terrain_black_24dp,
/*Name*/       "David Lam Park",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.272820,-123.124693))/10)/100.0,
/*desc*/       R.string.david,
/*webs*/       "http://www.lonelyplanet.com/canada/vancouver/sights/parks-gardens/david-lam-park",
/*lati*/       49.272820,-123.124693,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.davidone);
            add(R.drawable.davidtwo);
            add(R.drawable.davidthree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_terrain_black_24dp,
/*Name*/       "Victory Square",
/*City*/       "Gastown",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.282518,-123.109928))/10)/100.0,
/*desc*/       R.string.victory,
/*webs*/       "https://www.cdli.ca/monuments/bc/victory.htm",
/*lati*/       49.282518,-123.109928,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.victoryone);
            add(R.drawable.victorytwo);
            add(R.drawable.victorythree);

        }}
        ));







        Collections.sort(mItems,new DistanceComparator());



    }



}
