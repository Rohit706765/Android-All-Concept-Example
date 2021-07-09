package com.example.androidconcept.Spinner.SpinnerModel;

import android.widget.TextView;

import org.w3c.dom.Text;

public class SpinnerModel {
    int image;
    String countryName;

    public SpinnerModel(int image, String countryName) {
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
