package com.example.androidconcept.RecycleView_concept.RecycleAdapter;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidconcept.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    List<String> cstData;
    Context context;
    public CustomAdapter(Context context, List<String> name)
    {
        this.context = context;
        cstData = name;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(cstData.get(position));
    }

    @Override
    public int getItemCount() {
        return cstData.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name  = itemView.findViewById(R.id.txt_name);
        }
    }
}
