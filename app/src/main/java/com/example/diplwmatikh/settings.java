package com.example.diplwmatikh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class settings extends universal {
    TextView change_details,change_pass,logout,showscores,resetscores;
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
        resetscores=findViewById(R.id.resetscores);

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

        resetscores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder delete_data;
                delete_data= new AlertDialog.Builder(settings.this);
                delete_data.setTitle("Διαγραφή δεδομένων!");
                delete_data.setMessage("Θέλεις να διαγράψεις όλες σου τις βαθμολογίες;\nΑυτή η ενέργεια δεν μπορεί να ανερεθεί!");
                delete_data
                        .setPositiveButton("Διαγραφή", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //delete all fields if they exist
                                reset_score("add animals");
                                reset_score("choose");
                                reset_score("choose arrows");
                                reset_score("choose description");
                                reset_score("choose those who match");
                                reset_score("complete the pattern");
                                reset_score("drag 2 items");
                                reset_score("drag and drop numbers");
                                reset_score("drag items with audio");
                                reset_score("find the path");
                                reset_score("how many");
                                reset_score("next number");
                                reset_score("path_of_numbers2");
                                reset_score("place in order");
                                reset_score("select the bigger");
                                reset_score("which one is different");
                                reset_score("write height");
                                reset_score("add animals");
                            }
                        })
                        .setNegativeButton("Άκυρο", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //restore ui elements
                                decorView.setSystemUiVisibility(uiOptions);
                            }
                        }).create().show();
            }
        });
    }
}