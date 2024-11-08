package com.example.assignment1;

import com.example.assignment1.Sports;

import java.util.List;

public class DetailsSports {
    private String sportType;
    private List<Sports> listSports;

    public DetailsSports(String sportType, List<Sports> listSports) {
        this.sportType = sportType;
        this.listSports = listSports;
    }

    public String getSportType() {
        return sportType;
    }

    public List<Sports> getListSports() {
        return listSports;
    }
}
