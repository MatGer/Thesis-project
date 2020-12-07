package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

public class change_password extends universal {
    Button change,back;
    String UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        runtime();

        change=findViewById(R.id.change_pass);
        back=findViewById(R.id.showcancel);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userID=fAuth.getCurrentUser().getUid();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_password.super.onBackPressed();
            }
        });
    }

}