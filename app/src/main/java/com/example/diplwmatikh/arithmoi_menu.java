package com.example.diplwmatikh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class arithmoi_menu extends universal {
    Button btn1,btn2,btn3;
    ImageButton back,info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmoi_menu);
        runtime();

        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        info=findViewById(R.id.infobutton);
        info.setOnClickListener(info_button);
        get_color("drag and drop numbers", btn1);
        get_color("path with numbers", btn2);
        get_color("drag 2 items", btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(arithmoi_menu.this, drag_and_drop_numbers.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(arithmoi_menu.this, path_with_numbers.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(arithmoi_menu.this, drag_2_items.class);
                startActivity(intent);
            }
        });
    }
}