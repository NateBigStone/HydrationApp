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
            "Friday",
            "Saturday",
            "Sunday"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create View model , associate with this Activity
        // The fragment will also be able to access it
        waterViewModel = new WaterViewModel(getApplication());

//        WaterRecord example = new WaterRecord("Monday", 2);
//        waterViewModel.insert(example);

        //debuging
        waterViewModel.getAllRecords().observe(this, new Observer<List<WaterRecord>>() {

            @Override
            public void onChanged(List<WaterRecord> waterRecords) {
                Log.d(TAG, "Water records are: " + waterRecords);
            }
        });

        for (String day: DAYS) {
            WaterRecord record = new WaterRecord(day, 0);
            Log.d(TAG, "Inserting" + record);
            waterViewModel.insert(record);
        }

//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        WaterFragment waterFragment = WaterFragment.newInstance("Monday");
//
//        ft.add(R.id.content, waterFragment);
//        ft.commit();

        ViewPager viewPager = findViewById(R.id.water_view_pager);
        WaterViewPagerAdapter waterViewPagerAdapter = new WaterViewPagerAdapter(getSupportFragmentManager(), DAYS);
        viewPager.setAdapter(waterViewPagerAdapter);
    }
}
