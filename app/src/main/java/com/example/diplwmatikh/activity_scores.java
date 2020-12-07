package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class activity_scores extends universal {
    ImageButton back;
    Button gotomenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        runtime();

        back=findViewById(R.id.backbutton);
        gotomenu=findViewById(R.id.gotomenu);

        get_score("add animals", userID,findViewById(R.id.ac1));
        get_score("choose arrows", userID,findViewById(R.id.ac2));
        get_score("complete the pattern", userID,findViewById(R.id.ac3));
        get_score("path_of_numbers2", userID,findViewById(R.id.ac4));

        /*

        //implement names and add all activities

        get_score("add animals", userID,findViewById(R.id.ac5));
        get_score("choose arrows", userID,findViewById(R.id.ac6));
        get_score("complete the pattern", userID,findViewById(R.id.ac7));
        get_score("path_of_numbers2", userID,findViewById(R.id.ac8));
        get_score("add animals", userID,findViewById(R.id.ac9));
        get_score("choose arrows", userID,findViewById(R.id.ac10));
        get_score("complete the pattern", userID,findViewById(R.id.ac11));
        get_score("path_of_numbers2", userID,findViewById(R.id.ac12));

         */

        back.setOnClickListener(back_button);

        gotomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_scores.this, Mainmenu.class));
                finish();
            }
        });
    }
}