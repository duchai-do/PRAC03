package com.example.prac03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryDetailActivity extends AppCompatActivity {

    ImageView flag;
    TextView name, capital, population, area, density, worldShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        flag = findViewById(R.id.detail_flag);
        name = findViewById(R.id.detail_name);
        capital = findViewById(R.id.detail_capital);
        population = findViewById(R.id.detail_population);
        area = findViewById(R.id.detail_area);
        density = findViewById(R.id.detail_density);
        worldShare = findViewById(R.id.detail_world_share);

        Country country = (Country) getIntent().getSerializableExtra("country");

        flag.setImageResource(country.getFlag());
        name.setText(country.getName());
        capital.setText("Capital: " + country.getCapital());
        population.setText("Population: " + country.getPopulation());
        area.setText("Area: " + country.getArea());
        density.setText(country.getDensity());
        worldShare.setText(country.getWorldShare());
    }
}
