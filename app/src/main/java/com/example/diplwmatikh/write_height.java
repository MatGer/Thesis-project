package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class write_height extends universal {
    EditText no1,no2,no3,no4,no5;
    Button check;
    int score=0;
    ImageButton back;
    TextView prevscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_height);

        runtime();

        TextView title = findViewById(R.id.title);
        title.setText("Γράψε το ύψος του κάθε αντικειμένου.");
        title.setSelected(true);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);
        prevscore=findViewById(R.id.score);
        get_score_for_navbar("write height", userID, prevscore, 5);

        no1=findViewById(R.id.type1);
        no2=findViewById(R.id.type2);
        no3=findViewById(R.id.type3);
        no4=findViewById(R.id.type4);
        no5=findViewById(R.id.type5);
        check=findViewById(R.id.check);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);   //keyboard stay hidden
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(no1.getText().toString().trim().length()!=0){
                    String a=no1.getText().toString();
                    if(Integer.parseInt(a)==6){
                        score++;
                    }
                }
                if(no2.getText().toString().trim().length()!=0){
                    String b=no2.getText().toString();
                    if(Integer.parseInt(b)==3){
                        score++;
                    }
                }
                if(no3.getText().toString().trim().length()!=0){
                    String c=no3.getText().toString();
                    if(Integer.parseInt(c)==4){
                        score++;
                    }
                }
                if(no4.getText().toString().trim().length()!=0){
                    String d=no4.getText().toString();
                    if(Integer.parseInt(d)==5){
                        score++;
                    }
                }
                if(no5.getText().toString().trim().length()!=0){
                    String e=no5.getText().toString();
                    if(Integer.parseInt(e)==2){
                        score++;
                    }
                }

                upload_score("write height", score);
                show_rating(score,5,write_height.class,choose_the_bigger_number.class,true);
            }
        });
    }
}