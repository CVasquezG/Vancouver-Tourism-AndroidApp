package com.camilovasquez.camilo.vancouverapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import java.util.List;



/**
 * Created by camiv on 2016-03-06.
 */
public class WeatherListAdapter extends ArrayAdapter<Weather> {

    public WeatherListAdapter(Context context, List<Weather> items) {
        super(context, R.layout.fragment_weather, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        int num = 0;
        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_weather, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.weatherTemp = (TextView) convertView.findViewById(R.id.weatherTemperature);
            viewHolder.weatherClouds = (TextView) convertView.findViewById(R.id.weatherTitle);
            viewHolder.weatherTime = (TextView) convertView.findViewById(R.id.weatherDescription);


            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }



        // update the item view
        Weather item = getItem(position);







////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////START HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!///////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        RelativeLayout relativeLayout = (RelativeLayout)convertView.findViewById(R.id.relativeLayoutWeather2);
        ImageView iconWeather = (ImageView)convertView.findViewById(R.id.weatherIcon);

        //CHANGE PIC DEPENDING ON THE CLOUDS HERE

        //could be something like this...
        switch (item.clouds){
            case "few clouds": //you have to search for all the possible cases on the openweathermap website and then get an icon for each and save it on drawables
                iconWeather.setImageResource(R.drawable.mostlycloudy);
                break;
            case "clear sky": //you have to search for all the possible cases on the openweathermap website and then get an icon for each and save it on drawables
                iconWeather.setImageResource(R.drawable.sunny);
                break;
            case "scattered clouds": //you have to search for all the possible cases on the openweathermap website and then get an icon for each and save it on drawables
                iconWeather.setImageResource(R.drawable.cloudy);
                break;
            case "broken clouds": //you have to search for all the possible cases on the openweathermap website and then get an icon for each and save it on drawables
                iconWeather.setImageResource(R.drawable.mostlycloudy);
                break;
            case "overcast clouds": //you have to search for all the possible cases on the openweathermap website and then get an icon for each and save it on drawables
                iconWeather.setImageResource(R.drawable.slightdrizzle);
                break;
            case "shower rain": //you have to search for all the possible cases on the openweathermap website and then get an icon for each and save it on drawables
                iconWeather.setImageResource(R.drawable.slightdrizzle);
                break;
            case "rain": //you have to search for all the possible cases on the openweathermap website and then get an icon for each and save it on drawables
                iconWeather.setImageResource(R.drawable.drizzle);
                break;
            case "thunderstorm": //you have to search for all the possible cases on the openweathermap website and then get an icon for each and save it on drawables
                iconWeather.setImageResource(R.drawable.thunderstorm);
                break;
            case "snow": //you have to search for all the possible cases on the openweathermap website and then get an icon for each and save it on drawables
                iconWeather.setImageResource(R.drawable.snow);
                break;
            case "mist": //you have to search for all the possible cases on the openweathermap website and then get an icon for each and save it on drawables
                iconWeather.setImageResource(R.drawable.haze);
                break;

            default:
                iconWeather.setImageResource(R.drawable.mostlycloudy);

        }




        if(position==0){
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////MAKE LAYOUT CHANGES FOR THE FIRST ITEM HERE!!!/////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////



            viewHolder.weatherTemp.setText(item.temperature.substring(0, item.temperature.indexOf('.')) + "°C");
            viewHolder.weatherClouds.setText(item.clouds);
            viewHolder.weatherTime.setText(item.time);



            relativeLayout.setBackgroundColor(getContext().getResources().getColor(R.color.colorPrimary));

            LayoutParams params = relativeLayout.getLayoutParams();
        // Changes the height to the specified *pixels*
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100, parent.getResources().getDisplayMetrics());


            iconWeather.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100, parent.getResources().getDisplayMetrics());;
            iconWeather.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100, parent.getResources().getDisplayMetrics());;

            params.height = height;
            relativeLayout.setLayoutParams(params);

            viewHolder.weatherTemp.setTextColor(Color.WHITE);
            viewHolder.weatherTemp.setTextSize(35);
            viewHolder.weatherTemp.setTypeface(Typeface.DEFAULT_BOLD);
            viewHolder.weatherClouds.setTextColor(Color.WHITE);
            viewHolder.weatherClouds.setTextSize(25);
            viewHolder.weatherClouds.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));


        }else {
            //DEFAULT VIEW
            //MAKE CHANGES ON THE fragment_weather.xml

            viewHolder.weatherTemp.setText(item.temperature.substring(0, item.temperature.indexOf('.')) + "°C");
            viewHolder.weatherClouds.setText(item.clouds);
            viewHolder.weatherTime.setText(item.time);
        }



        return convertView;
    }


    private static class ViewHolder {
        TextView weatherTemp;
        TextView weatherClouds;
        TextView weatherTime;
    }
}
