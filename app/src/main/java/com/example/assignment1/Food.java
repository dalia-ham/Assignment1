package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Food extends AppCompatActivity {

    CheckBox checkboxKids, checkboxTeens, checkboxAdults, checkboxElderly;
    TextView foodSuggestionsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        checkboxKids = findViewById(R.id.checkboxKids);
        checkboxTeens = findViewById(R.id.checkboxTeens);
        checkboxAdults = findViewById(R.id.checkboxAdults);
        checkboxElderly = findViewById(R.id.checkboxElderly);
        foodSuggestionsTextView = findViewById(R.id.foodSuggestionsTextView);

        checkboxKids.setOnClickListener(v -> updateFoodSuggestions());
        checkboxTeens.setOnClickListener(v -> updateFoodSuggestions());
        checkboxAdults.setOnClickListener(v -> updateFoodSuggestions());
        checkboxElderly.setOnClickListener(v -> updateFoodSuggestions());
    }

    private void updateFoodSuggestions() {
        StringBuilder foodSuggestions = new StringBuilder();

        if (checkboxKids.isChecked()) {
            foodSuggestions.append("For Kids (3-12 years): Milk, Fruits, Vegetables, Whole Grains.\n");
        }
        if (checkboxTeens.isChecked()) {
            foodSuggestions.append("For Teens (13-19 years): Protein-rich foods, Carbs, Fruits, Dairy.\n");
        }
        if (checkboxAdults.isChecked()) {
            foodSuggestions.append("For Adults (20-40 years): Lean proteins, Vegetables, Fruits, Healthy fats.\n");
        }
        if (checkboxElderly.isChecked()) {
            foodSuggestions.append("For Elderly (40+ years): Calcium-rich foods, Lean proteins, Fiber-rich foods.\n");
        }

        if (foodSuggestions.length() == 0) {
            foodSuggestionsTextView.setText("No category selected. Please select an age group.");
        } else {
            foodSuggestionsTextView.setText(foodSuggestions.toString());
        }
    }
}
