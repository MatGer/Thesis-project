package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class motiba_menu extends universal {
    Button btn1,btn2;
    ImageButton back,info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motiba_menu);
        runtime();

        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        info=findViewById(R.id.infobutton);
        info.setOnClickListener(info_button);
        get_color("complete the pattern", btn1);
        get_color("complete the shape", btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(motiba_menu.this, complete_the_pattern.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(motiba_menu.this, complete_the_shape.class);
                startActivity(intent);
            }
        });
    }
}