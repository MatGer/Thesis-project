package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class add_animals extends universal {
    Button check,check_this;
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
        check.setVisibility(View.INVISIBLE);
        check_this=findViewById(R.id.check_this);

        TextView title = findViewById(R.id.title);
        title.setText("Κάνε τις προσθέσεις.");
        title.setSelected(true);

        check_this.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num1.getText().toString().trim().length()!=0){
                    String a=num1.getText().toString();
                    if(Integer.parseInt(a)==7){
                        score++;
                    }
                }
                if(num2.getText().toString().trim().length()!=0){
                    String b=num2.getText().toString();
                    if(Integer.parseInt(b)==10){
                        score++;
                    }
                }
                if(num3.getText().toString().trim().length()!=0){
                    String c=num3.getText().toString();
                    if(Integer.parseInt(c)==5){
                        score++;
                    }
                }
                if(num4.getText().toString().trim().length()!=0){
                    String d=num4.getText().toString();
                    if(Integer.parseInt(d)==4){
                        score++;
                    }
                }
                upload_score("add animals", score);
                create_builder_finished_with_score(score);
            }
        });
    }
}