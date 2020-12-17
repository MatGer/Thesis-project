package com.example.diplwmatikh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Source;

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
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore fStore=FirebaseFirestore.getInstance();
                DocumentReference fetch_mail = fStore.collection("users").document(userID);
                fetch_mail.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                        String mail=value.getString("Email");
                        fAuth.sendPasswordResetEmail(mail);
                        Toast.makeText(settings.this, "Σου έχει σταλεί ενα mail για την αλλαγή κωδικού.", Toast.LENGTH_SHORT).show();
                    }
                });
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
                                reset_score("add animals","scores");
                                reset_score("choose","scores");
                                reset_score("choose arrows","scores");
                                reset_score("choose description","scores");
                                reset_score("choose those who match","scores");
                                reset_score("complete the pattern","scores");
                                reset_score("drag 2 items","scores");
                                reset_score("drag and drop numbers","scores");
                                reset_score("drag items with audio","scores");
                                reset_score("find the path","scores");
                                reset_score("how many","scores");
                                reset_score("next number","scores");
                                reset_score("path_of_numbers2","scores");
                                reset_score("place in order","scores");
                                reset_score("select the bigger","scores");
                                reset_score("which one is different","scores");
                                reset_score("write height","scores");
                                reset_score("add animals","scores");

                                reset_score("add animals","buttons");
                                reset_score("choose","buttons");
                                reset_score("choose arrows","buttons");
                                reset_score("choose description","buttons");
                                reset_score("choose those who match","buttons");
                                reset_score("complete the pattern","buttons");
                                reset_score("drag 2 items","buttons");
                                reset_score("drag and drop numbers","buttons");
                                reset_score("drag items with audio","buttons");
                                reset_score("find the path","buttons");
                                reset_score("how many","buttons");
                                reset_score("next number","buttons");
                                reset_score("path_of_numbers2","buttons");
                                reset_score("place in order","buttons");
                                reset_score("select the bigger","buttons");
                                reset_score("which one is different","buttons");
                                reset_score("write height","buttons");
                                reset_score("add animals","buttons");

                                Toast.makeText(settings.this, "Οι βαθμολογίες σου διαγράφηκαν!", Toast.LENGTH_SHORT).show();
                                onResume();
                            }
                        })
                        .setNegativeButton("Άκυρο", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //restore ui elements
                                onResume();
                            }
                        }).create().show();
            }
        });
    }
}