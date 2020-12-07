package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class settings extends universal {
    TextView change_details,change_pass,logout,showscores;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        runtime();

        change_details=findViewById(R.id.change_details);
        change_pass=findViewById(R.id.change_pass);
        logout=findViewById(R.id.logout);
        showscores=findViewById(R.id.showscores);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);

        change_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(settings.this, Edit_data.class));
                finish();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userID=null;
                fAuth.signOut();
                startActivity(new Intent(settings.this, LoginActivity.class));
                finish();
            }
        });
        showscores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(settings.this, activity_scores.class));
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}