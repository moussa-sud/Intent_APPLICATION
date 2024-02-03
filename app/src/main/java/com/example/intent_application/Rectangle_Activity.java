package com.example.intent_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Rectangle_Activity extends AppCompatActivity {

    Button button ;
    EditText width ;
    EditText height ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        button = findViewById(R.id.button_rectangle);

        height = findViewById(R.id.editTextText);

        width = findViewById(R.id.editTextText2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    int x = Integer.parseInt(height.getText().toString());
                    int y = Integer.parseInt(width.getText().toString());

                    int area = x*y ;

                    Intent i = new Intent();

                    if(area  >=  0 ){

                        // "putExtra" It allows you to pass data from one activity to another

                        i.putExtra("rectangle_area", area);

                        setResult(1,i);

                        finish();


                    }else {


                        i.putExtra("rec_height", x);
                        i.putExtra("rec_width", y);
                        setResult(2,i);

                        finish();


                    }



            }
        });
    }
}