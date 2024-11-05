package com.masruf.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editWeight, editFeet, editInch;
    Button buttonCalculateBMI;
    TextView tvBMIResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        editWeight = findViewById(R.id.editWeight);
        editFeet = findViewById(R.id.editFeet);
        editInch = findViewById(R.id.editInch);
        buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);
        tvBMIResult = findViewById(R.id.tvBMIResult);

        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                float weight = Float.parseFloat(editWeight.getText().toString());
//                float feet = Float.parseFloat(editFeet.getText().toString());
//                float inch = Float.parseFloat(editInch.getText().toString());
//
//                if (editInch.length()>2 || inch>11){
//                    editInch.setError("Invalid input");
//                }
//
//                float height = (float) (feet * 0.3048 + inch * 0.0254);
//                float bmi = weight / (height * height);
//
//                tvBMIResult.setText("Your BMI is: " + bmi);

                if(editWeight.length()>0 && editFeet.length()>0 && editInch.length()>0){

                    float weight = Float.parseFloat(editWeight.getText().toString());
                    float feet = Float.parseFloat(editFeet.getText().toString());
                    float inch = Float.parseFloat(editInch.getText().toString());
                    
                    if (editInch.length()>2 || inch>11){
                        editInch.setError("Invalid input");
                    }

                    float height = (float) (feet * 0.3048 + inch * 0.0254);
                    float bmi = weight / (height * height);

                    tvBMIResult.setText("Your BMI is: " + bmi);

                    if (bmi < 18.5) {
                        Toast.makeText(MainActivity.this, "You are Under weight", Toast.LENGTH_LONG).show();
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        Toast.makeText(MainActivity.this, "You are Normal weight", Toast.LENGTH_LONG).show();
                    } else if (bmi >= 25 && bmi <= 29.9) {
                        Toast.makeText(MainActivity.this, "You are Overweight", Toast.LENGTH_LONG).show();
                    } else if (bmi >= 30 && bmi <= 34.9) {
                        Toast.makeText(MainActivity.this, "You are Obese", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "You are Extremely Obese", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Please fill all the filds", Toast.LENGTH_LONG).show();
                }



            }

        });


    }

}
