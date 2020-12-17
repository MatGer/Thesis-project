package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class odhgies_menu extends universal {
    Button btn1,btn2,btn3;
    ImageButton back,info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odhgies_menu);
        runtime();

        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        info=findViewById(R.id.infobutton);
        info.setOnClickListener(info_button);
        get_color("find the path", btn1);
        get_color("choose arrows", btn2);
        get_color("drag items with audio", btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(odhgies_menu.this, find_the_path.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(odhgies_menu.this, choose_arrows.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(odhgies_menu.this, drag_items_with_audio.class);
                startActivity(intent);
            }
        });
    }
}