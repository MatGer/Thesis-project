package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class add_animals extends universal {
    Button check;
    EditText num1,num2,num3,num4;
    int score=0;
    // activity name: add animals
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
        TextView title =findViewById(R.id.title);

        title.setText("Κάνε τις προσθέσεις");
        //title.setMovementMethod(new ScrollingMovementMethod());

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=num1.getText().toString();
                if(a.isEmpty()){
                    //do nothing
                }else{
                    if(Integer.parseInt(a)==7){
                        score++;
                    }
                }
                String b=num2.getText().toString();
                if(b.isEmpty()){
                    //do nothing
                }else{
                    if(Integer.parseInt(b)==10){
                        score++;
                    }
                }String c=num3.getText().toString();
                if(c.isEmpty()){
                    //do nothing
                }else{
                    if(Integer.parseInt(c)==5){
                        score++;
                    }
                }String d=num4.getText().toString();
                if(d.isEmpty()){
                    //do nothing
                }else{
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