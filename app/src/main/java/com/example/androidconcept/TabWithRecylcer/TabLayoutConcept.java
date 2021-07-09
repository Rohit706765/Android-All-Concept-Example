package com.example.androidconcept.TabWithRecylcer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;

import com.example.androidconcept.R;
import com.example.androidconcept.TabWithRecylcer.Adapter.TabAdapter;
import com.example.androidconcept.TabWithRecylcer.Adapter.ViewPageAdapter;
import com.example.androidconcept.TabWithRecylcer.Adapter.contentAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutConcept extends AppCompatActivity {

    List<String> titleList = new ArrayList<>();
    Context  context;
    RecyclerView tabRecycler;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_concept);
        context = this;

        titleList.add("Name Art");
        titleList.add("Text Art");
        titleList.add("Insta Saver");
        titleList.add("Whatsapp Saver");

        viewPager = findViewById(R.id.view_pager);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPageAdapter);
        viewPager.setOffscreenPageLimit(4);

        TabAdapter tabAdapter = new TabAdapter(titleList,context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        tabRecycler = findViewById(R.id.tabRecycler);
        tabRecycler.setLayoutManager(linearLayoutManager);
        tabRecycler.setAdapter(tabAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}