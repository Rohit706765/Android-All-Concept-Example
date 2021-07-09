package com.example.androidconcept.TabWithRecylcer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidconcept.R;

import java.util.List;

public class contentAdapter extends RecyclerView.Adapter<contentAdapter.customHolder> {

    Context context;
    List<Integer> sub_img;
    LayoutInflater inflater;
    View v;

    public contentAdapter(Context context,List<Integer> img)
    {
        this.context = context;
        sub_img = img;
        this.inflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public customHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = inflater.inflate(R.layout.content_adapter_layout,parent,false);

        return new customHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull customHolder holder, int position) {
        holder.img.setImageResource(sub_img.get(position));
    }

    @Override
    public int getItemCount() {
        return sub_img.size();
    }

    public class customHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public customHolder(@NonNull View itemView) {
            super(itemView);

            img  = itemView.findViewById(R.id.img_content);

        }
    }

}
