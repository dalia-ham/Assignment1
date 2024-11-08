package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFood extends AppCompatActivity {
    RadioButton radioMale;
    RadioButton radioFemale;
    Spinner TypeSport;

    Button showSuggestionsButton;
    ListView suggestionsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_food);

        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        TypeSport = findViewById(R.id.TypeSport);
        showSuggestionsButton = findViewById(R.id.showSuggestionsButton);
        suggestionsListView = findViewById(R.id.suggestionsListView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sport_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TypeSport.setAdapter(adapter);

        showSuggestionsButton.setOnClickListener(v -> showSportSuggestions());
    }

    private void showSportSuggestions() {
        String selectedGender = radioMale.isChecked() ? "Male" : "Female";
        String selectedSportType = TypeSport.getSelectedItem().toString();

        List<Sports> filteredSports = getFilteredSports(selectedGender, selectedSportType);

        List<String> sportNames = new ArrayList<>();
        for (Sports sport : filteredSports) {
            sportNames.add(sport.getSportName() + " - Days: " + String.join(", ", sport.getDays()));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sportNames);
        suggestionsListView.setAdapter(adapter);

        suggestionsListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSport = sportNames.get(position);

            Intent intent = new Intent(HomeFood.this, NextScreenList.class);
            intent.putExtra("selectedSport", selectedSport); // Send the selected sport name
            startActivity(intent);
        });
    }


    private List<Sports> getFilteredSports(String gender, String sportType) {
        List<Sports> allSports = new ArrayList<>();

        if (sportType.equals("Individual")) {
            if (gender.equals("Male") || gender.equals("Female")) {
                allSports.add(new Sports("Tennis", 60, gender, Arrays.asList("Tuesday", "Thursday")));
                allSports.add(new Sports("Athletics", 60, gender, Arrays.asList("Monday", "Saturday")));
            }

            if (gender.equals("Male") || gender.equals("Female")) {
                allSports.add(new Sports("Swimming", 60, gender, Arrays.asList("Monday", "Wednesday", "Friday")));
            }
        } else if (sportType.equals("Team")) {
            if (gender.equals("Male")) {
                allSports.add(new Sports("Football", 90, gender, Arrays.asList("Monday", "Wednesday", "Friday")));
            }
            if (gender.equals("Male") || gender.equals("Female")) {
                allSports.add(new Sports("Volleyball", 90, gender, Arrays.asList("Monday", "Thursday")));
            }
        }

        if (gender.equals("Female")) {
            allSports.add(new Sports("Yoga", 45, gender, Arrays.asList("Sunday", "Tuesday", "Friday")));
            allSports.add(new Sports("Ballet", 60, gender, Arrays.asList("Monday", "Wednesday")));
            allSports.add(new Sports("Zumba", 45, gender, Arrays.asList("Tuesday", "Thursday")));
            allSports.add(new Sports("Gymnastics", 60, gender, Arrays.asList("Sunday", "Tuesday")));
        }

        return allSports;
    }

}
