package com.camilovasquez.camilo.vancouverapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by camiv on 2016-03-06.
 */
public class AttractionListAdapter extends ArrayAdapter<Attraction> {

    public AttractionListAdapter(Context context, List<Attraction> items) {
        super(context, R.layout.attraction_fragment, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.attraction_fragment, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvCity = (TextView) convertView.findViewById(R.id.tvCity);
            viewHolder.smallText = (TextView) convertView.findViewById(R.id.smallViewID);

            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }




        // update the item view
        Attraction item = getItem(position);
       // viewHolder.ivIcon.setImageResource(item.icon);
        viewHolder.ivIcon.setImageDrawable(getContext().getResources().getDrawable(item.icon));
        viewHolder.tvTitle.setText(item.title);
        viewHolder.tvCity.setText(item.city);
        viewHolder.smallText.setText(item.distance + "Km");
        return convertView;
    }


    private static class ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvCity;
        TextView smallText;
    }
}
