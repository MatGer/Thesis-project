package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.firestore.FirebaseFirestore;

public class change_password extends universal {
    Button change,cancel;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        runtime();
        hide_labels();

        change=findViewById(R.id.change_pass);
        cancel=findViewById(R.id.showcancel);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(back_button);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userID=fAuth.getCurrentUser().getUid();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_password.super.onBackPressed();
            }
        });
    }

}