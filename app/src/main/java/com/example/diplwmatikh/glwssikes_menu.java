package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class glwssikes_menu extends universal {
    Button perigrafi,odhgies,arithmoi;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glwssikes_menu);
        runtime();

        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);

        perigrafi=findViewById(R.id.perigrafi);
        odhgies=findViewById(R.id.odhgies);
        arithmoi=findViewById(R.id.arithmoi);

        perigrafi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(glwssikes_menu.this, perigrafh_menu.class);
                startActivity(intent);
            }
        });
        odhgies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(glwssikes_menu.this, odhgies_menu.class);
                startActivity(intent);
            }
        });
        arithmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(glwssikes_menu.this, arithmoi_menu.class);
                startActivity(intent);
            }
        });
    }
}