package com.nathan.hydrationapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class WaterViewPagerAdapter extends FragmentPagerAdapter {

    ///returns a fragment
    private String[] days;

    public WaterViewPagerAdapter(FragmentManager fm, String[] days){
        super(fm);
        this.days = days;
    }

    @Override
    public Fragment getItem(int position) {
        return WaterFragment.newInstance(days[position]);
    }

    @Override
    public int getCount() {
        return days.length;
    }
}
