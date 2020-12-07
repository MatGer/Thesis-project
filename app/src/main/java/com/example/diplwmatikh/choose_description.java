package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class choose_description extends universal {
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,prevscore;
    ImageView play1,play2,play3,play4,play5,play6,play7,play8;
    Button check;
    int upleft,upright,bottomleft,bottomright=-1;
//correct   1     2         2          1
    int score=0;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_description);

        runtime();

        TextView title = findViewById(R.id.title);
        title.setText("Επέλεξε την περιγραφή που ταιριάζει σε κάθε εικόνα. Πάτησε στο ηχειάκι για να ακούσεις την εκφώνηση");
        title.setSelected(true);

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
        prevscore=findViewById(R.id.score);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);

        txt1.setOnClickListener(clickListener);
        txt2.setOnClickListener(clickListener);
        txt3.setOnClickListener(clickListener);
        txt4.setOnClickListener(clickListener);
        txt5.setOnClickListener(clickListener);
        txt6.setOnClickListener(clickListener);
        txt7.setOnClickListener(clickListener);
        txt8.setOnClickListener(clickListener);

        play1.setOnClickListener(play);
        play2.setOnClickListener(play);
        play3.setOnClickListener(play);
        play4.setOnClickListener(play);
        play5.setOnClickListener(play);
        play6.setOnClickListener(play);
        play7.setOnClickListener(play);
        play8.setOnClickListener(play);

        get_score_for_navbar("choose description", userID, prevscore, 4);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upleft==1){
                    score++;
                }
                if(upright==2){
                    score++;
                }
                if(bottomleft==2){
                    score++;
                }
                if(bottomright==1){
                    score++;
                }
                upload_score("choose description", score);
                create_builder_finished_with_score(score);
            }
        });
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.click1:
                    txt1.setBackground(getDrawable(R.color.light_blue_A200));
                    txt2.setBackground(getDrawable(R.color.white));
                    upleft=1;
                    break;
                case R.id.click2:
                    txt2.setBackground(getDrawable(R.color.light_blue_A200));
                    txt1.setBackground(getDrawable(R.color.white));
                    upleft=2;
                    break;
                case R.id.click3:
                    txt3.setBackground(getDrawable(R.color.light_blue_A200));
                    txt4.setBackground(getDrawable(R.color.white));
                    upright=1;
                    break;
                case R.id.click4:
                    txt4.setBackground(getDrawable(R.color.light_blue_A200));
                    txt3.setBackground(getDrawable(R.color.white));
                    upright=2;
                    break;
                case R.id.click5:
                    txt5.setBackground(getDrawable(R.color.light_blue_A200));
                    txt6.setBackground(getDrawable(R.color.white));
                    bottomleft=1;
                    break;
                case R.id.click6:
                    txt6.setBackground(getDrawable(R.color.light_blue_A200));
                    txt5.setBackground(getDrawable(R.color.white));
                    bottomleft=2;
                    break;
                case R.id.click7:
                    txt7.setBackground(getDrawable(R.color.light_blue_A200));
                    txt8.setBackground(getDrawable(R.color.white));
                    bottomright=1;
                    break;
                case R.id.click8:
                    txt8.setBackground(getDrawable(R.color.light_blue_A200));
                    txt7.setBackground(getDrawable(R.color.white));
                    bottomright=2;
                    break;
            }
        }
    };

    View.OnClickListener play = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.play_click1: play_sound(R.raw.einai_pappous, play1); break;
                case R.id.play_click2: play_sound(R.raw.einai_paidi, play2); break;
                case R.id.play_click3: play_sound(R.raw.monh_ths, play3); break;
                case R.id.play_click4: play_sound(R.raw.me_paidia_ths, play4); break;
                case R.id.play_click5: play_sound(R.raw.fwraei_panteloni, play5); break;
                case R.id.play_click6: play_sound(R.raw.forema, play6); break;
                case R.id.play_click7: play_sound(R.raw.doulevei, play7); break;
                case R.id.play_click8: play_sound(R.raw.ksekourazetai, play8); break;
            }
        }
    };
}