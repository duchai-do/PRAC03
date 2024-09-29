package com.example.prac03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends BaseAdapter {

    Context context;
    ArrayList<Country> countryList;

    public CountryAdapter(Context context, ArrayList<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_country, parent, false);
        }

        Country currentCountry = (Country) getItem(position);

        ImageView flag = convertView.findViewById(R.id.country_flag);
        TextView name = convertView.findViewById(R.id.country_name);
        TextView capital = convertView.findViewById(R.id.country_capital);

        flag.setImageResource(currentCountry.getFlag());
        name.setText(currentCountry.getName());
        capital.setText(currentCountry.getCapital());

        return convertView;
    }
}
