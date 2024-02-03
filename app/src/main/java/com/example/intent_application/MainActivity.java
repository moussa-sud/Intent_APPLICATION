package com.example.intent_application;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    Button rectangle_bt ;
    TextView resultt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rectangle_bt = findViewById(R.id.rectangle);

        resultt = findViewById(R.id.resultee);


        // 1- after initializing two variables we make a setOnClickListener


        rectangle_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // In summary, whether to use new Intent(); or new Intent(Context, Class);
                // depends on the specific use case and where the intent is being created.
                // If you are creating an intent within the same context, the former might be sufficient.
                // However, if you need to specify a different context or start a component
                // from a different context, you would use the latter.

                Intent i = new Intent( getBaseContext() ,  Rectangle_Activity.class);


                //This is particularly useful when you need to get information or
                // data from the second activity.

                startActivityForResult(i , 2 );
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if(requestCode == 2 ){


            if(resultCode == 1){


                int area = data.getIntExtra("rectangle_area", 0);

                resultt = findViewById(R.id.resultee);

                resultt.setText(String.valueOf(area));


            } else if ( resultCode == 2 ){

                // " getIntExtra " This retrieves the integer extra associated with the key
                // "rectangle_area" from the Intent and provides
                // a default value of 0 if the key is not found.

                int height = data.getIntExtra("rec_height", 0);
                int width = data.getIntExtra("rec_width", 0);

                resultt = findViewById(R.id.resultee);

                resultt.setText(String.valueOf( +height +" and "+ width + " Incorrect"));

            }


        }

    }
}