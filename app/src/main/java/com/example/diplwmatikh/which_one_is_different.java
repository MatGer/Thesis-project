package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class which_one_is_different extends universal {
    ImageView row11,row12,row13,row21,row22,row23,row31,row32,row33;
    int row1,row2,row3=-1;
    int score=0;
    Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which_one_is_different);

        runtime();

        TextView title = findViewById(R.id.title);
        title.setText("Επέλεξε την εικόνα που δεν ταιριάζει.");
        title.setSelected(true);

        row11=findViewById(R.id.row11);
        row12=findViewById(R.id.row12);
        row13=findViewById(R.id.row13);
        row21=findViewById(R.id.row21);
        row22=findViewById(R.id.row22);
        row23=findViewById(R.id.row23);
        row31=findViewById(R.id.row13);
        row32=findViewById(R.id.row32);
        row33=findViewById(R.id.row33);
        check=findViewById(R.id.check);

        row11.setOnClickListener(clickListener);
        row12.setOnClickListener(clickListener);
        row13.setOnClickListener(clickListener);
        row21.setOnClickListener(clickListener);
        row22.setOnClickListener(clickListener);
        row23.setOnClickListener(clickListener);
        row31.setOnClickListener(clickListener);
        row32.setOnClickListener(clickListener);
        row33.setOnClickListener(clickListener);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(row1==0){
                    score++;
                }
                if(row2==2){
                    score++;
                }
                if(row3==1){
                    score++;
                }
                upload_score("which one is different", score);
                create_builder_finished_with_score(score);
            }
        });
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.row11:
                    row11.setBackground(getDrawable(R.color.teal_200));
                    row12.setBackground(getDrawable(R.color.white));
                    row12.setBackground(getDrawable(R.color.white));
                    row1=0;
                    break;
                case R.id.row12:
                    row12.setBackground(getDrawable(R.color.teal_200));
                    row11.setBackground(getDrawable(R.color.white));
                    row12.setBackground(getDrawable(R.color.white));
                    row1=1;
                    break;
                case R.id.row13:
                    row13.setBackground(getDrawable(R.color.teal_200));
                    row12.setBackground(getDrawable(R.color.white));
                    row11.setBackground(getDrawable(R.color.white));
                    row1=2;
                    break;
                case R.id.row21:
                    row21.setBackground(getDrawable(R.color.teal_200));
                    row22.setBackground(getDrawable(R.color.white));
                    row23.setBackground(getDrawable(R.color.white));
                    row2=0;
                    break;
                case R.id.row22:
                    row22.setBackground(getDrawable(R.color.teal_200));
                    row21.setBackground(getDrawable(R.color.white));
                    row23.setBackground(getDrawable(R.color.white));
                    row2=1;
                    break;
                case R.id.row23:
                    row23.setBackground(getDrawable(R.color.teal_200));
                    row22.setBackground(getDrawable(R.color.white));
                    row21.setBackground(getDrawable(R.color.white));
                    row2=2;
                    break;
                case R.id.row31:
                    row31.setBackground(getDrawable(R.color.teal_200));
                    row32.setBackground(getDrawable(R.color.white));
                    row33.setBackground(getDrawable(R.color.white));
                    row3=0;
                    break;
                case R.id.row32:
                    row32.setBackground(getDrawable(R.color.teal_200));
                    row31.setBackground(getDrawable(R.color.white));
                    row33.setBackground(getDrawable(R.color.white));
                    row3=1;
                    break;
                case R.id.row33:
                    row33.setBackground(getDrawable(R.color.teal_200));
                    row32.setBackground(getDrawable(R.color.white));
                    row31.setBackground(getDrawable(R.color.white));
                    row3=2;
                    break;
            }
        }
    };
}