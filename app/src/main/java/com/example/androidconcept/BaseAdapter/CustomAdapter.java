package com.example.androidconcept.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.androidconcept.R;

import java.util.List;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    int[] image;
    CustomAdapter(Context context, int[] img)
    {
        inflater =LayoutInflater.from(context);
        this.context = context;
        this.image  = img;
    }
    @Override
    public int getCount() {
        return image.length;
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

        View v  = inflater.inflate(R.layout.cust_grid_animal_layout,parent,false);
        ImageView icon = v.findViewById(R.id.icon_animal);
        icon.setImageResource(image[position]);

        return v;
    }
}
