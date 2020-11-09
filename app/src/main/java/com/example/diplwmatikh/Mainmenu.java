package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Mainmenu extends universal {
    Button dragndrop, correct_wrong,place_in_order,logoutbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        runtime();
        setContentView(R.layout.activity_mainmenu);

        dragndrop=findViewById(R.id.dragndrop);
        correct_wrong=findViewById(R.id.correctwrong);
        place_in_order=findViewById(R.id.placeinorder);
        logoutbutton=findViewById(R.id.logout_mainmenu_button);

        dragndrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainmenu.this, MainActivity.class);
                startActivity(intent);
            }
        });

        correct_wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainmenu.this, Correct_wrong.class);
                startActivity(intent);
            }
        });

        place_in_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainmenu.this, place_in_order.class);
                startActivity(intent);
            }
        });

        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
    }
}