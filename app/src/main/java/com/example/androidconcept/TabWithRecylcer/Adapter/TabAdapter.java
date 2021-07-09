package com.example.androidconcept.TabWithRecylcer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidconcept.R;

import java.util.List;

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.customHolder> {

    Context context;
    List<String> title;
    LayoutInflater inflater;
    View v;
    public TabAdapter(List<String> data, Context context)
    {
        this.context = context;
        inflater = LayoutInflater.from(this.context);
        title = data;
    }

    @NonNull
    @Override
    public customHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          v = inflater.inflate(R.layout.tab_adapter_layout,parent,false);

        return new customHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull customHolder holder, int position) {

        holder.txt_title.setText(title.get(position));
    }

    @Override
    public int getItemCount() {
        return title.size();
    }
    public class customHolder extends RecyclerView.ViewHolder
    {
        TextView txt_title;

        public customHolder(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
        }
    }

}
