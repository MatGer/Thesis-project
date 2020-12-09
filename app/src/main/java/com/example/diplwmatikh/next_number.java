package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class next_number extends universal {
    TextView no1,no2,no3,no4,no5,no6;
    int row1,row2,row3,score=0;
    Button check;
    ImageButton back;
    TextView prevscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_number);

        runtime();

        TextView title = findViewById(R.id.title);
        title.setText("Επέλεξε τον αριθμό που ακολουθεί.");
        title.setSelected(true);

        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);
        prevscore=findViewById(R.id.score);
        get_score_for_navbar("next number", userID, prevscore, 3);

        no1=findViewById(R.id.no15);
        no2=findViewById(R.id.no16);
        no3=findViewById(R.id.no25);
        no4=findViewById(R.id.no26);
        no5=findViewById(R.id.no35);
        no6=findViewById(R.id.no36);
        check=findViewById(R.id.check);

        no1.setOnClickListener(selectlistener);
        no2.setOnClickListener(selectlistener);
        no3.setOnClickListener(selectlistener);
        no4.setOnClickListener(selectlistener);
        no5.setOnClickListener(selectlistener);
        no6.setOnClickListener(selectlistener);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(row1==0){
                    score++;
                }
                if(row2==1){
                    score++;
                }
                if(row3==1){
                    score++;
                }
                upload_score("next number",score);
                show_rating(score,3,next_number.class,how_many.class,true);
            }
        });
    }
    View.OnClickListener selectlistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.no15:
                    no1.setBackground(getDrawable(R.color.background_color));
                    no2.setBackground(getDrawable(R.color.light_grey));
                    row1=0;
                    break;
                case R.id.no16:
                    no2.setBackground(getDrawable(R.color.background_color));
                    no1.setBackground(getDrawable(R.color.light_grey));
                    row1=1;
                    break;
                case R.id.no25:
                    no3.setBackground(getDrawable(R.color.background_color));
                    no4.setBackground(getDrawable(R.color.light_grey));
                    row2=0;
                    break;
                case R.id.no26:
                    no4.setBackground(getDrawable(R.color.background_color));
                    no3.setBackground(getDrawable(R.color.light_grey));
                    row2=1;
                    break;
                case R.id.no35:
                    no5.setBackground(getDrawable(R.color.background_color));
                    no6.setBackground(getDrawable(R.color.light_grey));
                    row3=0;
                    break;
                case R.id.no36:
                    no6.setBackground(getDrawable(R.color.background_color));
                    no5.setBackground(getDrawable(R.color.light_grey));
                    row3=1;
                    break;
            }
        }
    };
}