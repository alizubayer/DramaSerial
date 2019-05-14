package com.example.dramaserial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    String[] countryName;
    Context context;
    private LayoutInflater inflater;





    public CustomAdapter(String[] countryName, Context context) {
        this.countryName = countryName;
        this.context = context;
    }

    @Override
    public int getCount() {
        return countryName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null)
        {
            inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.country_view,parent,false);


        }

        TextView textview = (TextView) convertView.findViewById(R.id.textview);



        textview.setText(countryName[position]);

        return convertView;
    }
}