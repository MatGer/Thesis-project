package com.example.diplwmatikh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
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
    Button dragndrop, correct_wrong,place_in_order,logoutbutton,setscore,bringscore;
    TextView weclome_message;
    FirebaseFirestore fStore;
    String UserID, uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        runtime();
        setContentView(R.layout.activity_mainmenu);
        dragndrop=findViewById(R.id.dragndrop);
        correct_wrong=findViewById(R.id.correctwrong);
        place_in_order=findViewById(R.id.placeinorder);
        logoutbutton=findViewById(R.id.logout_mainmenu_button);
        weclome_message=findViewById(R.id.weclome_text);
        setscore=findViewById(R.id.set_score_button);
        bringscore=findViewById(R.id.bring_score_button);

        UserID=fAuth.getCurrentUser().getUid();

        //------------bring data code-------------- theloume na treksei mono mia fora gi ayto kanoume delete meta
        DocumentReference fetch_test = fStore.collection("users").document(UserID);
        fetch_test.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                uname = value.getString("Username");
                weclome_message.setText("Γειά σου " +uname);
            }
        });
        //------------bring data code--------------
        fetch_test.delete();


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
                fAuth.signOut();
                Intent intent = new Intent(Mainmenu.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        setscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload_score("activity1",7);
            }
        });

        bringscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_score("activity1", UserID);
            }
        });
    }
}