package com.camilovasquez.camilo.vancouverapp;


import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import java.util.List;


public class AttractionDetail extends AppCompatActivity implements  View.OnClickListener{


 //   private Attraction aItem;

    public AttractionDetail(){}

    private List<Integer> images;
    private double latitude,longitude;

    private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2,fab3,fab4;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;


    //position of the pic
    private int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);

        //Back on actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Resources resources = getResources();

        TextView titleText = (TextView)findViewById(R.id.txtAttractionName);
        final   ImageSwitcher imageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher);
        TextView description = (TextView)findViewById(R.id.descriptionTextView);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.textLayout);



///GET Attraction OBJECT FROM INTENT
        final Attraction attraction;
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            attraction = b.getParcelable("aItem");
            titleText.setText(attraction.title);
            titleText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse(attraction.website)));
                }

            });
           //aaaaaaaa linearLayout.setBackgroundColor(getResources().getColor(R.color.colorFAB1));

            latitude = attraction.latitude;
            longitude = attraction.longitude;
            description.setText(attraction.desc);

          // Toast.makeText(this,String.valueOf(attraction.desc),Toast.LENGTH_SHORT).show();

            images = attraction.images;

        }
//FLOATING ICONS!
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab1 = (FloatingActionButton)findViewById(R.id.fab1);
        fab2 = (FloatingActionButton)findViewById(R.id.fab2);
        fab3 = (FloatingActionButton)findViewById(R.id.fab3);
        fab4 = (FloatingActionButton)findViewById(R.id.fab4);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab4.setOnClickListener(this);



        //IMAGE SWITCHER
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());

                myView.setImageResource(images.get(pos));
                myView.setScaleType(ImageView.ScaleType.FIT_XY);
                return myView;
            }
        });


       // img.setImageDrawable(images.get(pos));

        imageSwitcher.setOnTouchListener(new OnSwipeTouchListener(AttractionDetail.this) {
            public void onSwipeTop() {
            //  Toast.makeText(AttractionDetail.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                if(pos!=0) {
                    pos--;
                    // img.setImageDrawable(images.get(pos));



                    imageSwitcher.setInAnimation(AttractionDetail.this, R.anim.slide_in_left);
                    imageSwitcher.setOutAnimation(AttractionDetail.this, R.anim.slide_out_right);
                  //  imageSwitcher.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));


                    imageSwitcher.setImageResource(images.get(pos));
                    imageSwitcher.requestLayout();
                }
                //Toast.makeT
                // ext(AttractionDetail.this,String.valueOf(pos), Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                if (pos<images.size()-1) {
                    pos++;
                    // img.setImageDrawable(images.get(pos));


                    imageSwitcher.setInAnimation(AttractionDetail.this, R.anim.slide_in_right);
                    imageSwitcher.setOutAnimation(AttractionDetail.this, R.anim.slide_out_left);

                //    imageSwitcher.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));


                    imageSwitcher.setImageResource(images.get(pos));
                    imageSwitcher.requestLayout();

                }

             //   Toast.makeText(AttractionDetail.this,String.valueOf(pos), Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
              //Toast.makeText(AttractionDetail.this, "bottom", Toast.LENGTH_SHORT).show();


            }

        });






    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:
                animateFAB();
                break;
            case R.id.fab1:
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+latitude+", "+longitude);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);



                break;
            case R.id.fab2:

                Uri gmmIntentUri2 = Uri.parse("geo:"+latitude+", "+longitude+"?q=stores");
                Intent mapIntent2 = new Intent(Intent.ACTION_VIEW, gmmIntentUri2);
                mapIntent2.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent2);
                break;
            case R.id.fab3:

                Uri gmmIntentUri3 =  Uri.parse("geo:"+latitude+", "+longitude+"?q=restaurants");
                Intent mapIntent3 = new Intent(Intent.ACTION_VIEW, gmmIntentUri3);
                mapIntent3.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent3);
                break;
            case R.id.fab4:

                Uri gmmIntentUri4 =  Uri.parse("geo:"+latitude+", "+longitude+"?q=hotels");
                Intent mapIntent4 = new Intent(Intent.ACTION_VIEW, gmmIntentUri4);
                mapIntent4.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent4);
                break;


        }
    }
    public void animateFAB(){

        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab4.startAnimation(fab_close);

            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);

            isFabOpen = false;


        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab4.startAnimation(fab_open);

            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);

            isFabOpen = true;


        }
    }
}














