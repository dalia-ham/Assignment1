package com.example.assignment1;

import java.util.List;

public class Sports {
    private String sportName;
    private int time;
    private String gender;
    private List<String> days;

    public Sports(String sportName, int time, String gender, List<String> days) {
        this.sportName = sportName;
        this.time = time;
        this.gender = gender;
        this.days = days;
    }

    public String getSportName() {
        return sportName;
    }

    public int getTime() {
        return time;
    }

    public String getGender() {
        return gender;
    }

    public List<String> getDays() {
        return days;
    }
}
