package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class how_many extends universal {
    View no1,no2,no3,no4,no5,no6,no7,no8,no9;
    Button check;
    int row1=-1;
    int row2=-1;
    int row3=-1;
    int score;
    ImageButton back,home;
    TextView prevscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_many);
        runtime();

        TextView title = findViewById(R.id.title);
        title.setText("Επίλεξε πόσα ζωάκια φαίνονται σε κάθε φωτογραφία");
        title.setSelected(true);

        check=findViewById(R.id.check);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button_from_activity);
        home=findViewById(R.id.homebutton);
        home.setOnClickListener(home_button_listener);
        prevscore=findViewById(R.id.score);
        get_score_for_navbar("how many", prevscore, 3);
        no1=findViewById(R.id.no11);
        no2=findViewById(R.id.no12);
        no3=findViewById(R.id.no13);
        no4=findViewById(R.id.no21);
        no5=findViewById(R.id.no22);
        no6=findViewById(R.id.no23);
        no7=findViewById(R.id.no31);
        no8=findViewById(R.id.no32);
        no9=findViewById(R.id.no33);

        no1.setOnClickListener(selectclick);
        no2.setOnClickListener(selectclick);
        no3.setOnClickListener(selectclick);
        no4.setOnClickListener(selectclick);
        no5.setOnClickListener(selectclick);
        no6.setOnClickListener(selectclick);
        no7.setOnClickListener(selectclick);
        no8.setOnClickListener(selectclick);
        no9.setOnClickListener(selectclick);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(row1==0){
                    score++;
                }
                if(row2==1){
                    score++;
                }
                if (row3==1){
                    score++;
                }
                upload_score("how many", score,3);
                show_rating(score,3,how_many.class,null,false);
            }
        });
    }

    View.OnClickListener selectclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            v.setBackground(getDrawable(R.color.background));
            switch (v.getId()){
                case R.id.no11:
                    no1.setBackground(getDrawable(R.color.white));
                    no2.setBackground(getDrawable(R.color.white));
                    no3.setBackground(getDrawable(R.color.white));
                    v.setBackground(getDrawable(R.color.background));
                    row1=0;
                    break;
                case R.id.no12:
                    no1.setBackground(getDrawable(R.color.white));
                    no2.setBackground(getDrawable(R.color.white));
                    no3.setBackground(getDrawable(R.color.white));
                    v.setBackground(getDrawable(R.color.background));
                    row1=1;
                    break;
                case R.id.no13:
                    no1.setBackground(getDrawable(R.color.white));
                    no2.setBackground(getDrawable(R.color.white));
                    no3.setBackground(getDrawable(R.color.white));
                    v.setBackground(getDrawable(R.color.background));
                    row1=2;
                    break;
                case R.id.no21:
                    no4.setBackground(getDrawable(R.color.white));
                    no5.setBackground(getDrawable(R.color.white));
                    no6.setBackground(getDrawable(R.color.white));
                    v.setBackground(getDrawable(R.color.background));
                    row2=0;
                    break;
                case R.id.no22:
                    no4.setBackground(getDrawable(R.color.white));
                    no5.setBackground(getDrawable(R.color.white));
                    no6.setBackground(getDrawable(R.color.white));
                    v.setBackground(getDrawable(R.color.background));
                    row2=1;
                    break;
                case R.id.no23:
                    no4.setBackground(getDrawable(R.color.white));
                    no5.setBackground(getDrawable(R.color.white));
                    no6.setBackground(getDrawable(R.color.white));
                    v.setBackground(getDrawable(R.color.background));
                    row2=2;
                    break;
                case R.id.no31:
                    no7.setBackground(getDrawable(R.color.white));
                    no8.setBackground(getDrawable(R.color.white));
                    no9.setBackground(getDrawable(R.color.white));
                    v.setBackground(getDrawable(R.color.background));
                    row3=0;
                    break;
                case R.id.no32:
                    no7.setBackground(getDrawable(R.color.white));
                    no8.setBackground(getDrawable(R.color.white));
                    no9.setBackground(getDrawable(R.color.white));
                    v.setBackground(getDrawable(R.color.background));
                    row3=1;
                    break;
                case R.id.no33:
                    no7.setBackground(getDrawable(R.color.white));
                    no8.setBackground(getDrawable(R.color.white));
                    no9.setBackground(getDrawable(R.color.white));
                    v.setBackground(getDrawable(R.color.background));
                    row3=2;
                    break;
            }
        }
    };
}