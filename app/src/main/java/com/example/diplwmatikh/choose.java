package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class choose extends universal{
    Button check;
    ImageView teddy,woman,cake,ice_cream;
    int score=0;
    boolean row1,row2;
    ImageView play1,play2;
    TextView prevscore;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        runtime();

        check=findViewById(R.id.check);
        teddy=findViewById(R.id.teddy);
        woman= findViewById(R.id.woman);
        cake=findViewById(R.id.birthday_cake);
        ice_cream=findViewById(R.id.ice_cream);
        play1=findViewById(R.id.play_audio1);
        play2=findViewById(R.id.play_audio2);
        teddy.setOnClickListener(click);
        woman.setOnClickListener(click);
        cake.setOnClickListener(click);
        ice_cream.setOnClickListener(click);
        prevscore=findViewById(R.id.score);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button_from_activity);

        TextView title = findViewById(R.id.title);
        title.setText("Επέλεξε την κατάλληλη εικόνα. Πάτησε στο ηχειάκι για να ακούσεις την εκφώνηση");
        title.setSelected(true);

        get_score_for_navbar("choose", prevscore, 2);

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_sound(R.raw.epilekse_ton_anthrwpo, play1);
            }
        });
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_sound(R.raw.epilekse_to_pagwto, play2);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(row1){
                    score++;
                }
                if(row2){
                    score++;
                }
                upload_score("choose", score,2);
                show_rating(score,2,choose.class,null,true);
            }
        });
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.teddy:
                    teddy.setBackground(getDrawable(R.color.teal_200));
                    woman.setBackground(getDrawable(R.color.white));
                    row1=false;
                    break;
                case R.id.woman:
                    woman.setBackground(getDrawable(R.color.teal_200));
                    teddy.setBackground(getDrawable(R.color.white));
                    row1=true;
                    break;
                case R.id.birthday_cake:
                    cake.setBackground(getDrawable(R.color.teal_200));
                    ice_cream.setBackground(getDrawable(R.color.white));
                    row2=false;
                    break;
                case R.id.ice_cream:
                    ice_cream.setBackground(getDrawable(R.color.teal_200));
                    cake.setBackground(getDrawable(R.color.white));
                    row2=true;
                    break;
            }
        }
    };
}