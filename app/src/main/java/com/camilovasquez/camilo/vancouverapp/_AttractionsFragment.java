package com.camilovasquez.camilo.vancouverapp;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _AttractionsFragment extends ListFragment
        {
    public  final List<Attraction> mItems = new ArrayList<Attraction>();        // ListView items list


        public    _AttractionsFragment(){
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


        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putParcelable("aItem", item);
        i.putExtras(b);
        i.setClass(getActivity(), AttractionDetail.class);
        startActivity(i);

    }




    public void createList(){


        //GET USER LOCATION  using http://developer.android.com/training/location/retrieve-current.html


        MainActivity m = new MainActivity();
        double lat = MainActivity.mLatitude;
        double longi = MainActivity.mLongitude;
        LocationExtended userLocation = new LocationExtended(lat,longi);


        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_see_black_24dp,
/*Name*/       "Capilano Suspension Bridge",
/*City*/       "North Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.342931,-123.114818))/10)/100.0,
/*desc*/       R.string.capilano,
/*webs*/       "https://www.capbridge.com/",
/*lati*/       49.342931,-123.114818,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.capilanoone);
            add(R.drawable.capilanotwo);
            add(R.drawable.capilanothree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_see_black_24dp,
/*Name*/       "Vancouver Aquarium",
/*City*/       "Stanley Park",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.300789,-123.130944))/10)/100.0,
/*desc*/       R.string.aqua,
/*webs*/       "http://www.vanaqua.org/",
/*lati*/       49.300789,-123.130944,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.aquariumone);
            add(R.drawable.aquariumtwo);
            add(R.drawable.aquariumthree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_see_black_24dp,
/*Name*/       "Stanley Park Horse-Drawn Tours",
/*City*/       "Stanley Park",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.297665,-123.131326))/10)/100.0,
/*desc*/       R.string.horse,
/*webs*/       "http://www.tourismvancouver.com/listings/stanley-park-horse-drawn-tours/17529/",
/*lati*/       49.297665,-123.131326,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.horseone);
            add(R.drawable.horsetwo);
            add(R.drawable.horsethree);


        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_see_black_24dp,
/*Name*/       "Harbour Cruises and Events",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.294429,-123.132977))/10)/100.0,
/*desc*/       R.string.cruise,
/*webs*/       "http://www.boatcruises.com/",
/*lati*/       49.294429,-123.132977,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.cruiseone);
            add(R.drawable.cruisetwo);
            add(R.drawable.crabthree);

        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_see_black_24dp,
/*Name*/       "Fly Over Canada",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.289294,-123.109224))/10)/100.0,
/*desc*/       R.string.fly,
/*webs*/       "https://www.flyovercanada.com/",
/*lati*/       49.289294,-123.109224,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.flyone);
            add(R.drawable.flytwo);
            add(R.drawable.flythree);


        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_see_black_24dp,
/*Name*/       "Harbour Center",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.284659,-123.112100))/10)/100.0,
/*desc*/       R.string.harbour,
/*webs*/       "http://www.harbourcentre.com/",
/*lati*/       49.284659,-123.112100,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.harbourcentreone);
            add(R.drawable.harbourcentretwo);


        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_see_black_24dp,
/*Name*/       "Dr. Sun Yat-Sen Classical Chinese Garden",
/*City*/       "Chinatown",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.279619,-123.103931))/10)/100.0,
/*desc*/       R.string.garden,
/*webs*/       "http://www.vancouverchinesegarden.com/",
/*lati*/       49.279619,-123.103931,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.gardenone);
            add(R.drawable.gardentwo);
            add(R.drawable.gardenthree);


        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_see_black_24dp,
/*Name*/       "Vancouver Art Gallery (VAG)",
/*City*/       "Downtown Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.273378,-123.103848))/10)/100.0,
/*desc*/       R.string.vag,
/*webs*/       "http://www.vanartgallery.bc.ca/",
/*lati*/       49.273378,-123.103848,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.vagone);
            add(R.drawable.vagtwo);
            add(R.drawable.vagthree);


        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_see_black_24dp,
/*Name*/       "Science World",
/*City*/       "Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.273378,-123.103848))/10)/100.0,
/*desc*/       R.string.science,
/*webs*/       "https://www.scienceworld.ca",
/*lati*/       49.273378,-123.103848,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.scienceone);
            add(R.drawable.sciencetwo);
            add(R.drawable.sciencethree);


        }}
        ));
        mItems.add(new Attraction(
/*ICON*/       R.drawable.ic_local_see_black_24dp,
/*Name*/       "Grouse Mountain",
/*City*/       "North Vancouver",
/*loca*/      Math.round(userLocation.distanceTo(new LocationExtended(49.372275,-123.099475))/10)/100.0,
/*desc*/       R.string.grouse,
/*webs*/       "https://www.grousemountain.com/",
/*lati*/       49.372275,-123.099475,
/*pics*/       new ArrayList<Integer>(){{
            add(R.drawable.grouseone);
            add(R.drawable.grousetwo);
            add(R.drawable.grousethree);

        }}
        ));


        Collections.sort(mItems,new DistanceComparator());









    }







}
