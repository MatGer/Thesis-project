package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class choose_those_who_match extends universal {
    int score=0;
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
    ImageView play1,play2,play3,play4,play5,play6,play7,play8;
    Button check;
    boolean[][] answer = {{true,false,true,true},{false,false,true,false}};
    boolean[][] match_to_answer = {{false,false,false,false},{false,false,false,false}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_those_who_match);

        runtime();

        txt1=findViewById(R.id.click1);
        txt2=findViewById(R.id.click2);
        txt3=findViewById(R.id.click3);
        txt4=findViewById(R.id.click4);
        txt5=findViewById(R.id.click5);
        txt6=findViewById(R.id.click6);
        txt7=findViewById(R.id.click7);
        txt8=findViewById(R.id.click8);

        play1=findViewById(R.id.play_click1);
        play2=findViewById(R.id.play_click2);
        play3=findViewById(R.id.play_click3);
        play4=findViewById(R.id.play_click4);
        play5=findViewById(R.id.play_click5);
        play6=findViewById(R.id.play_click6);
        play7=findViewById(R.id.play_click7);
        play8=findViewById(R.id.play_click8);

        check=findViewById(R.id.check);

        txt1.setOnClickListener(click);
        txt2.setOnClickListener(click);
        txt3.setOnClickListener(click);
        txt4.setOnClickListener(click);
        txt5.setOnClickListener(click);
        txt6.setOnClickListener(click);
        txt7.setOnClickListener(click);
        txt8.setOnClickListener(click);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int x=0;x<2;x++){
                    for (int y=0; y<4;y++){
                        if (match_to_answer[x][y]==answer[x][y] && answer[x][y]==true){
                            score++;
                        }
                    }
                }
                upload_score("choose those who match",score);
                create_builder_finished_with_score(score);
            }
        });
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.click1:
                    if(!match_to_answer[0][0]){
                        match_to_answer[0][0]=true;
                        txt1.setBackground(getDrawable(R.color.light_blue_A200));
                    }else{
                        match_to_answer[0][0]=false;
                        txt1.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.click2:
                    if(!match_to_answer[0][1]){
                        match_to_answer[0][1]=true;
                        txt2.setBackground(getDrawable(R.color.light_blue_A200));
                    }else{
                        match_to_answer[0][1]=false;
                        txt2.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.click3:
                    if(!match_to_answer[0][2]){
                        match_to_answer[0][2]=true;
                        txt3.setBackground(getDrawable(R.color.light_blue_A200));
                    }else{
                        match_to_answer[0][2]=false;
                        txt3.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.click4:
                    if(!match_to_answer[0][3]){
                        match_to_answer[0][3]=true;
                        txt4.setBackground(getDrawable(R.color.light_blue_A200));
                    }else{
                        match_to_answer[0][3]=false;
                        txt4.setBackground(getDrawable(R.color.white));
                    }
                case R.id.click5:
                    if(!match_to_answer[1][0]){
                        match_to_answer[1][0]=true;
                        txt5.setBackground(getDrawable(R.color.light_blue_A200));
                    }else{
                        match_to_answer[1][0]=false;
                        txt5.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.click6:
                    if(!match_to_answer[1][1]){
                        match_to_answer[1][1]=true;
                        txt6.setBackground(getDrawable(R.color.light_blue_A200));
                    }else{
                        match_to_answer[1][1]=false;
                        txt6.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.click7:
                    if(!match_to_answer[1][2]){
                        match_to_answer[1][2]=true;
                        txt7.setBackground(getDrawable(R.color.light_blue_A200));
                    }else{
                        match_to_answer[1][2]=false;
                        txt7.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.click8:
                    if(!match_to_answer[1][3]){
                        match_to_answer[1][3]=true;
                        txt8.setBackground(getDrawable(R.color.light_blue_A200));
                    }else{
                        match_to_answer[1][3]=false;
                        txt8.setBackground(getDrawable(R.color.white));
                    }
                    break;
            }
        }
    };
}