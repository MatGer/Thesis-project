package com.example.diplwmatikh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.google.firebase.firestore.FirebaseFirestore;

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


        glwssikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Mainmenu.this, glwssikes_menu.class);
                startActivity(intent);
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