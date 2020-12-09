package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class gnwstikes_menu extends universal {
    Button sigrish,arithmitikh,motiba;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gnwstikes_menu);
        runtime();

        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);

        sigrish=findViewById(R.id.sigrish);
        arithmitikh=findViewById(R.id.arithmitikh);
        motiba=findViewById(R.id.motiba);

        sigrish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(gnwstikes_menu.this, sigrish_menu.class);
                startActivity(intent);
            }
        });
        arithmitikh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(gnwstikes_menu.this, arithmhtikh_menu.class);
                startActivity(intent);
            }
        });
        motiba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(gnwstikes_menu.this, motiba_menu.class);
                startActivity(intent);
            }
        });
    }
}