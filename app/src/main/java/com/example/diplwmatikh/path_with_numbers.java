package com.example.diplwmatikh;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Collections;

public class path_with_numbers extends universal implements OnClickListener {
    TextView tile1,tile2,tile3,tile4,tile5;
    TextView tile6,tile7,tile8,tile9,tile10;
    TextView tile11,tile12,tile13,tile14,tile15;
    TextView tile16,tile17,tile18,tile19,tile20;
    TextView tile21,tile22,tile23,tile24,tile25;
    Button check;
    ImageButton back;
    int counter_score=0;
    int selected_path; //poio path epilegetai kathe fora
    boolean [][] paths={
            {true,true,false,false,false,true,true,false,false,false,false,true,true,false,false,false,false,true,true,true,false,false,true,true,false},//path0
            {false,false,false,true,true,true,true,true,true,true,true,true,false,false,true,false,false,false,false,true,false,false,false,false,false},//path1
            {false,false,false,false,false,true,true,false,false,false,false,true,true,true,false,false,true,true,true,true,false,false,false,true,true},//path2
            {false,false,false,false,false,true,false,true,true,false,true,false,true,true,false,true,true,true,true,true,false,true,true,false,false}};//path3

    boolean [] current_state={false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_with_numbers);
        runtime();
        TextView title = findViewById(R.id.title);
        title.setText("Βοήθησε το αρκουδάκι να φτάσει στην καραμέλα. Επέλεξε τους αριθμούς που θα πρέπει να ακολουθήσει.");
        title.setSelected(true);

        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);

        selected_path=(int) (Math.random() * (3-0+1)+0);
        //assign tiles
        tile1=findViewById(R.id.tile1);
        tile2=findViewById(R.id.tile2);
        tile3=findViewById(R.id.tile3);
        tile4=findViewById(R.id.tile4);
        tile5=findViewById(R.id.tile5);
        tile6=findViewById(R.id.tile6);
        tile7=findViewById(R.id.tile7);
        tile8=findViewById(R.id.tile8);
        tile9=findViewById(R.id.tile9);
        tile10=findViewById(R.id.tile10);
        tile11=findViewById(R.id.tile11);
        tile12=findViewById(R.id.tile12);
        tile13=findViewById(R.id.tile13);
        tile14=findViewById(R.id.tile14);
        tile15=findViewById(R.id.tile15);
        tile16=findViewById(R.id.tile16);
        tile17=findViewById(R.id.tile17);
        tile18=findViewById(R.id.tile18);
        tile19=findViewById(R.id.tile19);
        tile20=findViewById(R.id.tile20);
        tile21=findViewById(R.id.tile21);
        tile22=findViewById(R.id.tile22);
        tile23=findViewById(R.id.tile23);
        tile24=findViewById(R.id.tile24);
        tile25=findViewById(R.id.tile25);

        put_numbers(selected_path);
        //assign click listener
        tile1.setOnClickListener(this);
        tile2.setOnClickListener(this);
        tile3.setOnClickListener(this);
        tile4.setOnClickListener(this);
        tile5.setOnClickListener(this);
        tile6.setOnClickListener(this);
        tile7.setOnClickListener(this);
        tile8.setOnClickListener(this);
        tile9.setOnClickListener(this);
        tile10.setOnClickListener(this);
        tile11.setOnClickListener(this);
        tile12.setOnClickListener(this);
        tile13.setOnClickListener(this);
        tile14.setOnClickListener(this);
        tile15.setOnClickListener(this);
        tile16.setOnClickListener(this);
        tile17.setOnClickListener(this);
        tile18.setOnClickListener(this);
        tile19.setOnClickListener(this);
        tile20.setOnClickListener(this);
        tile21.setOnClickListener(this);
        tile22.setOnClickListener(this);
        tile23.setOnClickListener(this);
        tile24.setOnClickListener(this);
        tile25.setOnClickListener(this);

        check=findViewById(R.id.check);
        check.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<25;i++){
                    if(current_state[i]==true && paths[selected_path][i]==true){
                        counter_score++;
                    }
                }
                upload_score("path_of_numbers2",counter_score);
                create_builder_finished_with_score(counter_score);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    void put_numbers(int path){
        switch (path){
            case 0:
                tile6.setText("1");
                tile1.setText("2");
                tile2.setText("3");
                tile7.setText("4");
                tile12.setText("5");
                tile13.setText("6");
                tile18.setText("7");
                tile23.setText("8");
                tile24.setText("9");
                tile19.setText("10");
                tile20.setText("11");
                //fill 12-25
                //remaining_cells=new int[] {3,4,5,8,9,10,11,14,15,16,17,21,22,25};
                tile3.setText("15");
                tile4.setText("20");
                tile5.setText("12");
                tile8.setText("24");
                tile9.setText("19");
                tile10.setText("14");
                tile11.setText("22");
                tile14.setText("21");
                tile15.setText("13");
                tile16.setText("18");
                tile17.setText("17");
                tile21.setText("25");
                tile22.setText("23");
                tile25.setText("16");
                break;
            case 1:
                tile6.setText("1");
                tile11.setText("2");
                tile12.setText("3");
                tile7.setText("4");
                tile8.setText("5");
                tile9.setText("6");
                tile4.setText("7");
                tile5.setText("8");
                tile10.setText("9");
                tile15.setText("10");
                tile20.setText("11");
                //fill 12-25
                //remaining_cells=new int[] {1,2,3,13,14,16,17,18,19,21,22,23,24,25};
                tile1.setText("15");
                tile2.setText("20");
                tile3.setText("12");
                tile13.setText("24");
                tile14.setText("19");
                tile16.setText("14");
                tile17.setText("22");
                tile18.setText("21");
                tile19.setText("13");
                tile21.setText("17");
                tile22.setText("25");
                tile23.setText("23");
                tile24.setText("23");
                tile25.setText("16");

                break;
            case 2:
                tile6.setText("1");
                tile7.setText("2");
                tile12.setText("3");
                tile17.setText("4");
                tile18.setText("5");
                tile13.setText("6");
                tile14.setText("7");
                tile19.setText("8");
                tile24.setText("9");
                tile25.setText("10");
                tile20.setText("11");
                //fill 12-25
                //remaining_cells=new int[] {1,2,3,4,5,8,9,10,11,15,16,21,22,23};
                tile1.setText("15");
                tile2.setText("20");
                tile3.setText("12");
                tile4.setText("24");
                tile5.setText("19");
                tile8.setText("14");
                tile9.setText("22");
                tile10.setText("21");
                tile11.setText("13");
                tile15.setText("17");
                tile16.setText("25");
                tile21.setText("23");
                tile22.setText("23");
                tile23.setText("16");
                break;
            case 3:
                tile6.setText("1");
                tile11.setText("2");
                tile16.setText("3");
                tile17.setText("4");
                tile22.setText("5");
                tile23.setText("6");
                tile18.setText("7");
                tile13.setText("8");
                tile8.setText("9");
                tile9.setText("10");
                tile14.setText("11");
                tile19.setText("12");
                tile20.setText("13");
                //fill 14-25
                //remaining_cells=new int[] {1,2,3,4,5,7,10,12,15,21,24,25};
                tile1.setText("16");
                tile2.setText("23");
                tile3.setText("18");
                tile4.setText("24");
                tile5.setText("14");
                tile7.setText("20");
                tile10.setText("25");
                tile12.setText("17");
                tile15.setText("22");
                tile21.setText("15");
                tile24.setText("21");
                tile25.setText("19");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + path);
        }
    }

    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables"})
    @Override
    public void onClick(View v) {
        int id=0;
        TextView txt=null;
        switch (v.getId()){
            case R.id.tile1: id=0; txt=tile1;break;
            case R.id.tile2: id=1; txt=tile2;break;
            case R.id.tile3: id=2; txt=tile3;break;
            case R.id.tile4: id=3; txt=tile4;break;
            case R.id.tile5: id=4; txt=tile5;break;
            case R.id.tile6: id=5; txt=tile6;break;
            case R.id.tile7: id=6; txt=tile7;break;
            case R.id.tile8: id=7; txt=tile8;break;
            case R.id.tile9: id=8; txt=tile9;break;
            case R.id.tile10: id=9; txt=tile10;break;
            case R.id.tile11: id=10; txt=tile11;break;
            case R.id.tile12: id=11; txt=tile12;break;
            case R.id.tile13: id=12; txt=tile13;break;
            case R.id.tile14: id=13; txt=tile14;break;
            case R.id.tile15: id=14; txt=tile15;break;
            case R.id.tile16: id=15; txt=tile16;break;
            case R.id.tile17: id=16; txt=tile17;break;
            case R.id.tile18: id=17; txt=tile18;break;
            case R.id.tile19: id=18; txt=tile19;break;
            case R.id.tile20: id=19; txt=tile20;break;
            case R.id.tile21: id=20; txt=tile21;break;
            case R.id.tile22: id=21; txt=tile22;break;
            case R.id.tile23: id=22; txt=tile23;break;
            case R.id.tile24: id=23; txt=tile24;break;
            case R.id.tile25: id=24; txt=tile25;break;
        }
        if(current_state[id]){
            current_state[id]=false;
            txt.setBackground(getDrawable(R.drawable.unselected_tile_with_borders));
            System.out.println("-------------------------------------------------cell " +id+ " changed to false");
        }else{
            current_state[id]=true;
            txt.setBackground(getDrawable(R.drawable.selected_tile_with_borders));
            System.out.println("-------------------------------------------------cell " +id+ "changed to true");
        }
    }
}