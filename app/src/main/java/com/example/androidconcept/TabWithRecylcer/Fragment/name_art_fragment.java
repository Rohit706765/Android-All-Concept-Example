package com.example.androidconcept.TabWithRecylcer.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidconcept.R;
import com.example.androidconcept.TabWithRecylcer.Adapter.contentAdapter;

import java.util.ArrayList;
import java.util.List;


public class name_art_fragment extends Fragment {

    contentAdapter contentAdapter;
    List<Integer> sub_img_list = new ArrayList<>();
    RecyclerView contentRecycler;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.name_art_layout,container,false);


        sub_img_list.add(R.drawable.bg_image);
        sub_img_list.add(R.drawable.bg_image);
        sub_img_list.add(R.drawable.bg_image);
        sub_img_list.add(R.drawable.bg_image);
        sub_img_list.add(R.drawable.bg_image);
        sub_img_list.add(R.drawable.bg_image);

        contentRecycler = v.findViewById(R.id.contentRecycler);
        contentAdapter = new contentAdapter(getContext(),sub_img_list);
        LinearLayoutManager verticalManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        contentRecycler.setLayoutManager(verticalManager);
        contentRecycler.setAdapter(contentAdapter);

        return v;
    }
}
