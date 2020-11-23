package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class write_height extends universal {
    EditText no1,no2,no3,no4,no5;
    Button check;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_height);

        runtime();

        no1=findViewById(R.id.type1);
        no2=findViewById(R.id.type2);
        no3=findViewById(R.id.type3);
        no4=findViewById(R.id.type4);
        no5=findViewById(R.id.type5);
        check=findViewById(R.id.check);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(no1.getText().toString())==4){
                    score++;
                }
                if(Integer.parseInt(no2.getText().toString())==8){
                    score++;
                }
                if(Integer.parseInt(no3.getText().toString())==3){
                    score++;
                }
                if(Integer.parseInt(no4.getText().toString())==3){
                    score++;
                }
                if(Integer.parseInt(no5.getText().toString())==2){
                    score++;
                }

                upload_score("write height", score);
                create_builder_finished_with_score(score);
            }
        });
    }
}