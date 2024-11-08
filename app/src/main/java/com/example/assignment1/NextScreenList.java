package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextScreenList extends AppCompatActivity {

    TextView suggestionsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextscreenlist);

        suggestionsTextView = findViewById(R.id.suggestionsTextView);

        Intent intent = getIntent();
        String selectedSport = intent.getStringExtra("selectedSport");

        suggestionsTextView.setText("You selected: \n" + selectedSport);
    }
}
