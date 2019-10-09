package com.nathan.hydrationapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WaterRecord {

    @PrimaryKey
    @NonNull

    private String day;
    private int glasses;

    public WaterRecord(@NonNull String day, int glasses) {
        this.day = day;
        this.glasses = glasses;
    }

    @NonNull
    public String getDay() {
        return day;
    }

    public int getGlasses() {
        return glasses;
    }

    @Override
    public String toString() {
        return "WaterRecord{" +
                "day='" + day + '\'' +
                ", glasses=" + glasses +
                '}';
    }
}
