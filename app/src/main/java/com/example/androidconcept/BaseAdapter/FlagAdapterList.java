package com.example.androidconcept.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidconcept.BaseAdapter.DataModelList.ListModel;
import com.example.androidconcept.R;

import java.util.List;

public class FlagAdapterList extends BaseAdapter {

    List<ListModel> countryData;
    Context context;
    LayoutInflater inflater;
    FlagAdapterList(Context context, List<ListModel> countryData)
    {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.countryData = countryData;
    }
    @Override
    public int getCount() {
        return countryData.size();
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
        View v = inflater.inflate(R.layout.cust_list_layout,parent,false);

        ImageView flag = v.findViewById(R.id.ic_flag);
        TextView countryName = v.findViewById(R.id.txt_country);

        flag.setImageResource(countryData.get(position).getImage());
        countryName.setText(countryData.get(position).getCountryName());

        return v;
    }
}
