package com.example.diplwmatikh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;

public class Mainmenu extends universal {
    Button glwssikes, gnwstikes;
    ImageButton settings;
    FirebaseFirestore fStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        runtime();
        setContentView(R.layout.activity_mainmenu);

        glwssikes=findViewById(R.id.glwssikes);
        gnwstikes=findViewById(R.id.gnwstikes);
        settings=findViewById(R.id.settings);
        fStore=FirebaseFirestore.getInstance();
        fAuth=FirebaseAuth.getInstance();

        glwssikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Mainmenu.this, glwssikes_menu.class);
                startActivity(intent);
                intent=null;
            }
        });
        gnwstikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Mainmenu.this, gnwstikes_menu.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Mainmenu.this, settings.class);
                startActivity(intent);
            }
        });
        /*
        if(userID!=null){
            //------------bring data code--------------
            fetch_test = fStore.collection("users").document(UserID);
            fetch_test.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                    uname = value.getString("Username");
                    weclome_message.setText("Γειά σου " + uname);
                }
            });
            //------------bring data code--------------
        }

         */


        /*//------------bring data code2-------(a bit slower)-------
        DocumentReference fetch_name = fStore.collection("users").document(UserID);
        fetch_name.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        String uname = documentSnapshot.getString("Username");
                        weclome_message.setText("Γειά σου "+uname);
                    }
                });
        //------------bring data code end--------------

         */
    }
}