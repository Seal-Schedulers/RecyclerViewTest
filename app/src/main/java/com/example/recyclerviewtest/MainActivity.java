package com.example.recyclerviewtest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView cities;
    private RecyclerView.Adapter adapter;
    ArrayList<City> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.cities = (RecyclerView) findViewById(R.id.cities);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.cities.setLayoutManager(mLayoutManager);

        adapter = new CityAdapter(list);
        this.cities.setAdapter(adapter);
    }

    private ArrayList<City> initCities() {
        list.add(new City("Cinque Terre", "The coastline, the five villages in Italy."));
        list.add(new City("Paris", "Paris is the capital city of France"));
        list.add(new City("Rio de Janeiro", "Rio has been one of Brazil's most popular destinations."));
        list.add(new City("Sydney", "Sydney is the state capital of New South Wales."));

        return list;
    }
    public void createMoreCities(View v) {
        list.add(new City("Worcester", "Quite a boring city compared to the rest of these."));
        adapter.notifyDataSetChanged();
    }
}