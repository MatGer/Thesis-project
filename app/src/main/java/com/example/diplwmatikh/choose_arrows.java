package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class choose_arrows extends universal {
    Button check;
    ImageButton play,back;
    ImageView sample; //eikona sthn ekfwnhsh
    TextView prevscore,add_to_header; //ekfwnhsh
    ImageView row11,row12,row13,row14,row15,row16,row17,row18;
    ImageView row21,row22,row23,row24,row25,row26,row27,row28;
    ImageView row31,row32,row33,row34,row35,row36,row37,row38;
    boolean choice;
    boolean[][] answers;
    boolean[][] match_to_answer={{false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false}};
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_arrows);

        runtime();
        sample=findViewById(R.id.sample);
        add_to_header=findViewById(R.id.title_text);
        play=findViewById(R.id.play_audio);
        prevscore=findViewById(R.id.score);
        get_score_for_navbar("choose arrows", userID, prevscore, 12);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);

        TextView title = findViewById(R.id.title);
        title.setText("Επέλεξε τα κατάλληλα βελάκια. Πάτησε στο ηχειάκι για να ακούσεις την εκφώνηση");
        title.setSelected(true);

        choice=new Random().nextBoolean();

        if(choice){ //if choice = true tote metrame ta deksia belakia
            sample.setImageDrawable(getDrawable(R.drawable.arrow_right));
            add_to_header.append("δεξιά");
            answers=new boolean[][]{{true,false,true,false,false,true,false,true},{false,true,false,true,true,true,false,true},{false,false,true,false,true,false,true,false}};

        }else{  //if choice = false tote metrame ta aristera belakia
            sample.setImageDrawable(getDrawable(R.drawable.arrow_left));
            add_to_header.append("αριστερά");
            answers=new boolean[][]{{false,true,false,true,true,false,true,false},{true,false,true,false,false,false,true,false},{true,true,false,true,false,true,false,true}};// inverted se sxesh me ton apo panw pinaka
        }

        check=findViewById(R.id.check);
        row11=findViewById(R.id.row11);
        row12=findViewById(R.id.row12);
        row13=findViewById(R.id.row13);
        row14=findViewById(R.id.row14);
        row15=findViewById(R.id.row15);
        row16=findViewById(R.id.row16);
        row17=findViewById(R.id.row17);
        row18=findViewById(R.id.row18);
        row21=findViewById(R.id.row21);
        row22=findViewById(R.id.row22);
        row23=findViewById(R.id.row23);
        row24=findViewById(R.id.row24);
        row25=findViewById(R.id.row25);
        row26=findViewById(R.id.row26);
        row27=findViewById(R.id.row27);
        row28=findViewById(R.id.row28);
        row31=findViewById(R.id.row31);
        row32=findViewById(R.id.row32);
        row33=findViewById(R.id.row33);
        row34=findViewById(R.id.row34);
        row35=findViewById(R.id.row35);
        row36=findViewById(R.id.row36);
        row37=findViewById(R.id.row37);
        row38=findViewById(R.id.row38);

        row11.setOnClickListener(select);
        row12.setOnClickListener(select);
        row13.setOnClickListener(select);
        row14.setOnClickListener(select);
        row15.setOnClickListener(select);
        row16.setOnClickListener(select);
        row17.setOnClickListener(select);
        row18.setOnClickListener(select);
        row21.setOnClickListener(select);
        row22.setOnClickListener(select);
        row23.setOnClickListener(select);
        row24.setOnClickListener(select);
        row25.setOnClickListener(select);
        row26.setOnClickListener(select);
        row27.setOnClickListener(select);
        row28.setOnClickListener(select);
        row31.setOnClickListener(select);
        row32.setOnClickListener(select);
        row33.setOnClickListener(select);
        row34.setOnClickListener(select);
        row35.setOnClickListener(select);
        row36.setOnClickListener(select);
        row37.setOnClickListener(select);
        row38.setOnClickListener(select);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int x=0;x<3;x++){
                    for(int y=0;y<8;y++){
                        if(match_to_answer[x][y]==answers[x][y] && answers[x][y]==true){
                            score++;
                        }
                    }
                }
                //System.out.println("----------------------------------------------------------------------------------"+ score);
                //score=0; //enable this command for debbuging
                upload_score("choose arrows", score);
                show_rating(score,12,choose_arrows.class,drag_items_with_audio.class,true);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(choice){
                    play_sound(R.raw.arrows_right, play);
                }else{
                    play_sound(R.raw.arrows_left, play);
                }
            }
        });
    }


    View.OnClickListener select = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.row11:
                    if(match_to_answer[0][0]==false){
                        match_to_answer[0][0]=true;
                        row11.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[0][0]=false;
                        row11.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row12:
                    if(match_to_answer[0][1]==false){
                        match_to_answer[0][1]=true;
                        row12.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[0][1]=false;
                        row12.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
                case R.id.row13:
                    if(match_to_answer[0][2]==false){
                        match_to_answer[0][2]=true;
                        row13.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[0][2]=false;
                        row13.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row14:
                    if(match_to_answer[0][3]==false){
                        match_to_answer[0][3]=true;
                        row14.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[0][3]=false;
                        row14.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
                case R.id.row15:
                    if(match_to_answer[0][4]==false){
                        match_to_answer[0][4]=true;
                        row15.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[0][4]=false;
                        row15.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
                case R.id.row16:
                    if(match_to_answer[0][5]==false){
                        match_to_answer[0][5]=true;
                        row16.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[0][5]=false;
                        row16.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row17:
                    if(match_to_answer[0][6]==false){
                        match_to_answer[0][6]=true;
                        row17.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[0][6]=false;
                        row17.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
                case R.id.row18:
                    if(match_to_answer[0][7]==false){
                        match_to_answer[0][7]=true;
                        row18.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[0][7]=false;
                        row18.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row21:
                    if(match_to_answer[1][0]==false){
                        match_to_answer[1][0]=true;
                        row21.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[1][0]=false;
                        row21.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
                case R.id.row22:
                    if(match_to_answer[1][1]==false){
                        match_to_answer[1][1]=true;
                        row22.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[1][1]=false;
                        row22.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row23:
                    if(match_to_answer[1][2]==false){
                        match_to_answer[1][2]=true;
                        row23.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[1][2]=false;
                        row23.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
                case R.id.row24:
                    if(match_to_answer[1][3]==false){
                        match_to_answer[1][3]=true;
                        row24.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[1][3]=false;
                        row24.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row25:
                    if(match_to_answer[1][4]==false){
                        match_to_answer[1][4]=true;
                        row25.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[1][4]=false;
                        row25.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row26:
                    if(match_to_answer[1][5]==false){
                        match_to_answer[1][5]=true;
                        row26.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[1][5]=false;
                        row26.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row27:
                    if(match_to_answer[1][6]==false){
                        match_to_answer[1][6]=true;
                        row27.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[1][6]=false;
                        row27.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
                case R.id.row28:
                    if(match_to_answer[1][7]==false){
                        match_to_answer[1][7]=true;
                        row28.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[1][7]=false;
                        row28.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row31:
                    if(match_to_answer[2][0]==false){
                        match_to_answer[2][0]=true;
                        row31.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[2][0]=false;
                        row31.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
                case R.id.row32:
                    if(match_to_answer[2][1]==false){
                        match_to_answer[2][1]=true;
                        row32.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[2][1]=false;
                        row32.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
                case R.id.row33:
                    if(match_to_answer[2][2]==false){
                        match_to_answer[2][2]=true;
                        row33.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[2][2]=false;
                        row33.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row34:
                    if(match_to_answer[2][3]==false){
                        match_to_answer[2][3]=true;
                        row34.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[2][3]=false;
                        row34.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
                case R.id.row35:
                    if(match_to_answer[2][4]==false){
                        match_to_answer[2][4]=true;
                        row35.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[2][4]=false;
                        row35.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row36:
                    if(match_to_answer[2][5]==false){
                        match_to_answer[2][5]=true;
                        row36.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[2][5]=false;
                        row36.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
                case R.id.row37:
                    if(match_to_answer[2][6]==false){
                        match_to_answer[2][6]=true;
                        row37.setImageDrawable(getDrawable(R.drawable.arrow_right_selected));
                    }else{
                        match_to_answer[2][6]=false;
                        row37.setImageDrawable(getDrawable(R.drawable.arrow_right));
                    }
                    break;
                case R.id.row38:
                    if(match_to_answer[2][7]==false){
                        match_to_answer[2][7]=true;
                        row38.setImageDrawable(getDrawable(R.drawable.arrow_left_selected));
                    }else{
                        match_to_answer[2][7]=false;
                        row38.setImageDrawable(getDrawable(R.drawable.arrow_left));
                    }
                    break;
            }
        }
    };
}