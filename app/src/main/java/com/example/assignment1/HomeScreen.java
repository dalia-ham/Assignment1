package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {
    Button btn1screen;
    Button btn2screen;
    Button btn3screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

       btn1screen = findViewById(R.id.btn1screen);
       btn2screen = findViewById(R.id.btn2screen);
       btn3screen = findViewById(R.id.btn3screen);

        btn1screen.setOnClickListener(v -> {
            Intent intent = new Intent(HomeScreen.this, BMI.class);
            startActivity(intent);

    });
        btn2screen.setOnClickListener(v->{
            Intent intent2 = new Intent(HomeScreen.this, HomeFood.class);
            startActivity(intent2);

        });
        btn3screen.setOnClickListener(v->{
            Intent intent3 = new Intent(HomeScreen.this, Food.class);
            startActivity(intent3);

        });


    }
}