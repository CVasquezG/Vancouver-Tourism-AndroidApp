package com.camilovasquez.camilo.vancouverapp;

/**
 * Created by camiv on 2016-03-14.
 */

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class MapFragment extends Fragment implements GoogleMap.OnInfoWindowClickListener {

    MapView mMapView;
    private GoogleMap googleMap;
    private Marker firstMaker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout
        View v = inflater.inflate(R.layout.fragment_map, container,
                false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }


        googleMap = mMapView.getMap();
        // latitude and longitude
        double latitude = 49.285556;
        double longitude = -123.122956;

        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        googleMap.setOnInfoWindowClickListener(this);












        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);

        } else {
            // Show rationale and request permission.
            Toast.makeText(getActivity(), "Enable location service", Toast.LENGTH_SHORT).show();

        }
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);



        List<MarkerOptions> markers = new ArrayList<>();
        markers.add(new MarkerOptions()
                .position(new LatLng(49.279570,-123.122882))
                .title("El Furniture Warehouse")
                .snippet("$5 dollar meals!!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                ));

        markers.add(new MarkerOptions()
                .position(new LatLng(49.282361,-123.111155))
                .title("EXP Bar")
                .snippet("Video drinks")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.277422,-123.125530))
                .title("Wings")
                .snippet("WINGS!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.279048,-123.123070))
                .title("Doolin's")
                .snippet("Irish pub!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.279867,-123.121512))
                .title("Roxy Burger")
                .snippet("Burgers!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.278199,-123.124354))
                .title("Sip Lounge")
                .snippet("Unique downtown lounge")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.279981,-123.121283))
                .title("The Roadhouse")
                .snippet("Country bar!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.283557,-123.103819))
                .title("Portside")
                .snippet("Maritime pub!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.281425,-123.107733))
                .title("The Pint")
                .snippet("Sports Bar!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.284970,-123.110825))
                .title("SteamWorks")
                .snippet("Craft Brewery!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.342931,-123.114818))
                .title("Capilano Suspension Bridge")
                .snippet("TREES!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.300789,-123.130944))
                .title("Vancouver Aquarium")
                .snippet("Mammals and Fish!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.297665,-123.131326))
                .title("Stanley Park Horse-Drawn Tours")
                .snippet("HORSES!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.294429,-123.132977))
                .title("Harbour Cruises and Events")
                .snippet("IM ON A BOAT!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.289294,-123.109224))
                .title("Fly Over Canada")
                .snippet("Fly You Fools!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.284659,-123.112100))
                .title("Harbour Center")
                .snippet("360 View!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.279619,-123.103931))
                .title("Dr. Sun Yat-Sen Classical Chinese Garden")
                .snippet("Beautiful Trees!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.282961,-123.120479))
                .title("Vancouver Art Gallery (VAG)")
                .snippet("Art & Hipsters!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.273378,-123.103848))
                .title("Science World")
                .snippet("World of Science!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.372275,-123.099475))
                .title("Grouse Mountain")
                .snippet("Average Sized Hill!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.304209,-123.139211))
                .title("Stanley Park")
                .snippet("Baby Raccoons!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.241668,-123.112682))
                .title("Queen Elizabeth Park")
                .snippet("Pretty Flowers!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.343388,-123.018464))
                .title("Lynn Canyon Park")
                .snippet("Free!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.255317,-123.065343))
                .title("Trout Lake")
                .snippet("FISH!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.252826,-123.215666))
                .title("Pacific Spirit Park")
                .snippet("Forested Trail!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.284654,-123.102348))
                .title("Crab Park")
                .snippet("Dog Park!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.272680,-123.128939))
                .title("George Wainborn Park")
                .snippet("Water Side Park!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.290218,-123.121906))
                .title("Harbour Green Park")
                .snippet("It's Green!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.272820,-123.124693))
                .title("David Lam Park")
                .snippet("Landscaped WaterFront Park!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                ));
        markers.add(new MarkerOptions()
                .position(new LatLng(49.282518,-123.109928))
                .title("Victory Square")
                .snippet("It's a Rectangle!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                ));





        for (MarkerOptions m: markers) {
            googleMap.addMarker(m);
        }
        






        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude)).zoom(13).tilt(45).build();


        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

        // Perform any camera updates here
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


    @Override
    public void onInfoWindowClick(Marker marker) {


        _AttractionsFragment attractionsFragment = new _AttractionsFragment();
        _ParksFragment parksFragment = new _ParksFragment();
        _BarsFragment barsFragment = new _BarsFragment();

        List<Attraction> listAttractions = attractionsFragment.mItems;
        List<Attraction> listParks = parksFragment.mItems;
        List<Attraction> listBars = barsFragment.mItems;
        List<Attraction> listAll = new ArrayList<>();

       listAll.addAll(listAttractions);
        listAll.addAll(listParks);
        listAll.addAll(listBars);

        for (Attraction item:  listAll) {
            if(item.title.equals(marker.getTitle())){
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putParcelable("aItem", item);
                i.putExtras(b);
                i.setClass(getActivity(), AttractionDetail.class);
                startActivity(i);
            }
        }



    }



}