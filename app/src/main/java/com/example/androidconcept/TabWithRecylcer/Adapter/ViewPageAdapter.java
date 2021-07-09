package com.example.androidconcept.TabWithRecylcer.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.androidconcept.TabWithRecylcer.Fragment.name_art_fragment;

public class ViewPageAdapter extends FragmentPagerAdapter {

    public ViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new name_art_fragment();
                return fragment;
            case 1:
                fragment = new name_art_fragment();
                return fragment;
            case 2:
                fragment = new name_art_fragment();
                return fragment;
           case 3:
                fragment = new name_art_fragment();
                return fragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
