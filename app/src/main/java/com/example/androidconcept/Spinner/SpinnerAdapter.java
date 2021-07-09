package com.example.androidconcept.Spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidconcept.R;
import com.example.androidconcept.Spinner.SpinnerModel.SpinnerModel;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

    Context context;
    List<SpinnerModel> spinData;
    LayoutInflater inflater;
    SpinnerAdapter(Context context,List<SpinnerModel> spinData)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.spinData = spinData;
    }
    @Override
    public int getCount() {
        return spinData.size();
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
        View view = inflater.inflate(R.layout.cust_spinner_layout,parent,false);

        TextView txt_country = view.findViewById(R.id.txt_spinn);
        ImageView img_country = view.findViewById(R.id.img_spinn);

        txt_country.setText(spinData.get(position).getCountryName());
        img_country.setImageResource(spinData.get(position).getImage());

        return view;
    }
}
