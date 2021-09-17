package com.example.androidconcept.AccessFromAssests;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.androidconcept.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AssestAccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assest_access);
        accessAssest();
    }
    public String loadJsonFromAssest()
    {
        String json = null;
        try {
            InputStream is = getAssets().open("CurrencyList.JSON");
            int size = is.available();
            byte[] bytes = new byte[size];
            is.read(bytes);
            is.close();
            json = new String(bytes,"UTF-8");

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return json;
    }
    List<CountryModel> countryModels  = new ArrayList<>();
    public void accessAssest()
    {
        loadJsonFromAssest();
        try {
            JSONArray array = new JSONArray(loadJsonFromAssest());
            for (int i=0;i<array.length();i++)
            {
                JSONObject object = array.getJSONObject(i).getJSONObject("currency");
                countryModels.add(new CountryModel(object.getString("code"),
                        object.getString("name"),
                        object.getString("symbol")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}