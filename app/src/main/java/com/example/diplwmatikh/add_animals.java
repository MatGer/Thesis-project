package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_animals extends universal {
    Button check;
    EditText num1,num2,num3,num4;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animals);

        runtime();

        num1=findViewById(R.id.type1);
        num2=findViewById(R.id.type2);
        num3=findViewById(R.id.type3);
        num4=findViewById(R.id.type4);
        check=findViewById(R.id.check);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(num1.getText().toString())==7){
                    score++;
                }
                if (Integer.parseInt(num2.getText().toString())==10){
                    score++;
                }
                if(Integer.parseInt(num3.getText().toString())==5){
                    score++;
                }
                if(Integer.parseInt(num4.getText().toString())==4){
                    score++;
                }
                upload_score("add animals", score);
                create_builder_finished_with_score(score);
            }
        });
    }
}