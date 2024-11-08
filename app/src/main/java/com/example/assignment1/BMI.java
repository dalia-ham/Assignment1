package com.example.assignment1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BMI extends AppCompatActivity {
    EditText edtHeight;
    EditText edtWeight;
    Button btnBmiRes;
    TextView txtResBMI;
    TextView txtBMIStatus;
    Button btn2;
    TextView txtRule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        btnBmiRes = findViewById(R.id.btnBmiRes);
        txtResBMI = findViewById(R.id.txtResBMI);
        txtBMIStatus = findViewById(R.id.txtBMIStatus);
        btn2 = findViewById(R.id.btn2);
        txtRule = findViewById(R.id.txtRule);

        btnBmiRes.setOnClickListener(view -> {
            String heightStr = edtHeight.getText().toString();
            String weightStr = edtWeight.getText().toString();

            if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
                try {
                    float height = Float.parseFloat(heightStr) / 100;
                    float weight = Float.parseFloat(weightStr);

                    float bmi = weight / (height * height);

                    txtResBMI.setText(String.format("BMI: %.2f", bmi));

                    String status = getBMIStatus(bmi);
                    txtBMIStatus.setText("Status: " + status);

                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Please enter valid values", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter valid values", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(view -> {
            txtRule.setText(" BMI=weight(inkilograms)/height(meteres)*2 " +

                    "\n BMI Categories:\n" +
                    "Underweight: Less than 18.5\n" +
                    "Normal weight: 18.5 - 24.9\n" +
                    "Overweight: 25 - 29.9\n" +
                    "Obesity: 30 or more");

        });
    }

    private String getBMIStatus(float bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

}
