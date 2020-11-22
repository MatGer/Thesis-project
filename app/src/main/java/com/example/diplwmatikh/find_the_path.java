package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class find_the_path extends universal {
    ImageView circle1,circle2,circle3,circle4,circle5,circle6,circle7,circle8,circle9,circle10;
    ImageView triangle1,triangle2,triangle3,triangle4,triangle5,triangle6,triangle7,triangle8;
    ImageView rhombus1,rhombus2,rhombus3,rhombus4,rhombus5,rhombus6,rhombus7,rhombus8;
    boolean[] users_answer={false,false,false,false,false,false,false,false,false,false};       //kathe keli antisoixei se ena circle object
    boolean[] current_state_triangles={false,false,false,false,false,false,false,false}; //for the rest objects to change backround colours
    boolean[] current_state_rhombuses={false,false,false,false,false,false,false,false};
    Button check;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_the_path);

        runtime();

        circle1=findViewById(R.id.circle1);
        circle2=findViewById(R.id.circle2);
        circle3=findViewById(R.id.circle3);
        circle4=findViewById(R.id.circle4);
        circle5=findViewById(R.id.circle5);
        circle6=findViewById(R.id.circle6);
        circle7=findViewById(R.id.circle7);
        circle8=findViewById(R.id.circle8);
        circle9=findViewById(R.id.circle9);
        circle10=findViewById(R.id.circle10);

        triangle1=findViewById(R.id.triangle1);
        triangle2=findViewById(R.id.triangle2);
        triangle3=findViewById(R.id.triangle3);
        triangle4=findViewById(R.id.triangle4);
        triangle5=findViewById(R.id.triangle5);
        triangle6=findViewById(R.id.triangle6);
        triangle7=findViewById(R.id.triangle7);
        triangle8=findViewById(R.id.triangle8);

        rhombus1=findViewById(R.id.rhombus1);
        rhombus2=findViewById(R.id.rhombus2);
        rhombus3=findViewById(R.id.rhombus3);
        rhombus4=findViewById(R.id.rhombus4);
        rhombus5=findViewById(R.id.rhombus5);
        rhombus6=findViewById(R.id.rhombus6);
        rhombus7=findViewById(R.id.rhombus7);
        rhombus8=findViewById(R.id.rhombus8);

        check=findViewById(R.id.check);

        circle1.setOnClickListener(selection);
        circle2.setOnClickListener(selection);
        circle3.setOnClickListener(selection);
        circle4.setOnClickListener(selection);
        circle5.setOnClickListener(selection);
        circle6.setOnClickListener(selection);
        circle7.setOnClickListener(selection);
        circle8.setOnClickListener(selection);
        circle9.setOnClickListener(selection);
        circle10.setOnClickListener(selection);

        triangle1.setOnClickListener(others_selection);
        triangle2.setOnClickListener(others_selection);
        triangle3.setOnClickListener(others_selection);
        triangle4.setOnClickListener(others_selection);
        triangle5.setOnClickListener(others_selection);
        triangle6.setOnClickListener(others_selection);
        triangle7.setOnClickListener(others_selection);
        triangle8.setOnClickListener(others_selection);

        rhombus1.setOnClickListener(others_selection);
        rhombus2.setOnClickListener(others_selection);
        rhombus3.setOnClickListener(others_selection);
        rhombus4.setOnClickListener(others_selection);
        rhombus5.setOnClickListener(others_selection);
        rhombus6.setOnClickListener(others_selection);
        rhombus7.setOnClickListener(others_selection);
        rhombus8.setOnClickListener(others_selection);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int x=0;x<users_answer.length;x++){
                    if(users_answer[x]==true){
                        score++;
                    }
                }
                upload_score("find the path", score);
                create_builder_finished_with_score(score);
            }
        });
    }

    View.OnClickListener selection = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.circle1:
                    if (!users_answer[0]){
                        users_answer[0]=true;
                        circle1.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        users_answer[0]=false;
                        circle1.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.circle2:
                    if (!users_answer[1]){
                        users_answer[1]=true;
                        circle2.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        users_answer[1]=false;
                        circle2.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.circle3:
                    if (!users_answer[2]){
                        users_answer[2]=true;
                        circle3.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        users_answer[2]=false;
                        circle3.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.circle4:
                    if (!users_answer[3]){
                        users_answer[3]=true;
                        circle4.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        users_answer[3]=false;
                        circle4.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.circle5:
                    if (!users_answer[4]){
                        users_answer[4]=true;
                        circle5.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        users_answer[4]=false;
                        circle5.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.circle6:
                    if (!users_answer[5]){
                        users_answer[5]=true;
                        circle6.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        users_answer[5]=false;
                        circle6.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.circle7:
                    if (!users_answer[6]){
                        users_answer[6]=true;
                        circle7.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        users_answer[6]=false;
                        circle7.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.circle8:
                    if (!users_answer[7]){
                        users_answer[7]=true;
                        circle8.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        users_answer[7]=false;
                        circle8.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.circle9:
                    if (!users_answer[8]){
                        users_answer[8]=true;
                        circle9.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        users_answer[8]=false;
                        circle9.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.circle10:
                    if (!users_answer[9]){
                        users_answer[9]=true;
                        circle10.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        users_answer[9]=false;
                        circle10.setBackground(getDrawable(R.color.white));
                    }
                    break;
            }
        }
    };

    View.OnClickListener others_selection = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.triangle1:
                    if(!current_state_triangles[0]){
                        current_state_triangles[0]=true;
                        triangle1.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_triangles[0]=false;
                        triangle1.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.triangle2:
                    if(!current_state_triangles[1]){
                        current_state_triangles[1]=true;
                        triangle2.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_triangles[1]=false;
                        triangle2.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.triangle3:
                    if(!current_state_triangles[2]){
                        current_state_triangles[2]=true;
                        triangle3.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_triangles[2]=false;
                        triangle3.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.triangle4:
                    if(!current_state_triangles[3]){
                        current_state_triangles[3]=true;
                        triangle4.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_triangles[3]=false;
                        triangle4.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.triangle5:
                    if(!current_state_triangles[4]){
                        current_state_triangles[4]=true;
                        triangle5.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_triangles[4]=false;
                        triangle5.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.triangle6:
                    if(!current_state_triangles[5]){
                        current_state_triangles[5]=true;
                        triangle6.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_triangles[5]=false;
                        triangle6.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.triangle7:
                    if(!current_state_triangles[6]){
                        current_state_triangles[6]=true;
                        triangle7.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_triangles[6]=false;
                        triangle7.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.triangle8:
                    if(!current_state_triangles[7]){
                        current_state_triangles[7]=true;
                        triangle8.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_triangles[7]=false;
                        triangle8.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.rhombus1:
                    if(!current_state_rhombuses[0]){
                        current_state_rhombuses[0]=true;
                        rhombus1.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_rhombuses[0]=false;
                        rhombus1.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.rhombus2:
                    if(!current_state_rhombuses[1]){
                        current_state_rhombuses[1]=true;
                        rhombus2.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_rhombuses[1]=false;
                        rhombus2.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.rhombus3:
                    if(!current_state_rhombuses[2]){
                        current_state_rhombuses[2]=true;
                        rhombus3.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_rhombuses[2]=false;
                        rhombus3.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.rhombus4:
                    if(!current_state_rhombuses[3]){
                        current_state_rhombuses[3]=true;
                        rhombus4.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_rhombuses[3]=false;
                        rhombus4.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.rhombus5:
                    if(!current_state_rhombuses[4]){
                        current_state_rhombuses[4]=true;
                        rhombus5.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_rhombuses[4]=false;
                        rhombus5.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.rhombus6:
                    if(!current_state_rhombuses[5]){
                        current_state_rhombuses[5]=true;
                        rhombus6.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_rhombuses[5]=false;
                        rhombus6.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.rhombus7:
                    if(!current_state_rhombuses[6]){
                        current_state_rhombuses[6]=true;
                        rhombus7.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_rhombuses[6]=false;
                        rhombus7.setBackground(getDrawable(R.color.white));
                    }
                    break;
                case R.id.rhombus8:
                    if(!current_state_rhombuses[7]){
                        current_state_rhombuses[7]=true;
                        rhombus8.setBackground(getDrawable(R.color.light_blue));
                    }else{
                        current_state_rhombuses[7]=false;
                        rhombus8.setBackground(getDrawable(R.color.white));
                    }
                    break;
            }
        }
    };
}