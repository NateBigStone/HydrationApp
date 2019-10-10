package com.nathan.hydrationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MAIN_ACTIVITY";

    private WaterViewModel waterViewModel;

    private static final String[] DAYS = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "FriYAY!",
            "Saturday",
            "Sunday"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create View model, associate with this Activity
        // The fragment will also be able to access it
        waterViewModel = new WaterViewModel(getApplication());

        //debuging
        waterViewModel.getAllRecords().observe(this, new Observer<List<WaterRecord>>() {

            @Override
            public void onChanged(List<WaterRecord> waterRecords) {
                Log.d(TAG, "Water records are: " + waterRecords);
            }
        });

        // iterate of array of days and creates a new water record
        for (String day: DAYS) {
            WaterRecord record = new WaterRecord(day, 0);
            Log.d(TAG, "Inserting" + record);
            waterViewModel.insert(record);
        }

        //The viewpager swipe feature
        ViewPager viewPager = findViewById(R.id.water_view_pager);
        WaterViewPagerAdapter waterViewPagerAdapter = new WaterViewPagerAdapter(getSupportFragmentManager(), DAYS);
        viewPager.setAdapter(waterViewPagerAdapter);
    }
}
