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

        teddy.setOnClickListener(click);
        woman.setOnClickListener(click);
        cake.setOnClickListener(click);
        ice_cream.setOnClickListener(click);

        TextView title = findViewById(R.id.title);
        title.setText("Επέλεξε την κατάλληλη εικόνα. Πάτησε στο ηχειάκι για να ακούσεις την εκφώνηση");
        title.setSelected(true);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(row1){
                    score++;
                }
                if(row2){
                    score++;
                }
                upload_score("choose ", score);
                create_builder_finished_with_score(score);
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