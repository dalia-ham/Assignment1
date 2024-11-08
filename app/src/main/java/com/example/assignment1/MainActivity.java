package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail;
    EditText edtpasswrd;
    Button logbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edtEmail);
        edtpasswrd = findViewById(R.id.edtpasswrd);
        logbtn = findViewById(R.id.logbtn);

        logbtn.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String password = edtpasswrd.getText().toString().trim();

            if (isEmailValid(email) && isPasswordValid(password)) {
                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Make sure your email and password are correct", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isEmailValid(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }
}
