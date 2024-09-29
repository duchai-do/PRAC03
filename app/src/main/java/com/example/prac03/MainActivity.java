package com.example.prac03;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Country> countryList;
    CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.country_list);
        countryList = new ArrayList<>();

        // Thêm các quốc gia vào danh sách
        countryList.add(new Country("India", "New Delhi", R.drawable.india, "1.428 billion", "2,973,190 km²", "Density: 428 per/km²", "World Share: 17.7%"));
        countryList.add(new Country("China", "Beijing", R.drawable.china, "1.412 billion", "9,596,961 km²", "Density: 153 per/km²", "World Share: 18.47%"));
        countryList.add(new Country("United States", "Washington DC", R.drawable.usa, "333 million", "9,833,520 km²", "Density: 36 per/km²", "World Share: 4.25%"));
        

        countryAdapter = new CountryAdapter(this, countryList);
        listView.setAdapter(countryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Khi nhấn vào một quốc gia, mở màn hình chi tiết
                Intent intent = new Intent(MainActivity.this, CountryDetailActivity.class);
                intent.putExtra("country", countryList.get(position));
                startActivity(intent);
            }
        });
    }
}
