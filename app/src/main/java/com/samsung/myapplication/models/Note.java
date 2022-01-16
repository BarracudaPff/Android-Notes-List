package com.samsung.myapplication.models;

import java.util.Date;

public class Note {
    public String title;
    private String description; // nullable
    public Date timeCreated;
    public boolean isChecked;

    public Note(String title, String description, Date timeCreated, boolean isChecked) {
        this.title = title;
        this.description = description;
        this.timeCreated = timeCreated;
        this.isChecked = isChecked;
    }

    public Note(String title, Date timeCreated, boolean isChecked) {
        this.title = title;
        this.timeCreated = timeCreated;
        this.description = null;
        this.isChecked = isChecked;
    }

    public String getDescription() {
        if (description == null) {
            return "";
        } else {
            return description;
        }
    }

    public String getCreatedTime() {
        int h = timeCreated.getHours();
        int m = timeCreated.getMinutes();

        return h + ":" + m;
    }
}
