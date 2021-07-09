package com.example.androidconcept.BaseAdapter.DataModelList;

public class ListModel {
    int image;
    String countryName;

    public ListModel(int image, String countryName) {
        this.image = image;
        this.countryName = countryName;
    }

    public int getImage() {
        return image;
    }

    public String getCountryName() {
        return countryName;
    }
}
